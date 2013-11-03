package com.ingphone.helloprogressdialog;

import android.os.Bundle;
import android.app.Activity;
import android.app.ProgressDialog;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class HelloProgressDialog extends Activity {
	
	private MyDialog progressDialog = null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_hello_progress_dialog);
		Button show = (Button)findViewById(R.id.showProgressDialog);
		show.setOnClickListener(showProgressDialog);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.hello_progress_dialog, menu);
		return true;
	}
	
	private OnClickListener showProgressDialog = new OnClickListener(){

		@Override
		public synchronized void onClick(View arg0) {
				progressDialog = new MyDialog(HelloProgressDialog.this);
				progressDialog.show();
				new Thread(new Runnable(){

					@Override
					public void run() {
						try {
							Thread.sleep(10000);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						progressDialog.dismiss();
					}}).start();
		}
		
	};

}