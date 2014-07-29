package com.example.myapp;

import android.app.FragmentManager;
import android.os.Bundle;
import android.preference.Preference;
import android.preference.PreferenceFragment;

/**
 * @author TechBirds
 * @date 14-7-22
 * @time 上午11:50
 * @vsersion 1.0
 */
public class MenuFragment extends PreferenceFragment implements Preference.OnPreferenceClickListener {
    int index = -1;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        //set the preference xml to the content view
        addPreferencesFromResource(R.xml.menu);
        //add listener
        findPreference("a").setOnPreferenceClickListener(this);
        findPreference("b").setOnPreferenceClickListener(this);
        findPreference("n").setOnPreferenceClickListener(this);
    }

    @Override
    public boolean onPreferenceClick(Preference preference) {
        String key = preference.getKey();
        if("a".equals(key)) {
            //if the content view is that we need to show . show directly
            if(index == 0) {
                ((MainActivity)getActivity()).getSlidingMenu().toggle();
                return true;
            }
            //otherwise , replace the content view via a new Content fragment
            index = 0;
            FragmentManager fragmentManager = ((MainActivity)getActivity()).getFragmentManager();
            fragmentManager.beginTransaction()
                    .replace(R.id.content, new ContentFragment("This is A Menu"))
                    .commit();
        }else if("b".equals(key)) {
            if(index == 1) {
                ((MainActivity)getActivity()).getSlidingMenu().toggle();
                return true;
            }
            index = 1;
            FragmentManager fragmentManager = ((MainActivity)getActivity()).getFragmentManager();
            fragmentManager.beginTransaction()
                    .replace(R.id.content, new ContentFragment("This is B Menu"))
                    .commit();
        }else if("n".equals(key)) {

            if(index == 2) {
                ((MainActivity)getActivity()).getSlidingMenu().toggle();
                return true;
            }
            index = 2;
            FragmentManager fragmentManager = ((MainActivity)getActivity()).getFragmentManager();
            fragmentManager.beginTransaction()
                    .replace(R.id.content, new ContentFragment("This is N Menu"))
                    .commit();
        }
        //anyway , show the sliding menu
        ((MainActivity)getActivity()).getSlidingMenu().toggle();
        return false;
    }
}
