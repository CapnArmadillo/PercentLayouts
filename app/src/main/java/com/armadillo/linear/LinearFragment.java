package com.armadillo.linear;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.RadioButton;

import com.armadillo.common.DLog;
import com.armadillo.percent.R;

/**
 * Created by john.pushnik on 5/8/15.
 */
public class LinearFragment extends Fragment {
	private static final String TAG = "LinearFragment";

	private RadioButton widthAll, zeroDP, wrapContent, matchParent, weightAll, weight0, weight1, weight2;
	private View zeroDP0label, zeroDP0, zeroDP1label, zeroDP1, zeroDP2label, zeroDP2;
	private View wrapContent0label, wrapContent0, wrapContent1label, wrapContent1, wrapContent2label, wrapContent2, wrapContent3label, wrapContent3;
	private View matchParent0label, matchParent0, matchParent1label, matchParent1, matchParent2label, matchParent2;
	private View matchParent3label, matchParent3, various1label, various1, various2label, various2;
	public LinearFragment() {
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
							 Bundle savedInstanceState) {
		DLog.i();
		View rootView = inflater.inflate(R.layout.fragment_linear, container, false);

		widthAll = (RadioButton)rootView.findViewById(R.id.widthAll);
		zeroDP = (RadioButton)rootView.findViewById(R.id.zeroDP);
		wrapContent = (RadioButton)rootView.findViewById(R.id.wrapContent);
		matchParent = (RadioButton)rootView.findViewById(R.id.matchParent);
		weightAll = (RadioButton)rootView.findViewById(R.id.weightAll);
		weight0 = (RadioButton)rootView.findViewById(R.id.weight0);
		weight1 = (RadioButton)rootView.findViewById(R.id.weight1);
		weight2 = (RadioButton)rootView.findViewById(R.id.weight2);

		setOnClickListener(widthAll);
		setOnClickListener(zeroDP);
		setOnClickListener(wrapContent);
		setOnClickListener(matchParent);
		setOnClickListener(weightAll);
		setOnClickListener(weight0);
		setOnClickListener(weight1);
		setOnClickListener(weight2);

		zeroDP0 = rootView.findViewById(R.id.zeroDP0);
		zeroDP0label = rootView.findViewById(R.id.zeroDP0label);
		zeroDP1 = rootView.findViewById(R.id.zeroDP1);
		zeroDP1label = rootView.findViewById(R.id.zeroDP1label);
		zeroDP2 = rootView.findViewById(R.id.zeroDP2);
		zeroDP2label = rootView.findViewById(R.id.zeroDP2label);
		wrapContent0 = rootView.findViewById(R.id.wrapContent0);
		wrapContent0label = rootView.findViewById(R.id.wrapContent0label);
		wrapContent1 = rootView.findViewById(R.id.wrapContent1);
		wrapContent1label = rootView.findViewById(R.id.wrapContent1label);
		wrapContent2 = rootView.findViewById(R.id.wrapContent2);
		wrapContent2label = rootView.findViewById(R.id.wrapContent2label);
		wrapContent3 = rootView.findViewById(R.id.wrapContent3);
		wrapContent3label = rootView.findViewById(R.id.wrapContent3label);
		matchParent0 = rootView.findViewById(R.id.matchParent0);
		matchParent0label = rootView.findViewById(R.id.matchParent0label);
		matchParent1 = rootView.findViewById(R.id.matchParent1);
		matchParent1label = rootView.findViewById(R.id.matchParent1label);
		matchParent2 = rootView.findViewById(R.id.matchParent2);
		matchParent2label = rootView.findViewById(R.id.matchParent2label);
		matchParent3 = rootView.findViewById(R.id.matchParent3);
		matchParent3label = rootView.findViewById(R.id.matchParent3label);
		various1 = rootView.findViewById(R.id.various1);
		various1label = rootView.findViewById(R.id.various1label);
		various2 = rootView.findViewById(R.id.various2);
		various2label = rootView.findViewById(R.id.various2label);

		return rootView;
	}

