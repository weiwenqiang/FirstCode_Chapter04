package com.example.chapter04.news;

import java.util.ArrayList;
import java.util.List;

import com.example.chapter04.R;
import com.example.entity.News;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;

public class NewsTitleFragment extends Fragment implements OnItemClickListener {
	private ListView newsTitleListView;
	private List<News> newsList;
	private NewsAdapter adapter;
	private boolean isTwoPane;

	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);
		newsList = getNews();
		adapter = new NewsAdapter(activity, R.layout.news_item, newsList);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater
				.inflate(R.layout.news_title_frag, container, false);
		newsTitleListView = (ListView) view
				.findViewById(R.id.news_title_list_view);
		newsTitleListView.setAdapter(adapter);
		newsTitleListView.setOnItemClickListener(this);

		return view;
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		if (getActivity().findViewById(R.id.b2_news_content_layout) != null) {
			isTwoPane = true;
		} else {
			isTwoPane = false;
		}
	}

	private List<News> getNews() {
		List<News> newsList = new ArrayList<News>();
		News news1 = new News();
		news1.setTitle("Succeed in College as a Learning Disabled Student");
		news1.setContent("College freshmen will soon learn to live with a roommate, adjust to a new social scene and survive less-than-stellar dining hall food. Students with learning disabilities will face these transitions while also grappling with a few more hurdles.");
		newsList.add(news1);
		News news2 = new News();
		news2.setTitle("webSphere");
		news2.setContent("WebSphere �� IBM �����ƽ̨���������˱�д�����кͼ���ȫ���Ĺ�ҵǿ�ȵ�����Ӧ�� Web Ӧ�ó���Ϳ�ƽ̨�����Ʒ�����������Ҫ�������м��������ʩ���������������͹��ߡ�WebSphere �ṩ�˿ɿ������ͽ�׳�������WebSphere Application Server �Ǹ���ʩ�Ļ������������в�Ʒ������֮�����С�"
		+"WebSphere Process Server ���� WebSphere Application Server �� WebSphere Enterprise Service Bus����Ϊ����������ϵ�ṹ (SOA) ��ģ�黯Ӧ�ó����ṩ�˻�������֧��Ӧ��ҵ�����������֧��ҵ�����̵�Ӧ�ó��򡣸����ܻ�����ʹ�� WebSphere Extended Deployment ��Ϊ�������ʩ��һ���֡�"
				+"���� WebSphere ��Ʒ�ṩ�˹㷺����������WebSphere ��һ��ģ�黯��ƽ̨������ҵ��֧�ֵĿ��ű�׼������ͨ�������κͳ־õĽӿڣ��������ʲ����� WebSphere�����Լ�����չ������WebSphere ���������ƽ̨�����У����� Intel��Linux �� z/OS��"
		+"WebSphere ������Ӧ��ĵ�������ʱ��������Ҫ�����ƽ̨����������ҵ�����������������һ���ĵ�������Ӧ�ã���B2B����֧�ִӼ򵥵���ҳ���ݷ�������ҵ�����������ҵӦ�á�WebSphere ���Դ�����������վ�㣬 ��Ӧ����չ�����ϵ��ƶ��豸�� �������е�Ӧ�ò��ṩ�Զ�ҵ�����̡�");
		newsList.add(news2);
		News news3 = new News();
		news3.setTitle("Visual Age for Java");
		news3.setContent("Visual Age for Java��һ���ǳ�����Ŀ������ߣ��������Զ���IT�����ߺ�ҵ���JAVA�����Ա��˵���Ƿǳ����õġ����ṩ�Կ��ӻ���̵Ĺ㷺֧�֣�֧������CICS���Ӵ��ͻ�Ӧ�ã�֧��EJB�Ŀ���Ӧ�ã�֧����WebSphere�ļ��ɿ����������Bean���������õĿ���Ӧ�ÿ�����RAD��֧�ֺ����ļ�ʽ���ļ�����");
		newsList.add(news3);
		News news4 = new News();
		news4.setTitle("Turbo Pascal");
		news4.setContent("Turbo Pascalϵ�������Ϊ����ϵͳ�������������ʵʩ��ѧ����ͽ�ѧ���������ߣ�������Խ��Խ������á�Ҳ�ǹ��ʺ�ȫ����������Ϣѧ����ƥ�˾���ָ��������֮һ����������Ϣѧ��������������������ܳ��ɼ���ѡ���ӭ�����ԡ�");
		newsList.add(news4);
		News news5 = new News();
		news5.setTitle("JBuilder");
		news5.setContent("JBuilder��Borland��˾���������java�Ŀ������ߣ�ʹ��JBuilder�����Կ��٣���Ч�Ŀ�������javaӦ�ã���ʹ�õ�JDK��sun��˾��׼��JDK��ͬ���������˽϶���޸ģ��Ա㿪����Ա�ܹ��񿪷�DelphiӦ����������javaӦ�á�JBuilder�ĺ�����һ���ֲ�����VCL������ʹ�ó��������ǳ������������ǳ�ѧ�ߣ�Ҳ�������Ŀ����������롣JBuilder��һ���ص��Ǽ����ŶӺ����������õĻ����������Ҽ���ʹ��ͬ������������ͬ���ҵ������Ͽ���һ����Ŀ��Ϊ�˿��ܡ�");
		newsList.add(news5);
		return newsList;
	}

	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position,
			long id) {
		News news = newsList.get(position);
		if (isTwoPane) {
			// �����˫ҳģʽ����ˢ��NewsContentFragment�е�����
			NewsContentFragment newsContentFragment = (NewsContentFragment) getFragmentManager()
					.findFragmentById(R.id.b2_news_content_fragment);
			newsContentFragment.refresh(news.getTitle(), news.getContent());
		} else {
			// ����ǵ�ҳģʽ����ֱ������NewsContentActivity
			NewsContentActivity.actionStart(getActivity(), news.getTitle(),
					news.getContent());
		}
	}
}
