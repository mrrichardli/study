package com.ingphone.hellocustomview;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.Button;

public class CustomButton extends Button {

	public CustomButton(Context context, AttributeSet attrs) {
		super(context, attrs);

		TypedArray ta = context.obtainStyledAttributes(attrs,
				R.styleable.CustomButton, 0, 0);
		String extraText = ta.getString(R.styleable.CustomButton_extraText);
		Log.i("HelloCustomView", extraText);
		ta.recycle();
	}

}
