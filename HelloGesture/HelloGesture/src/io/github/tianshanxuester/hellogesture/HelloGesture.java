package io.github.tianshanxuester.hellogesture;

import android.os.Bundle;
import android.app.Activity;
import android.support.v4.view.GestureDetectorCompat;
import android.util.Log;
import android.view.GestureDetector.OnDoubleTapListener;
import android.view.GestureDetector.OnGestureListener;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

public class HelloGesture extends Activity implements OnGestureListener, OnDoubleTapListener {

	private GestureDetectorCompat mGestureDetector;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_hello_gesture);
		
		mGestureDetector = new GestureDetectorCompat(this, this);
		mGestureDetector.setOnDoubleTapListener(this);
		
		findViewById(android.R.id.content).setOnTouchListener(new OnTouchListener(){

			@Override
			public boolean onTouch(View arg0, MotionEvent event) {
				return mGestureDetector.onTouchEvent(event);
			}});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.hello_gesture, menu);
		return true;
	}

	@Override
	public boolean onDoubleTap(MotionEvent event) {
		Log.i("HelloGesture", "onDoubleTap: " + event.toString());
		return true;
	}

	@Override
	public boolean onDoubleTapEvent(MotionEvent event) {
		Log.i("HelloGesture", "onDoubleTapEvent: " + event.toString());
		return true;
	}

	@Override
	public boolean onSingleTapConfirmed(MotionEvent event) {
		Log.i("HelloGesture", "onSingleTapConfirmed: " + event.toString());
		return true;
	}

	@Override
	public boolean onDown(MotionEvent event) {
		Log.i("HelloGesture", "onDown: " + event.toString());
		return true;
	}

	@Override
	public boolean onFling(MotionEvent event1, MotionEvent event2, float velocityX,
			float velocityY) {
		Log.i("HelloGesture", "onFling: " + event1.toString() + event2.toString());
		return true;
	}

	@Override
	public void onLongPress(MotionEvent event) {
		Log.i("HelloGesture", "onLongPress: " + event.toString());
	}

	@Override
	public boolean onScroll(MotionEvent event1, MotionEvent event2, float distanceX,
			float distanceY) {
		Log.i("HelloGesture", "onScroll: " + event1.toString() + event2.toString());
		return true;
	}

	@Override
	public void onShowPress(MotionEvent event) {
		Log.i("HelloGesture", "onShowPress: " + event.toString());
	}

	@Override
	public boolean onSingleTapUp(MotionEvent event) {
		Log.i("HelloGesture", "onSingleTapUp: " + event.toString());
		return true;
	}

}
