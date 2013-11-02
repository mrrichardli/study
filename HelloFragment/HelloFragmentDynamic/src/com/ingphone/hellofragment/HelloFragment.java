package com.ingphone.hellofragment;

import com.example.hellofragment.R;

import android.os.Bundle;
import android.app.Activity;
import android.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.Display;
import android.view.Menu;

import com.ingphone.hellofragment.FragmentOne;
import com.ingphone.hellofragment.FragmentTwo;

public class HelloFragment extends FragmentActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_hello_fragment);
		Display display = getWindowManager().getDefaultDisplay();
		if (display.getWidth() > display.getHeight()) {
			FragmentOne fragmentOne = new FragmentOne();
			getSupportFragmentManager().beginTransaction().replace(R.id.main_layout, fragmentOne).commit();
		}else {
			FragmentTwo fragmentTwo = new FragmentTwo();
			//v4:getSupportFragmentManager
			//not v4:getFragmentManager
			getSupportFragmentManager().beginTransaction().replace(R.id.main_layout, fragmentTwo).commit();
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.hello, menu);
		return true;
	}

}
