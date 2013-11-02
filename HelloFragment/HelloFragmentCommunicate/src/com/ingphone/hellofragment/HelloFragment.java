package com.ingphone.hellofragment;

import com.example.hellofragment.R;

import android.os.Bundle;
import android.app.Activity;
import android.support.v4.app.FragmentActivity;
import android.view.Menu;

public class HelloFragment extends FragmentActivity implements FragmentTwo.FragmentTwoAction {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_hello_fragment);
		FragmentTwo two = (FragmentTwo)getSupportFragmentManager().findFragmentById(R.id.fragmentTwo);
		two.delegate = this;
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.hello, menu);
		return true;
	}

	@Override
	public void buttonClicked() {
		FragmentOne one = (FragmentOne)getSupportFragmentManager().findFragmentById(R.id.fragmentOne);
		one.changeText("改变文字");
	}

}
