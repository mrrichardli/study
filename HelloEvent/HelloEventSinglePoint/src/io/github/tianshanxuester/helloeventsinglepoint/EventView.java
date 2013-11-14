package io.github.tianshanxuester.helloeventsinglepoint;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

public class EventView extends View {

	public EventView(Context context) {
		super(context);
	}

	public EventView(Context context, AttributeSet attrs) {
		super(context, attrs);
	}

	public EventView(Context context, AttributeSet attrs, int defStyleAttr) {
		super(context, attrs, defStyleAttr);
	}

	@Override
	public boolean onTouchEvent (MotionEvent event) {
		
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
		
		Log.i("HelloEventSinglePoint", "Action is " + actionString);

	     return true;
	}
}
