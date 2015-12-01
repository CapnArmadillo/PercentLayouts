package com.armadillo;

import android.app.Activity;
import android.app.FragmentManager;
import android.view.View;
import android.view.View.OnClickListener;
import android.os.Bundle;
import android.widget.Button;
import android.widget.RadioButton;

import com.armadillo.percent.R;

import com.armadillo.linear.LinearFragment;
import com.armadillo.percent.PercentLayoutFragment;


public class MainActivity extends Activity {
	private static final String TAG = "MainActivity";
	private RadioButton percentButton, linearButton;
	private static final String ATTACHED_FRAGMENT = "AttachedFragment";
	private String attachedFragment;

	private static final String PERCENT_LAYOUT_FRAGMENT = "percentLayoutFragment";
	private static final String LINEAR_FRAGMENT = "linearFragment";

	private PercentLayoutFragment percentLayoutFragment;
	private LinearFragment linearFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
		percentButton = (RadioButton) findViewById(R.id.navPercent);
		percentButton.setOnClickListener(getMenuOnClickListener());
		linearButton =  (RadioButton) findViewById(R.id.navLinear);
		linearButton.setOnClickListener(getMenuOnClickListener());

        if (savedInstanceState == null) {
			attachPercentLayoutFragment();
        } else {
			attachedFragment = savedInstanceState.getString(ATTACHED_FRAGMENT);
			if (attachedFragment.equalsIgnoreCase(PERCENT_LAYOUT_FRAGMENT)) {
				attachPercentLayoutFragment();
			} else if (attachedFragment.equalsIgnoreCase(LINEAR_FRAGMENT)) {
				attachLinearFragment();
			}

		}


    }

	@Override
	public void onSaveInstanceState(Bundle outState) {
		super.onSaveInstanceState(outState);
		outState.putString(ATTACHED_FRAGMENT, attachedFragment);
	}

	public OnClickListener getMenuOnClickListener() {
		OnClickListener listener = new OnClickListener() {
			@Override
			public void onClick(View view) {
				String text = ((Button)view).getText().toString();
				if (text.equalsIgnoreCase(getString(R.string.percent))) {
					attachPercentLayoutFragment();
				} else if (text.equalsIgnoreCase(getString(R.string.linear))) {
					attachLinearFragment();
				}
			}
		};

		return listener;
	}

	public void attachPercentLayoutFragment() {
		percentButton.setChecked(true);
		attachedFragment = PERCENT_LAYOUT_FRAGMENT;
		FragmentManager fm = getFragmentManager();
		percentLayoutFragment = (PercentLayoutFragment)fm.findFragmentByTag(attachedFragment);
		if (percentLayoutFragment == null) {
			percentLayoutFragment = new PercentLayoutFragment();
		}

		getFragmentManager().beginTransaction()
				.replace(R.id.container, percentLayoutFragment, attachedFragment)
				.commit();
	}

	public void attachLinearFragment() {
		linearButton.setChecked(true);
		attachedFragment = LINEAR_FRAGMENT;
		FragmentManager fm = getFragmentManager();
		linearFragment = (LinearFragment)fm.findFragmentByTag(attachedFragment);
		if (linearFragment == null) {
			linearFragment = new LinearFragment();
		}

		getFragmentManager().beginTransaction()
				.replace(R.id.container, linearFragment, attachedFragment)
				.commit();
	}

}
