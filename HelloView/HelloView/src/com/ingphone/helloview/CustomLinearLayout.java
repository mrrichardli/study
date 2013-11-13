package com.ingphone.helloview;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.LinearLayout;

public class CustomLinearLayout extends LinearLayout {

	public CustomLinearLayout(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
	}

	public CustomLinearLayout(Context context, AttributeSet attrs) {
		super(context, attrs);
		// TODO Auto-generated constructor stub
	}

	@SuppressLint("NewApi")
	public CustomLinearLayout(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		// TODO Auto-generated constructor stub
	}
	private int i = 0;
	public boolean onInterceptTouchEvent (MotionEvent ev) {
		Log.i("HelloView", "onInterceptTouchEvent");
		i++;
		if (i % 40 == 0) {
			return true;
		}
		return false;
	}

	public boolean onTouchEvent (MotionEvent event) {
		int pointerCount = event.getPointerCount();
		
		String actionString = null;
		switch(event.getAction()) {
		case MotionEvent.ACTION_CANCEL:
			actionString = "ACTION_CANCEL";
			break;
		case MotionEvent.ACTION_DOWN:
			actionString = "ACTION_DOWN";
			break;
		case MotionEvent.ACTION_MOVE:
			actionString = "ACTION_MOVE";
			break;
		case MotionEvent.ACTION_OUTSIDE:
			actionString = "ACTION_OUTSIDE";
			break;
		case MotionEvent.ACTION_UP:
			actionString = "ACTION_UP";
			break;
			default:
				actionString = "" + event.getAction();
		}
		
		Log.i("HelloView", "Activity received action is " + actionString);

//	     System.out.printf("At time %d:", event.getEventTime());
	     for (int p = 0; p < pointerCount; p++) {
//	    	 Log.i("HelloView", "pointer " + event.getPointerId(p) + ", ( x: " +event.getX(p) + "\t, y: " + event.getY(p) + "\t)");
	     }
	     return true;
	}
	
}
