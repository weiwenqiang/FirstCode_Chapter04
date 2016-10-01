package com.example.chapter04.fragment;

import com.example.chapter04.R;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;

public class TestEasyFragment extends Activity implements OnClickListener {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.b1_fragment);
		findViewById(R.id.b1_left_button).setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.b1_left_button:
			//第一步：创建待添加的碎片实例
			AnotherRightFragment fragment = new AnotherRightFragment();
			//第二步：获取到FragmentManager，在活动中可以直接调用getFragmentManager()方法得到
			FragmentManager fragmentManager = getFragmentManager();
			//第三步：开启一个事物，通过调用beginTransaction()方法开启
			FragmentTransaction transaction = fragmentManager.beginTransaction();
			//第四步：向容器内加入碎片，一般使用replace()方法实现，需要传入容器的id和待添加的碎片实例
			transaction.replace(R.id.b1_right_layout, fragment);
			//返回栈的一行代码实现
			transaction.addToBackStack(null);
			//第五步：提交事物，调用commit()方法来完成
			transaction.commit();
			break;

		default:
			break;
		}
	}
	/**
	 * 164页,碎片和活动之间进行通信
	 * 从布局文件中获取碎片的实例
	 * RightFragment rightFragment = (RightFragment)getFragmentManager().findFragmentById(R.id.right_fragment);
	 * 碎片调用活动里的方法
	 * MainActivity cativity = (MainActivity)getActivity();
	 */
}
