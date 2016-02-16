package com.zhou.easemobui.common;

import android.os.Bundle;
import android.support.v4.app.Fragment;

/**
 * Created by ZhouYuzhen on 15/11/6.
 */
public class EM_ChatBaseFragment extends Fragment {

    private static final String TAG = EM_ChatBaseFragment.class.getName();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getActivity().getActionBar();
    }
}