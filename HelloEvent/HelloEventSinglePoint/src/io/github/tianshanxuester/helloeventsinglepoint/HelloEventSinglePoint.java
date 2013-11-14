package io.github.tianshanxuester.helloeventsinglepoint;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class HelloEventSinglePoint extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_hello_event_single_point);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.hello_event_single_point, menu);
		return true;
	}

}
