package com.ingphone.hellofragment;

import com.example.hellofragment.R;

import android.app.Activity;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class FragmentOne extends Fragment {
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstance) {
		return inflater.inflate(R.layout.activity_fragment_two, container,
				false);
	}

	@Override
	public void onInflate(Activity activity, AttributeSet attrs,
			Bundle savedInstanceState) {
		super.onInflate(activity, attrs, savedInstanceState);
		Log.v("HelloFragmentArguments", "onInflate called");

		TypedArray a = activity.obtainStyledAttributes(attrs,
				R.styleable.FragmentOne);

		CharSequence myString = a
				.getText(R.styleable.FragmentOne_extraInformation);
		if (myString != null) {
			Log.e("HelloFragmentArguments",
					"My String Received : " + myString.toString());
		}
		
		float mFraction = a.getFraction(R.styleable.FragmentOne_fraction, 1, 1, 0);
		Log.e("HelloFragmentArguments", "fraction is " + mFraction);

		a.recycle();
	}

}
