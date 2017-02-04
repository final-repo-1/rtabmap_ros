package com.introlab.rtabmap;

import android.app.Activity;
import android.content.SharedPreferences;
import android.content.SharedPreferences.OnSharedPreferenceChangeListener;
import android.os.Bundle;
import android.preference.ListPreference;
import android.preference.Preference;
import android.preference.PreferenceActivity;
import android.preference.PreferenceManager;

public class SettingsActivity extends PreferenceActivity implements OnSharedPreferenceChangeListener {
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.layout.activity_settings);
        
        Preference button = findPreference(getString(R.string.pref_key_reset_button));
        button.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {
        	@Override
        	public boolean onPreferenceClick(Preference preference) {   
        		getPreferenceScreen().getSharedPreferences().edit().clear().commit();
        		
                recreate();
        		
        		return true;
        	}
        });
        
        ((Preference)findPreference(getString(R.string.pref_key_decimation))).setSummary("("+((ListPreference)findPreference(getString(R.string.pref_key_decimation))).getEntry() + ") "+getString(R.string.pref_summary_decimation));
        ((Preference)findPreference(getString(R.string.pref_key_depth))).setSummary("("+((ListPreference)findPreference(getString(R.string.pref_key_depth))).getEntry() + ") "+getString(R.string.pref_summary_depth));
        ((Preference)findPreference(getString(R.string.pref_key_point_size))).setSummary("("+((ListPreference)findPreference(getString(R.string.pref_key_point_size))).getEntry() + ") "+getString(R.string.pref_summary_point_size));
        ((Preference)findPreference(getString(R.string.pref_key_angle))).setSummary("("+((ListPreference)findPreference(getString(R.string.pref_key_angle))).getEntry() + ") "+getString(R.string.pref_summary_angle));
        ((Preference)findPreference(getString(R.string.pref_key_triangle))).setSummary("("+((ListPreference)findPreference(getString(R.string.pref_key_triangle))).getEntry() + ") "+getString(R.string.pref_summary_triangle));
   
        ((Preference)findPreference(getString(R.string.pref_key_update_rate))).setSummary("("+((ListPreference)findPreference(getString(R.string.pref_key_update_rate))).getEntry() + ") "+getString(R.string.pref_summary_update_rate));
        ((Preference)findPreference(getString(R.string.pref_key_time_thr))).setSummary("("+((ListPreference)findPreference(getString(R.string.pref_key_time_thr))).getEntry() + ") "+getString(R.string.pref_summary_time_thr));
        ((Preference)findPreference(getString(R.string.pref_key_loop_thr))).setSummary("("+((ListPreference)findPreference(getString(R.string.pref_key_loop_thr))).getEntry() + ") "+getString(R.string.pref_summary_loop_thr));
        ((Preference)findPreference(getString(R.string.pref_key_opt_error))).setSummary("("+((ListPreference)findPreference(getString(R.string.pref_key_opt_error))).getEntry() + ") "+getString(R.string.pref_summary_opt_error));
        ((Preference)findPreference(getString(R.string.pref_key_features))).setSummary("("+((ListPreference)findPreference(getString(R.string.pref_key_features))).getEntry() + ") "+getString(R.string.pref_summary_features));
        ((Preference)findPreference(getString(R.string.pref_key_features_type))).setSummary("("+((ListPreference)findPreference(getString(R.string.pref_key_features_type))).getEntry() + ") "+getString(R.string.pref_summary_features_type));
        
        ((Preference)findPreference(getString(R.string.pref_key_cloud_voxel))).setSummary("("+((ListPreference)findPreference(getString(R.string.pref_key_cloud_voxel))).getEntry() + ") "+getString(R.string.pref_summary_cloud_voxel));
        ((Preference)findPreference(getString(R.string.pref_key_texture_size))).setSummary("("+((ListPreference)findPreference(getString(R.string.pref_key_texture_size))).getEntry() + ") "+getString(R.string.pref_summary_texture_size));
        ((Preference)findPreference(getString(R.string.pref_key_normal_k))).setSummary("("+((ListPreference)findPreference(getString(R.string.pref_key_normal_k))).getEntry() + ") "+getString(R.string.pref_summary_normal_k));

        ((Preference)findPreference(getString(R.string.pref_key_opt_depth))).setSummary("("+((ListPreference)findPreference(getString(R.string.pref_key_opt_depth))).getEntry() + ") "+getString(R.string.pref_summary_opt_depth));
        ((Preference)findPreference(getString(R.string.pref_key_opt_decimation_factor))).setSummary("("+((ListPreference)findPreference(getString(R.string.pref_key_opt_decimation_factor))).getValue() + "%%) "+getString(R.string.pref_summary_opt_decimation_factor));
        ((Preference)findPreference(getString(R.string.pref_key_opt_color_radius))).setSummary("("+((ListPreference)findPreference(getString(R.string.pref_key_opt_color_radius))).getEntry() + ") "+getString(R.string.pref_summary_opt_color_radius));
    
        ((Preference)findPreference(getString(R.string.pref_key_min_cluster_size))).setSummary("("+((ListPreference)findPreference(getString(R.string.pref_key_min_cluster_size))).getEntry() + ") "+getString(R.string.pref_summary_min_cluster_size));
        ((Preference)findPreference(getString(R.string.pref_key_gain_max_radius))).setSummary("("+((ListPreference)findPreference(getString(R.string.pref_key_gain_max_radius))).getEntry() + ") "+getString(R.string.pref_summary_gain_max_radius));
    }
    
    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String key) {
        Preference pref = findPreference(key);

        if (pref instanceof ListPreference) {
        	if(key.compareTo(getString(R.string.pref_key_decimation))==0) pref.setSummary("("+ ((ListPreference)pref).getEntry() + ") "+getString(R.string.pref_summary_decimation));
        	if(key.compareTo(getString(R.string.pref_key_depth))==0) pref.setSummary("("+((ListPreference)pref).getEntry() + ") "+getString(R.string.pref_summary_depth));
        	if(key.compareTo(getString(R.string.pref_key_point_size))==0) pref.setSummary("("+((ListPreference)pref).getEntry() + ") "+getString(R.string.pref_summary_point_size));
        	if(key.compareTo(getString(R.string.pref_key_angle))==0) pref.setSummary("("+((ListPreference)pref).getEntry() + ") "+getString(R.string.pref_summary_angle));
        	if(key.compareTo(getString(R.string.pref_key_triangle))==0) pref.setSummary("("+((ListPreference)pref).getEntry() + ") "+getString(R.string.pref_summary_triangle));
        	
        	if(key.compareTo(getString(R.string.pref_key_update_rate))==0) pref.setSummary("("+((ListPreference)pref).getEntry() + ") "+getString(R.string.pref_summary_update_rate));
        	if(key.compareTo(getString(R.string.pref_key_time_thr))==0) pref.setSummary("("+((ListPreference)pref).getEntry() + ") "+getString(R.string.pref_summary_time_thr));
        	if(key.compareTo(getString(R.string.pref_key_loop_thr))==0) pref.setSummary("("+((ListPreference)pref).getEntry() + ") "+getString(R.string.pref_summary_loop_thr));
        	if(key.compareTo(getString(R.string.pref_key_opt_error))==0) pref.setSummary("("+((ListPreference)pref).getEntry() + ") "+getString(R.string.pref_summary_opt_error));
        	if(key.compareTo(getString(R.string.pref_key_features))==0) pref.setSummary("("+((ListPreference)pref).getEntry() + ") "+getString(R.string.pref_summary_features));
        	if(key.compareTo(getString(R.string.pref_key_features_type))==0) pref.setSummary("("+((ListPreference)pref).getEntry() + ") "+getString(R.string.pref_summary_features_type));
        	
        	if(key.compareTo(getString(R.string.pref_key_cloud_voxel))==0) pref.setSummary("("+((ListPreference)pref).getEntry() + ") "+getString(R.string.pref_summary_cloud_voxel));
        	if(key.compareTo(getString(R.string.pref_key_texture_size))==0) pref.setSummary("("+((ListPreference)pref).getEntry() + ") "+getString(R.string.pref_summary_texture_size));
        	if(key.compareTo(getString(R.string.pref_key_normal_k))==0) pref.setSummary("("+((ListPreference)pref).getEntry() + ") "+getString(R.string.pref_summary_normal_k));

        	if(key.compareTo(getString(R.string.pref_key_opt_depth))==0) pref.setSummary("("+((ListPreference)pref).getEntry() + ") "+getString(R.string.pref_summary_opt_depth));
        	if(key.compareTo(getString(R.string.pref_key_opt_decimation_factor))==0) pref.setSummary("("+((ListPreference)pref).getValue() + "%%) "+getString(R.string.pref_summary_opt_decimation_factor));
        	if(key.compareTo(getString(R.string.pref_key_opt_color_radius))==0) pref.setSummary("("+((ListPreference)pref).getEntry() + ") "+getString(R.string.pref_summary_opt_color_radius));
        	
        	if(key.compareTo(getString(R.string.pref_key_min_cluster_size))==0) pref.setSummary("("+((ListPreference)pref).getEntry() + ") "+getString(R.string.pref_summary_min_cluster_size));
        	if(key.compareTo(getString(R.string.pref_key_gain_max_radius))==0) pref.setSummary("("+((ListPreference)pref).getEntry() + ") "+getString(R.string.pref_summary_gain_max_radius));
        
        }
    }
    
    @Override
    protected void onResume() {
        super.onResume();
        // Set up a listener whenever a key changes
        getPreferenceScreen().getSharedPreferences()
                .registerOnSharedPreferenceChangeListener(this);
    }

    @Override
    protected void onPause() {
        super.onPause();
        // Unregister the listener whenever a key changes
        getPreferenceScreen().getSharedPreferences()
                .unregisterOnSharedPreferenceChangeListener(this);
    }
}