package com.ingphone.hellopopupwindow;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.LinearLayout;

public class CustomLinearLayout extends LinearLayout {

@SuppressLint("NewApi")
public CustomLinearLayout(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
	}

	public CustomLinearLayout(Context context) {
		super(context);
	}

	public CustomLinearLayout(Context context, AttributeSet attrs) {
		super(context, attrs);
	}

	@Override
	public boolean onTouchEvent(MotionEvent motionEvent) {
		if (motionEvent.getAction() == MotionEvent.ACTION_OUTSIDE) {
			Log.i("HelloPopupWindow", "ACTION_OUTSIDE");
		}
		return true;
	}
}
