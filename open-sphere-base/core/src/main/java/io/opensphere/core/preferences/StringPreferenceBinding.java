package io.opensphere.core.preferences;

import java.util.concurrent.Executor;

import javafx.beans.property.StringProperty;
import javafx.beans.value.ChangeListener;

import io.opensphere.core.util.Service;

/**
 * Handler that can update a String preference based on changes to a String
 * property and vice-versa.
 */
public class StringPreferenceBinding implements Service
{
    /** The property. */
    private final StringProperty myProperty;

    /** The key. */
    private final String myKey;

    /** The default value. */
    private final String myDefault;

    /** The prefs. */
    private final Preferences myPrefs;

    /** Listener for preferences changes. */
    private final PreferenceChangeListener myPrefsListener;

    /** The property listener. */
    private final ChangeListener<? super String> myPropertyListener;

    /** The executor to use for updating the property. */
    private final Executor myExecutor;

    /**
     * Constructor.
     *
     * @param property The property.
     * @param key The key.
     * @param def The default value to return if the key does not exist.
     * @param prefs The preferences.
     * @param executor The executor to use for updating the property
     */
    public StringPreferenceBinding(StringProperty property, String key, String def, Preferences prefs, Executor executor)
    {
        myProperty = property;
        myPrefs = prefs;
        myKey = key;
        myDefault = def;
        myExecutor = executor;
        myPrefsListener = evt -> myExecutor.execute(() -> myProperty.set(evt.getValueAsString(myDefault)));
        myPropertyListener = (v, o, n) -> myPrefs.putString(myKey, n, null);
    }

    @Override
    public void open()
    {
        myPrefs.addPreferenceChangeListener(myKey, myPrefsListener);
        myExecutor.execute(() ->
        {
            myProperty.set(myPrefs.getString(myKey, myDefault));
            myProperty.addListener(myPropertyListener);
        });
    }

    @Override
    public void close()
    {
        myPrefs.removePreferenceChangeListener(myKey, myPrefsListener);
        myExecutor.execute(() -> myProperty.removeListener(myPropertyListener));
    }

    /**
     * Gets the property.
     *
     * @return the property
     */
    public StringProperty getProperty()
    {
        return myProperty;
    }

    /**
     * Restores the default value in the preferences and property.
     */
    public void restoreDefault()
    {
        myPrefs.remove(myKey, null);
    }
}
