package com.ingphone.hellopopupwindow;

import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.WindowManager;
import android.view.View.OnClickListener;
import android.view.WindowManager.LayoutParams;
import android.widget.Button;

public class HelloPopupWindow extends Activity {

	private View floatDialogView;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_hello_popup_window);
		
		Button openButton = (Button)findViewById(R.id.openWindow);
		openButton.setOnClickListener(openWindow);
		Button closeButton = (Button)findViewById(R.id.closeWindow);
		closeButton.setOnClickListener(closeWindow);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.hello_popup_window, menu);
		return true;
	}

	private OnClickListener openWindow = new OnClickListener() {

		@Override
		public void onClick(View arg0) {
			if(floatDialogView != null) {
				return;
			}
			WindowManager windowManager = (WindowManager)getApplicationContext().getSystemService(Context.WINDOW_SERVICE);
			LayoutParams params = new WindowManager.LayoutParams();
			params.type = WindowManager.LayoutParams.TYPE_SYSTEM_OVERLAY;
			params.flags = WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE | WindowManager.LayoutParams.FLAG_WATCH_OUTSIDE_TOUCH;
			params.width = WindowManager.LayoutParams.WRAP_CONTENT;
			params.height = WindowManager.LayoutParams.WRAP_CONTENT;
			LayoutInflater inflater = LayoutInflater.from(HelloPopupWindow.this);
			floatDialogView = inflater.inflate(R.layout.floatwindow, null);
			Button closeButton = (Button)floatDialogView.findViewById(R.id.close);
			closeButton.setOnClickListener(new OnClickListener(){

				@Override
				public void onClick(View view) {
					WindowManager windowManager = (WindowManager)getApplicationContext().getSystemService(Context.WINDOW_SERVICE);
					windowManager.removeView(floatDialogView);
					floatDialogView = null;
				}
				
			});
			windowManager.addView(floatDialogView, params);
		}
		
	};
	
	private OnClickListener closeWindow = new OnClickListener() {

		@Override
		public synchronized void onClick(View v) {
			if (floatDialogView == null) {
				return;
			}
			WindowManager windowManager = (WindowManager)getApplicationContext().getSystemService(Context.WINDOW_SERVICE);
			windowManager.removeView(floatDialogView);
			floatDialogView = null;
		}};
}
