package gwicket;

import javax.jcr.Repository;
import javax.jcr.SimpleCredentials;


import org.apache.wicket.Page;
import org.apache.wicket.protocol.http.WebApplication;
import org.apache.wicket.protocol.http.WebRequestCycle;
import org.apache.wicket.request.target.coding.QueryStringUrlCodingStrategy;
import org.brixcms.Brix;
import org.brixcms.Path;
import org.brixcms.config.BrixConfig;
import org.brixcms.config.PrefixUriMapper;
import org.brixcms.config.UriMapper;
import org.brixcms.jcr.JcrSessionFactory;

import org.brixcms.jcr.ThreadLocalSessionFactory;
import org.brixcms.plugin.site.SitePlugin;
import org.brixcms.util.JcrUtils;
import org.brixcms.web.nodepage.BrixNodePageUrlCodingStrategy;
import org.brixcms.workspace.Workspace;

public class GWicketApplication extends WebApplication {

	/*@Override
	public Class<? extends Page> getHomePage() {
		
		return Homepage.class;
	}
*/
	@Override
	public Class<? extends Page> getHomePage() {
		
		return BrixNodePageUrlCodingStrategy.HomePage.class;
				
	}
	@Override 
	protected void init() 
	{
		super.init();
		//create repository for yourself 
		Repository repo  = JcrUtils.createRepository("file://tmp//brix-jcr");
		final JcrSessionFactory sf = new ThreadLocalSessionFactory(repo, new SimpleCredentials("admin",
				"admin".toCharArray()));
		final org.brixcms.workspace.WorkspaceManager wm =  JcrUtils.createWorkspaceManager("file://tmp//brix-jcr", sf);
	  UriMapper mapper = new PrefixUriMapper(Path.ROOT) {
		
		@Override
		public Workspace getWorkspaceForRequest(WebRequestCycle requestCycle, Brix brix) {
			final String name = "file://tmp//brix-jcr";
			SitePlugin siteplugin =SitePlugin.get(brix);
			
			return siteplugin.getSiteWorkspace(name,"");
		}
	};
	BrixConfig config = new BrixConfig(sf, wm, mapper);
	config.setHttpPort(8080);
	config.setHttpsPort(8443);
	getDebugSettings().setOutputMarkupContainerClassName(true);
	mount(new QueryStringUrlCodingStrategy("/admin",AdminPage.class));
	}

}
