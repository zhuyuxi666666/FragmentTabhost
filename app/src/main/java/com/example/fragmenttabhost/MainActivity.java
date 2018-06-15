package com.example.fragmenttabhost;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTabHost;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TabHost.TabSpec;
import android.widget.TextView;

import com.example.fragment.Fragment1;
import com.example.fragment.Fragment2;
import com.example.fragment.Fragment3;
import com.example.fragment.Fragment4;
import com.example.fragment.Fragment5;

/**
 * 
 * @author zqy
 * 
 */
public class MainActivity extends FragmentActivity {
	/**
	 * FragmentTabhost
	 */
	private FragmentTabHost mTabHost;

	/**
	 * ���������
	 * 
	 */
	private LayoutInflater mLayoutInflater;

	/**
	 * Fragment�������
	 * 
	 */
	private Class mFragmentArray[] = { Fragment1.class, Fragment2.class,
			Fragment3.class, Fragment4.class, Fragment5.class };
	/**
	 * ���ͼƬ����
	 * 
	 */
	private int mImageArray[] = { R.drawable.tab_home_btn,
			R.drawable.tab_message_btn, R.drawable.tab_selfinfo_btn,
			R.drawable.tab_square_btn, R.drawable.tab_more_btn };

	/**
	 * ѡ�޿�����
	 * 
	 */
	private String mTextArray[] = { "��ҳ", "��Ϣ", "����", "����", "����" };
	/**
	 * 
	 * 
	 */
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		initView();
	}

	/**
	 * ��ʼ�����
	 */
	private void initView() {
		mLayoutInflater = LayoutInflater.from(this);

		// �ҵ�TabHost
		mTabHost = (FragmentTabHost) findViewById(android.R.id.tabhost);
		mTabHost.setup(this, getSupportFragmentManager(), R.id.realtabcontent);
		// �õ�fragment�ĸ���
		int count = mFragmentArray.length;
		for (int i = 0; i < count; i++) {
			// ��ÿ��Tab��ť����ͼ�ꡢ���ֺ�����
			TabSpec tabSpec = mTabHost.newTabSpec(mTextArray[i])
					.setIndicator(getTabItemView(i));
			// ��Tab��ť��ӽ�Tabѡ���
			mTabHost.addTab(tabSpec, mFragmentArray[i], null);
			// ����Tab��ť�ı���
			mTabHost.getTabWidget().getChildAt(i)
					.setBackgroundResource(R.drawable.selector_tab_background);
		}
	}

	/**
	 *
	 * ��ÿ��Tab��ť����ͼ�������
	 */
	private View getTabItemView(int index) {
		View view = mLayoutInflater.inflate(R.layout.tab_item_view, null);
		ImageView imageView = (ImageView) view.findViewById(R.id.imageview);
		imageView.setImageResource(mImageArray[index]);
		TextView textView = (TextView) view.findViewById(R.id.textview);
		textView.setText(mTextArray[index]);

		return view;
	}

}
