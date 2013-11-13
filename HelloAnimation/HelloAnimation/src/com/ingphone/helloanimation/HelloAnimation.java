package com.ingphone.helloanimation;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

public class HelloAnimation extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_hello_animation);
		Button startAnimationButton = (Button)findViewById(R.id.start);
		startAnimationButton.setOnClickListener(startAnimation);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.hello_animation, menu);
		return true;
	}
	
	private OnClickListener startAnimation = new OnClickListener(){

		@Override
		public void onClick(View arg0) {
			ImageView imageView = (ImageView)findViewById(R.id.imageView);
			Animation animation = AnimationUtils.loadAnimation(HelloAnimation.this, R.anim.animation);
			imageView.startAnimation(animation);
		}
		
	};

}
