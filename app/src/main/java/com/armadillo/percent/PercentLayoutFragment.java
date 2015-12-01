package com.armadillo.percent;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.ToggleButton;

import com.armadillo.percent.R;
import com.armadillo.common.DLog;

/**
 * Created by john.pushnik on 10/30/15.
 *
 * Examines the new PercentLayouts
 *
 * https://developer.android.com/reference/android/support/percent/PercentFrameLayout.html
 * https://developer.android.com/reference/android/support/percent/PercentRelativeLayout.html
 *
 * https://developer.android.com/reference/android/support/percent/PercentLayoutHelper.html
 *
 * including https://github.com/JulienGenoud/android-percent-support-lib-sample
 */
public class PercentLayoutFragment extends Fragment {
    private static final String TAG = "PercentLayoutFragment";

    private View view;
    private ToggleButton showHalf, showQuarter, showFifth, showDecimal;
    private ToggleButton showRelative, showVertical, showHorizontal, showLinear;
    private View gridHalf, gridQuarter, gridFifth, gridDecimal;
    private ViewGroup graph, vertical, horizontal, linear;

    private boolean treeLoaded = false;

    public PercentLayoutFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        DLog.i();
        view = inflater.inflate(R.layout.fragment_percent, container, false);

        view.getViewTreeObserver().addOnGlobalLayoutListener(globalLayoutListener);

        showHalf = (ToggleButton)view.findViewById(R.id.button_half);
        showQuarter = (ToggleButton)view.findViewById(R.id.button_quarter);
        showFifth = (ToggleButton)view.findViewById(R.id.button_fifth);
        showDecimal = (ToggleButton)view.findViewById(R.id.button_decimal);

        gridHalf = view.findViewById(R.id.grid_half);
        gridQuarter = view.findViewById(R.id.grid_quarter);
        gridFifth = view.findViewById(R.id.grid_fifth);
        gridDecimal = view.findViewById(R.id.grid_decimal);

        setListener(showHalf, gridHalf);
        setListener(showQuarter, gridQuarter);
        setListener(showFifth, gridFifth);
        setListener(showDecimal, gridDecimal);

        showRelative = (ToggleButton)view.findViewById(R.id.button_relative);
        showVertical = (ToggleButton)view.findViewById(R.id.button_vertical);
        showHorizontal = (ToggleButton)view.findViewById(R.id.button_horizontal);
        showLinear = (ToggleButton)view.findViewById(R.id.button_linear);

        graph = (ViewGroup)view.findViewById(R.id.graph);
        vertical = (ViewGroup)view.findViewById(R.id.percent_vertical);
        horizontal = (ViewGroup)view.findViewById(R.id.percent_horizontal);
        linear = (ViewGroup)view.findViewById(R.id.linear_horizontal);

        setListener(showRelative, graph);
        setListener(showVertical, vertical);
        setListener(showHorizontal, horizontal);
        setListener(showLinear, linear);

        return view;
    }

    public void setListener(CompoundButton button, final View target) {
        button.setOnCheckedChangeListener(getShowOnClick(target));
    }

    public CompoundButton.OnCheckedChangeListener getShowOnClick(final View target) {
        CompoundButton.OnCheckedChangeListener listener = new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    target.setVisibility(View.VISIBLE);
                } else {
                    target.setVisibility(View.INVISIBLE);
                }
            }
        };
        return listener;
    }

    public void setText(TextView view) {
        String tag = (String)view.getTag();
        int x, y, width, height;
        x = (int)view.getX();
        y = (int)view.getY();
        width = view.getWidth();
        height = view.getHeight();
        view.setText(tag + "\n(" + x + "," + y + "," + width + "," + height + ")");
    }

    public void setTexts(ViewGroup group) {
        treeLoaded = true;
        for (int i = 0; i < group.getChildCount(); i++) {
            View subView = group.getChildAt(i);
            if (subView instanceof TextView) {
                setText((TextView)subView);
            }
        }
    }

    private ViewTreeObserver.OnGlobalLayoutListener globalLayoutListener =  new ViewTreeObserver.OnGlobalLayoutListener() {
        @Override
        public void onGlobalLayout() {
            DLog.i();

            int width = view.getWidth();
            if (treeLoaded) {
                return;
            } else if (width > 0) {
                setTexts(graph);
                setTexts(vertical);
                setTexts(horizontal);
                setTexts(linear);
                if (android.os.Build.VERSION.SDK_INT >= 16) {
                    view.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                } else {
                    view.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                }
            }
        }
    };

    @Override
    public void onResume() {
        super.onResume();
        treeLoaded = false;
    }

}
