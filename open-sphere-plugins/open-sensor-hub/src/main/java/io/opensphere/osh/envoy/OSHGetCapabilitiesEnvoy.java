package io.opensphere.osh.envoy;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import io.opensphere.core.Toolbox;
import io.opensphere.core.cache.CacheDeposit;
import io.opensphere.core.cache.CacheException;
import io.opensphere.core.cache.DefaultCacheDeposit;
import io.opensphere.core.cache.accessor.UnserializableAccessor;
import io.opensphere.core.cache.matcher.PropertyMatcher;
import io.opensphere.core.cache.util.PropertyDescriptor;
import io.opensphere.core.data.CacheDepositReceiver;
import io.opensphere.core.data.QueryException;
import io.opensphere.core.data.util.DataModelCategory;
import io.opensphere.core.data.util.OrderSpecifier;
import io.opensphere.core.data.util.Query;
import io.opensphere.core.data.util.Satisfaction;
import io.opensphere.core.util.net.UrlUtilities;
import io.opensphere.core.util.taskactivity.TaskActivity;
import io.opensphere.osh.model.Offering;
import io.opensphere.osh.sos.GetCapabilitiesHandler;
import io.opensphere.osh.util.OSHRegistryUtils;

/** OpenSensorHub get capabilities envoy. */
public class OSHGetCapabilitiesEnvoy extends AbstractOSHEnvoy
{
    /**
     * Constructor.
     *
     * @param toolbox the toolbox
     */
    public OSHGetCapabilitiesEnvoy(Toolbox toolbox)
    {
        super(toolbox);
    }

    @Override
    public boolean providesDataFor(DataModelCategory category)
    {
        return OSHRegistryUtils.GET_CAPABILITIES_FAMILY.equals(category.getFamily());
    }

    @Override
    public void query(DataModelCategory category, Collection<? extends Satisfaction> satisfactions,
            List<? extends PropertyMatcher<?>> parameters, List<? extends OrderSpecifier> orderSpecifiers, int limit,
            Collection<? extends PropertyDescriptor<?>> propertyDescriptors, CacheDepositReceiver queryReceiver)
        throws QueryException
    {
        try (TaskActivity ta = TaskActivity.createActive("Querying OpenSensorHub capabilities"))
        {
            getToolbox().getUIRegistry().getMenuBarRegistry().addTaskActivity(ta);
            query(category, queryReceiver);
        }
    }

    /**
     * Performs the query.
     *
     * @param category The data model category.
     * @param queryReceiver An object that will receive {@link Query} objects
     *            produced by this data provider.
     * @throws QueryException If there is a problem with the query.
     */
    void query(DataModelCategory category, CacheDepositReceiver queryReceiver) throws QueryException
    {
        URL baseUrl = UrlUtilities.toURL(OSHRegistryUtils.getUrl(category) + "?service=SOS&version=2.0&request=GetCapabilities");

        try (InputStream responseStream = performRequest(baseUrl))
        {
            Collection<Offering> results = parseResponse(responseStream);
            if (!results.isEmpty())
            {
                queryReceiver.receive(new DefaultCacheDeposit<>(category,
                        Collections
                                .singleton(UnserializableAccessor.getHomogeneousAccessor(OSHRegistryUtils.GET_CAPABILITIES_DESCRIPTOR)),
                        results, true, CacheDeposit.SESSION_END, true));
            }
        }
        catch (IOException | CacheException e)
        {
            throw new QueryException(e);
        }
    }

    /**
     * Parses the input stream into java objects.
     *
     * @param stream the input stream to parse
     * @return the java objects
     * @throws IOException if a problem occurred reading the stream
     */
    private Collection<Offering> parseResponse(InputStream stream) throws IOException
    {
        return GetCapabilitiesHandler.parse(stream);
    }
}
