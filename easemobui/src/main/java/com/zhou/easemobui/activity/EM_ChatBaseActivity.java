package com.zhou.easemobui.activity;

import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.zhou.easemobui.R;

public class EM_ChatBaseActivity extends AppCompatActivity {

    private boolean isShow;

    private TextView titleView;
    private TextView backView;
    private LinearLayout leftIconsLayout;
    private LinearLayout rightIconsLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View customView = LayoutInflater.from(this).inflate(R.layout.em_action_bar,null);
        titleView = (TextView) customView.findViewById(R.id.em_action_bar_title);
        backView = (TextView) customView.findViewById(R.id.em_action_bar_back);
        leftIconsLayout = (LinearLayout) customView.findViewById(R.id.em_action_bar_left_icons);
        rightIconsLayout = (LinearLayout) customView.findViewById(R.id.em_action_bar_right_icons);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        actionBar.setCustomView(customView, new ActionBar.LayoutParams(ActionBar.LayoutParams.MATCH_PARENT, ActionBar.LayoutParams.MATCH_PARENT));
        actionBar.setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.em_common_background)));
    }

    @Override
    protected void onResume() {
        super.onResume();
        isShow = true;
    }

    @Override
    protected void onPause() {
        super.onPause();
        isShow = false;
    }

    public void setLeftIcon(View view, boolean clearOld) {
        if (clearOld) {
            leftIconsLayout.removeAllViews();
        }
        leftIconsLayout.setVisibility(View.VISIBLE);

        if (view != null) {
            LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
            leftIconsLayout.addView(view, lp);
        }
    }

    public void removeLeftIcon(View view) {
        leftIconsLayout.removeView(view);
    }

    public void clearLeftIcon() {
        leftIconsLayout.removeAllViews();
    }

    public void setRightIcon(View view, boolean clearOld) {
        if (clearOld) {
            rightIconsLayout.removeAllViews();
        }
        rightIconsLayout.setVisibility(View.VISIBLE);

        if (view != null) {
            LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
            rightIconsLayout.addView(view, lp);
        }
    }

    public void removeRightIcon(View view) {
        rightIconsLayout.removeView(view);
    }

    public void clearRightIcon() {
        rightIconsLayout.removeAllViews();
    }

    public void setTitle(String title) {
        setTitle(title, null);
    }

    public void setTitle(String title, View.OnClickListener listener) {
        titleView.setText(title);
        titleView.setOnClickListener(listener);
    }


}