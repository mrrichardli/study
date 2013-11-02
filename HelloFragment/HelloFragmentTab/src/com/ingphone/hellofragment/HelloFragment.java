package com.ingphone.hellofragment;

import com.example.hellofragment.R;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class HelloFragment extends FragmentActivity {

	private FragmentOne one;
	private FragmentTwo two;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_hello_fragment);
		Button button1 = (Button) findViewById(R.id.button1);
		button1.setOnClickListener(toOne);
		Button button2 = (Button) findViewById(R.id.button2);
		button2.setOnClickListener(toTwo);
		toOne.onClick(button1);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.hello, menu);
		return true;
	}

	private OnClickListener toOne = new OnClickListener() {

		@Override
		public synchronized void onClick(View v) {
			if (one == null) {
				one = new FragmentOne();
			}
			getSupportFragmentManager().beginTransaction()
					.replace(R.id.frag, one).commit();
		}
	};

	private OnClickListener toTwo = new OnClickListener() {

		@Override
		public synchronized void onClick(View v) {
			if (two == null) {
				two = new FragmentTwo();
			}
			getSupportFragmentManager().beginTransaction()
					.replace(R.id.frag, two).commit();
		}
	};

}