	public void setOnClickListener(RadioButton button) {
		button.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
			@Override
			public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
				showViews();
			}
		});
	}

	public void showViews() {
		if ((zeroDP.isChecked() || widthAll.isChecked()) && (weight0.isChecked() || weightAll.isChecked())) {
			zeroDP0.setVisibility(View.VISIBLE);
			zeroDP0label.setVisibility(View.VISIBLE);
		} else {
			zeroDP0.setVisibility(View.GONE);
			zeroDP0label.setVisibility(View.GONE);
		}
		if ((wrapContent.isChecked() || widthAll.isChecked()) && (weight0.isChecked() || weightAll.isChecked())) {
			wrapContent0.setVisibility(View.VISIBLE);
			wrapContent0label.setVisibility(View.VISIBLE);
		} else {
			wrapContent0.setVisibility(View.GONE);
			wrapContent0label.setVisibility(View.GONE);
		}
		if ((matchParent.isChecked() || widthAll.isChecked()) && (weight0.isChecked() || weightAll.isChecked())) {
			matchParent0.setVisibility(View.VISIBLE);
			matchParent0label.setVisibility(View.VISIBLE);
		} else {
			matchParent0.setVisibility(View.GONE);
			matchParent0label.setVisibility(View.GONE);
		}
		if ((zeroDP.isChecked() || widthAll.isChecked()) && (weight1.isChecked() || weightAll.isChecked())) {
			zeroDP1.setVisibility(View.VISIBLE);
			zeroDP1label.setVisibility(View.VISIBLE);
		} else {
			zeroDP1.setVisibility(View.GONE);
			zeroDP1label.setVisibility(View.GONE);
		}
		if ((wrapContent.isChecked() || widthAll.isChecked()) && (weight1.isChecked() || weightAll.isChecked())) {
			wrapContent1.setVisibility(View.VISIBLE);
			wrapContent1label.setVisibility(View.VISIBLE);
		} else {
			wrapContent1.setVisibility(View.GONE);
			wrapContent1label.setVisibility(View.GONE);
		}
		if ((matchParent.isChecked() || widthAll.isChecked()) && (weight1.isChecked() || weightAll.isChecked())) {
			matchParent1.setVisibility(View.VISIBLE);
			matchParent1label.setVisibility(View.VISIBLE);
		} else {
			matchParent1.setVisibility(View.GONE);
			matchParent1label.setVisibility(View.GONE);
		}
		if ((zeroDP.isChecked() || widthAll.isChecked()) && (weight2.isChecked() || weightAll.isChecked())) {
			zeroDP2.setVisibility(View.VISIBLE);
			zeroDP2label.setVisibility(View.VISIBLE);
		} else {
			zeroDP2.setVisibility(View.GONE);
			zeroDP2label.setVisibility(View.GONE);
		}
		if ((wrapContent.isChecked() || widthAll.isChecked()) && (weight2.isChecked() || weightAll.isChecked())) {
			wrapContent2.setVisibility(View.VISIBLE);
			wrapContent2label.setVisibility(View.VISIBLE);
			wrapContent3.setVisibility(View.VISIBLE);
			wrapContent3label.setVisibility(View.VISIBLE);
		} else {
			wrapContent2.setVisibility(View.GONE);
			wrapContent2label.setVisibility(View.GONE);
			wrapContent3.setVisibility(View.GONE);
			wrapContent3label.setVisibility(View.GONE);
		}
		if ((matchParent.isChecked() || widthAll.isChecked()) && (weight2.isChecked() || weightAll.isChecked())) {
			matchParent2.setVisibility(View.VISIBLE);
			matchParent2label.setVisibility(View.VISIBLE);
		} else {
			matchParent2.setVisibility(View.GONE);
			matchParent2label.setVisibility(View.GONE);
		}
		if ((matchParent.isChecked() || widthAll.isChecked()) && weightAll.isChecked()) {
			matchParent3.setVisibility(View.VISIBLE);
			matchParent3label.setVisibility(View.VISIBLE);
		} else {
			matchParent3.setVisibility(View.GONE);
			matchParent3label.setVisibility(View.GONE);
		}
		if (widthAll.isChecked() && (weight1.isChecked() || weightAll.isChecked())) {
			various1.setVisibility(View.VISIBLE);
			various1label.setVisibility(View.VISIBLE);
		} else {
			various1.setVisibility(View.GONE);
			various1label.setVisibility(View.GONE);
		}
		if (widthAll.isChecked() && weightAll.isChecked()) {
			various2.setVisibility(View.VISIBLE);
			various2label.setVisibility(View.VISIBLE);
		} else {
			various2.setVisibility(View.GONE);
			various2label.setVisibility(View.GONE);
		}
	}
}

