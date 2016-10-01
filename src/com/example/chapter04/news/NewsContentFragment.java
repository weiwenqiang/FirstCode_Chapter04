package com.example.chapter04.news;

import com.example.chapter04.R;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class NewsContentFragment extends Fragment {
	private View view;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		view = inflater.inflate(R.layout.news_content_frag, container, false);
		return view;
	}
	
	public void refresh(String newsTitle, String newsContent){
		View visibilityLayout = view.findViewById(R.id.frag_visibility_layout);
		visibilityLayout.setVisibility(View.VISIBLE);
		TextView newsTitleText = (TextView) view.findViewById(R.id.frag_news_title);
		TextView newsContentText = (TextView) view.findViewById(R.id.frag_news_content);
		newsTitleText.setText(newsTitle);
		newsContentText.setText(newsContent);
	}
	
}
