package io.github.tianshanxuester.hellogesture;

import android.os.Bundle;
import android.app.Activity;
import android.support.v4.view.GestureDetectorCompat;
import android.util.Log;
import android.view.GestureDetector.OnDoubleTapListener;
import android.view.GestureDetector.OnGestureListener;
import android.view.Menu;
import android.view.MotionEvent;

public class HelloGesture extends Activity implements OnGestureListener, OnDoubleTapListener {

	private GestureDetectorCompat mGestureDetector;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_hello_gesture);
		
		mGestureDetector = new GestureDetectorCompat(this, this);
		mGestureDetector.setOnDoubleTapListener(this);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.hello_gesture, menu);
		return true;
	}

	@Override
	public boolean onDoubleTap(MotionEvent event) {
		Log.d("HelloGesture", "onDoubleTap: " + event.toString());
		return true;
	}

	@Override
	public boolean onDoubleTapEvent(MotionEvent event) {
		Log.d("HelloGesture", "onDoubleTapEvent: " + event.toString());
		return true;
	}

	@Override
	public boolean onSingleTapConfirmed(MotionEvent event) {
		Log.d("HelloGesture", "onSingleTapConfirmed: " + event.toString());
		return true;
	}

	@Override
	public boolean onDown(MotionEvent event) {
		Log.d("HelloGesture", "onDown: " + event.toString());
		return true;
	}

	@Override
	public boolean onFling(MotionEvent event1, MotionEvent event2, float velocityX,
			float velocityY) {
		Log.d("HelloGesture", "onFling: " + event1.toString() + event2.toString());
		return true;
	}

	@Override
	public void onLongPress(MotionEvent event) {
		Log.d("HelloGesture", "onLongPress: " + event.toString());
	}

	@Override
	public boolean onScroll(MotionEvent event1, MotionEvent event2, float distanceX,
			float distanceY) {
		Log.d("HelloGesture", "onScroll: " + event1.toString() + event2.toString());
		return true;
	}

	@Override
	public void onShowPress(MotionEvent event) {
		Log.d("HelloGesture", "onShowPress: " + event.toString());
	}

	@Override
	public boolean onSingleTapUp(MotionEvent event) {
		Log.d("HelloGesture", "onSingleTapUp: " + event.toString());
		return true;
	}

}
