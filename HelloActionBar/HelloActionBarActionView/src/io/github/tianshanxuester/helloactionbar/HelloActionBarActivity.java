package io.github.tianshanxuester.helloactionbar;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

public class HelloActionBarActivity extends ActionBarActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return super.onCreateOptionsMenu(menu);
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch(item.getItemId()) {
		case R.id.action_add:
			Log.i("SMSFilter", "action add");
			break;
		case R.id.action_settings:
			Log.i("SMSFilter", "action setting");
			break;
		case R.id.action_delete:
			Log.i("SMSFilter", "action delete");
			break;
		}
		return true;
	}

}