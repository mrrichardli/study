package io.github.tianshanxuester.hellothreadthread;

import android.os.Bundle;
import android.os.Handler;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class HelloThread extends Activity {

	private Runnable runnable;
	private Thread thread;
	private boolean shouldCancel;
	private Handler handler;
	private Runnable updateUIRunnable;
	private int i;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_hello_thread);

		Button startThreadButton = (Button) findViewById(R.id.startThread);
		startThreadButton.setOnClickListener(startThread);

		Button stopThreadButton = (Button) findViewById(R.id.stopThread);
		stopThreadButton.setOnClickListener(stopThread);

		final TextView valueOfI = (TextView) findViewById(R.id.valueOfI);

		handler = new Handler();

		updateUIRunnable = new Runnable() {
			@Override
			public void run() {
				valueOfI.setText("value of i is " + Integer.toString(i));
			}
		};

		runnable = new Runnable() {
			@Override
			public void run() {
				while (true) {
					i++;
					Log.i("HelloThread", "i is " + i);
					// valueOfI.setText("value of i is " + Integer.toString(i));
					handler.post(updateUIRunnable);
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
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.hello_thread, menu);
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
