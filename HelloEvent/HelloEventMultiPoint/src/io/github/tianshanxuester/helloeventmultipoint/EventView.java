package io.github.tianshanxuester.helloeventmultipoint;

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
		
		Log.i("HelloEventMultiPoint", "Total pointer count is " + event.getPointerCount());
		
		String actionString = actionToString(event.getAction());
		Log.i("HelloEventMultiPoint", "Main action is " + actionString);
		
		int maskedAction = event.getActionMasked();
		int pointId = event.getActionIndex();
		Log.i("HelloEventMultiPoint", "Masked action is " + actionToString(maskedAction) + "\tpointId is " + pointId);
		Log.i("HelloEventMultiPoint", "====================");
	     return true;
	}
	
	private String actionToString(int action) {
		String actionString = null;
		switch(action) {
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
		case MotionEvent.ACTION_POINTER_DOWN:
			actionString = "ACTION_POINTER_DOWN";
			break;
		case MotionEvent.ACTION_POINTER_UP:
			actionString = "ACITON_POINTER_UP";
			break;
			default:
				actionString = "" + action;
		}
		
		return actionString;
	}
}
