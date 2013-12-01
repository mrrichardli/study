package com.ingphone.hellofragment;

import com.ingphone.hellofragmentattributes.R;

import android.app.Activity;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class FragmentOne extends Fragment {
	
	private int mStringReferenceValue;
	private int mColorReferenceValue;
	private int mDrawableReferenceValue;

	private int mReferenceValue;
	private String mStringValue;
	private int mColorValue;
	private float mDimensionValue;
	private boolean mBooleanValue;
	private int mIntegerValue;
	private float mFloatValue;
	private float mFractionValue;
	private int mEnumValue;
	private int mFlagValue;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstance) {
		View view = (View) inflater.inflate(R.layout.activity_fragment_one, container,
				false);
		
		TextView referenceString = (TextView)view.findViewById(R.id.referenceString);
		referenceString.setText(mStringReferenceValue);
		
		View referenceColor = (View)view.findViewById(R.id.referenceColor);
		referenceColor.setBackgroundColor(getActivity().getResources().getColor(mColorReferenceValue));
		
		ImageView referenceDrawable = (ImageView)view.findViewById(R.id.referenceDrawable);
		referenceDrawable.setImageResource(mDrawableReferenceValue);
		
		return view;
	}

	@Override
	public void onInflate(Activity activity, AttributeSet attrs,
			Bundle savedInstanceState) {
		super.onInflate(activity, attrs, savedInstanceState);
		Log.v("HelloFragmentArguments", "onInflate called");

		TypedArray a = activity.obtainStyledAttributes(attrs,
				R.styleable.FragmentOne);
		
		mStringReferenceValue = a.getResourceId(R.styleable.FragmentOne_stringReferenceValue, 0);
		mColorReferenceValue = a.getResourceId(R.styleable.FragmentOne_colorReferenceValue, 0);
		mDrawableReferenceValue = a.getResourceId(R.styleable.FragmentOne_drawableReferenceValue, 0);
		
		mReferenceValue = a.getResourceId(R.styleable.FragmentOne_referenceValue, 0);
		mStringValue = a.getString(R.styleable.FragmentOne_stringValue);
		mColorValue = a.getColor(R.styleable.FragmentOne_colorValue, 0);
		mDimensionValue = a.getDimension(R.styleable.FragmentOne_dimensionValue, 0.0f);
		mBooleanValue = a.getBoolean(R.styleable.FragmentOne_booleanValue, false);
		mIntegerValue = a.getInt(R.styleable.FragmentOne_integerValue, 0);
		mFloatValue = a.getFloat(R.styleable.FragmentOne_floatValue, 0.0f);
		mFractionValue = a.getFraction(R.styleable.FragmentOne_fractionValue, 1, 1, 0.0f);
		mEnumValue = a.getInt(R.styleable.FragmentOne_enumValue, 0);
		mFlagValue = a.getInt(R.styleable.FragmentOne_flagValue, 0);
		
		Log.i("HelloFragmentAttributes", "\n==========\n" +
		"attributes are:\n" +
				"mReferenceValue\t"	+ mReferenceValue 	+ "\n" +
				"mStringValue:\t"		+ mStringValue		+ "\n" +
				"mColorValue:\t"		+ mColorValue		+ "\n" +
				"mDimensionValue:\t"	+ mDimensionValue	+ "\n" +
				"mBooleanValue:\t"		+ mBooleanValue		+ "\n" +
				"mIntegerValue:\t"		+ mIntegerValue		+ "\n" +
				"mFloatValue:\t"		+ mFloatValue		+ "\n" +
				"mFractionValue:\t"		+ mFractionValue	+ "\n" +
				"mEnumValue:\t"			+ mEnumValue		+ "\n" +
				"mFlagValue:\t"			+ mFlagValue		+ "\n" +
				"==========\n"
		);

		a.recycle();
	}
}
