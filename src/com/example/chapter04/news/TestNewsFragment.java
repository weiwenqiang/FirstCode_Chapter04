package com.example.chapter04.news;

import com.example.chapter04.R;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;

public class TestNewsFragment extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.b2_news);
	}

}
