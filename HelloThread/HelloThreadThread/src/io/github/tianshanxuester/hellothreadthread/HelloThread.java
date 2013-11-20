package io.github.tianshanxuester.hellothreadthread;

import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class HelloThread extends Activity {
	
	private Runnable runnable;
	private Thread thread;
	private boolean shouldCancel;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_hello_thread);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.hello_thread, menu);
		
		Button startThreadButton = (Button)findViewById(R.id.startThread);
		startThreadButton.setOnClickListener(startThread);
		
		Button stopThreadButton = (Button)findViewById(R.id.stopThread);
		stopThreadButton.setOnClickListener(stopThread);
		
		runnable = new Runnable(){

			@Override
			public void run() {
				int i = 0;
				while(true) {
					i++;
					Log.i("HelloThread", "i is " + i);
					try {
						Thread.sleep(3000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					if (shouldCancel) {
						Log.i("HelloThread", "thread is canceled");
						thread = null;
						break;
					}
				}
				
			}
			
		};
		
		return true;
	}

	private OnClickListener startThread = new OnClickListener() {

		@Override
		public synchronized void onClick(View arg0) {
			if (thread != null) {
				return;
			}
			shouldCancel = false;
			thread = new Thread(runnable);
			thread.start();
		}
		
	};
	
	private OnClickListener stopThread = new OnClickListener() {

		@Override
		public synchronized void onClick(View v) {
			shouldCancel = true;
		}
		
	};
}
