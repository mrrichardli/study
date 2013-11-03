package com.ingphone.hellocustomview;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class HelloCustomView extends Activity {
	
//	private String extraText;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_hello_custom_view);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.hello_custom_view, menu);
		return true;
	}

}
