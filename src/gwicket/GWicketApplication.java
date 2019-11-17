package gwicket;

import org.apache.wicket.Page;
import org.apache.wicket.protocol.http.WebApplication;

public class GWicketApplication extends WebApplication {

	@Override
	public Class<? extends Page> getHomePage() {
		
		return Homepage.class;
	}

}
