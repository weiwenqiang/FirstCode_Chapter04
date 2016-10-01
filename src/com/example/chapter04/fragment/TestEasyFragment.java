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
			//��һ������������ӵ���Ƭʵ��
			AnotherRightFragment fragment = new AnotherRightFragment();
			//�ڶ�������ȡ��FragmentManager���ڻ�п���ֱ�ӵ���getFragmentManager()�����õ�
			FragmentManager fragmentManager = getFragmentManager();
			//������������һ�����ͨ������beginTransaction()��������
			FragmentTransaction transaction = fragmentManager.beginTransaction();
			//���Ĳ����������ڼ�����Ƭ��һ��ʹ��replace()����ʵ�֣���Ҫ����������id�ʹ���ӵ���Ƭʵ��
			transaction.replace(R.id.b1_right_layout, fragment);
			//����ջ��һ�д���ʵ��
			transaction.addToBackStack(null);
			//���岽���ύ�������commit()���������
			transaction.commit();
			break;

		default:
			break;
		}
	}
	/**
	 * 164ҳ,��Ƭ�ͻ֮�����ͨ��
	 * �Ӳ����ļ��л�ȡ��Ƭ��ʵ��
	 * RightFragment rightFragment = (RightFragment)getFragmentManager().findFragmentById(R.id.right_fragment);
	 * ��Ƭ���û��ķ���
	 * MainActivity cativity = (MainActivity)getActivity();
	 */
}
