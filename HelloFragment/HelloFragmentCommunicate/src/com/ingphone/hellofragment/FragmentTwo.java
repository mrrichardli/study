package com.ingphone.hellofragment;

import com.example.hellofragment.R;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;

public class FragmentTwo extends Fragment {
	
	public interface FragmentTwoAction {
		public void buttonClicked();
	}
	
	public FragmentTwoAction delegate;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstance) {
		return inflater.inflate(R.layout.activity_fragment_one, container, false);
	}
	
	@Override
	public void onActivityCreated(Bundle savedInstance) {
		super.onActivityCreated(savedInstance);
		Button button = (Button)getActivity().findViewById(R.id.changeText);
		button.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View arg0) {
				delegate.buttonClicked();
			}
			
		});
	}
}
