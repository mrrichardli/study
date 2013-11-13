package com.ingphone.helloview;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

public class CustomView extends View {

	public CustomView(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
	}

	public CustomView(Context context, AttributeSet attrs) {
		super(context, attrs);
		// TODO Auto-generated constructor stub
	}

	public CustomView(Context context, AttributeSet attrs, int defStyleAttr) {
		super(context, attrs, defStyleAttr);
		// TODO Auto-generated constructor stub
	}
	
	@Override
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
		
		Log.i("HelloView", "Action is " + actionString);

//	     System.out.printf("At time %d:", event.getEventTime());
	     for (int p = 0; p < pointerCount; p++) {
//	    	 Log.i("HelloView", "pointer " + event.getPointerId(p) + ", ( x: " +event.getX(p) + "\t, y: " + event.getY(p) + "\t)");
	     }
	     return true;
	}
}
