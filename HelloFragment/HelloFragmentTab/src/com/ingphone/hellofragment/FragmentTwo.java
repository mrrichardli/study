package com.ingphone.hellofragment;

import com.example.hellofragment.R;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class FragmentTwo extends Fragment {
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstance) {
		Log.i("HelloFragmentTab", "two onCreateView");
		return inflater.inflate(R.layout.activity_fragment_two, container, false);
	}
}
