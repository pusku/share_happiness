package com.rajon.sharehappiness.preferences;

import android.content.Context;
import android.preference.ListPreference;
import android.util.AttributeSet;

public class UpdateListPreference extends ListPreference {
    public UpdateListPreference(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public UpdateListPreference(Context context) {
        super(context);
    }

    @Override
    public void setValue(String value) {
        super.setValue(value);
        notifyChanged();
    }
}
