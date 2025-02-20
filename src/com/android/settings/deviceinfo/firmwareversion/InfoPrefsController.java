 /* Copyright (C) 2021 Project Radiant
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.android.settings.deviceinfo.firmwareversion;

import android.content.Context;
import android.os.SystemProperties;
import android.text.TextUtils;
import com.spark.utils.SpecUtils;

import androidx.preference.Preference;
import androidx.preference.PreferenceScreen;

import com.android.settings.R;
import com.android.settings.core.PreferenceControllerMixin;
import com.android.settingslib.core.AbstractPreferenceController;

public class InfoPrefsController extends AbstractPreferenceController implements
        PreferenceControllerMixin {

    private static final String KEY_STORAGE = "storage";
    private static final String KEY_CHIPSET = "chipset";
    private static final String KEY_BATTERY = "battery";
    private static final String KEY_DISPLAY = "display";

    public InfoPrefsController(Context context) {
        super(context);
    }

    @Override
    public boolean isAvailable() {
        return true;
    }

    @Override
    public void displayPreference(PreferenceScreen screen) {
        super.displayPreference(screen);
        final Preference stPref = screen.findPreference(KEY_STORAGE);
        final Preference chipPref = screen.findPreference(KEY_CHIPSET);
        final Preference batPref = screen.findPreference(KEY_BATTERY);
        final Preference disPref = screen.findPreference(KEY_DISPLAY);

        stPref.setSummary(String.valueOf(SpecUtils.getTotalInternalMemorySize()) + "GB ROM + " + String.valueOf(SpecUtils.getTotalRAM()) + "GB RAM");
        chipPref.setSummary(SpecUtils.getProcessorModel());
        batPref.setSummary(SpecUtils.getBatteryCapacity(mContext) + " mAh");
        disPref.setSummary(SpecUtils.getScreenRes(mContext)); 
    }

    @Override
    public String getPreferenceKey() {
        return KEY_STORAGE;
    }
} 
