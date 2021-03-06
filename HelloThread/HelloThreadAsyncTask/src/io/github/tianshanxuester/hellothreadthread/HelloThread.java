package io.github.tianshanxuester.hellothreadthread;

import android.os.AsyncTask;
import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class HelloThread extends Activity {

	private boolean runningAsyncTask;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_hello_thread);
		Button startThreadButton = (Button) findViewById(R.id.startThread);
		startThreadButton.setOnClickListener(startThread);

		Button stopThreadButton = (Button) findViewById(R.id.stopThread);
		stopThreadButton.setOnClickListener(stopThread);
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
			if (runningAsyncTask) {
				return;
			}
			runningAsyncTask = true;
			asyncTask.execute((Object) null);
		}

	};

	private OnClickListener stopThread = new OnClickListener() {

		@Override
		public synchronized void onClick(View v) {
			asyncTask.cancel(false);
		}

	};

	private MyAsyncTask asyncTask = new MyAsyncTask();

	private class MyAsyncTask extends AsyncTask<Object, Integer, Long> {

		@Override
		protected Long doInBackground(Object... arg0) {
			int i = 0;
			while (true) {
				i++;
				if (i > 10) {
					break;
				}
				Log.i("HelloThread", "i is " + i);
				publishProgress(i);
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				if (isCancelled()) {
					Log.i("HelloThread", "thread is canceled");
					break;
				}
			}
			return (long) -1;
		}

		protected void onProgressUpdate(Integer... progress) {
			TextView valueOfI = (TextView) findViewById(R.id.valueOfI);
			if (progress.length > 0) {
				valueOfI.setText("value of i is " + progress[0]);
			}
		}

		protected void onPostExecute(Long result) {
			TextView valueOfI = (TextView) findViewById(R.id.valueOfI);
			valueOfI.setText("async task finished" + result);
		}
	};
}
