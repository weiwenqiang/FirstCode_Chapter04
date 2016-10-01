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
		news2.setContent("WebSphere 是 IBM 的软件平台。它包含了编写、运行和监视全天候的工业强度的随需应变 Web 应用程序和跨平台、跨产品解决方案所需要的整个中间件基础设施，如服务器、服务和工具。WebSphere 提供了可靠、灵活和健壮的软件。WebSphere Application Server 是该设施的基础，其他所有产品都在它之上运行。"
		+"WebSphere Process Server 基于 WebSphere Application Server 和 WebSphere Enterprise Service Bus，它为面向服务的体系结构 (SOA) 的模块化应用程序提供了基础，并支持应用业务规则，以驱动支持业务流程的应用程序。高性能环境还使用 WebSphere Extended Deployment 作为其基础设施的一部分。"
				+"其他 WebSphere 产品提供了广泛的其他服务。WebSphere 是一个模块化的平台，基于业界支持的开放标准。可以通过受信任和持久的接口，将现有资产插入 WebSphere，可以继续扩展环境。WebSphere 可以在许多平台上运行，包括 Intel、Linux 和 z/OS。"
		+"WebSphere 是随需应变的电子商务时代的最主要的软件平台，可用于企业开发、部署和整合新一代的电子商务应用，如B2B，并支持从简单的网页内容发布到企业级事务处理的商业应用。WebSphere 可以创建电子商务站点， 把应用扩展到联合的移动设备， 整合已有的应用并提供自动业务流程。");
		newsList.add(news2);
		News news3 = new News();
		news3.setTitle("Visual Age for Java");
		news3.setContent("Visual Age for Java是一个非常成熟的开发工具，它的特性对于IT开发者和业余的JAVA编程人员来说都是非常有用的。它提供对可视化编程的广泛支持，支持利用CICS连接大型机应用，支持EJB的开发应用，支持与WebSphere的集成开发，方便的Bean创建和良好的快速应用开发（RAD）支持和无文件式的文件处理。");
		newsList.add(news3);
		News news4 = new News();
		news4.setTitle("Turbo Pascal");
		news4.setContent("Turbo Pascal系列软件作为开发系统软件与就任软件及实施科学计算和教学的有力工具，发挥着越来越大的作用。也是国际和全国青少年信息学奥林匹克竞赛指定的语言之一。从历届信息学竞赛的情况看，它是最能出成绩和选手最欢迎的语言。");
		newsList.add(news4);
		News news5 = new News();
		news5.setTitle("JBuilder");
		news5.setContent("JBuilder是Borland公司开发的针对java的开发工具，使用JBuilder将可以快速，有效的开发各类java应用，它使用的JDK与sun公司标准的JDK不同，它经过了较多的修改，以便开发人员能够像开发Delphi应用那样开发java应用。JBuilder的核心有一部分采用了VCL技术，使得程序的条理非常清晰，就算是初学者，也能完整的看完整个代码。JBuilder另一个特点是简化了团队合作，它采用的互联网工作室技术使不同地区，甚至不同国家的人联合开发一个项目成为了可能。");
		newsList.add(news5);
		return newsList;
	}

	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position,
			long id) {
		News news = newsList.get(position);
		if (isTwoPane) {
			// 如果是双页模式，则刷新NewsContentFragment中的内容
			NewsContentFragment newsContentFragment = (NewsContentFragment) getFragmentManager()
					.findFragmentById(R.id.b2_news_content_fragment);
			newsContentFragment.refresh(news.getTitle(), news.getContent());
		} else {
			// 如果是单页模式，则直接启动NewsContentActivity
			NewsContentActivity.actionStart(getActivity(), news.getTitle(),
					news.getContent());
		}
	}
}
