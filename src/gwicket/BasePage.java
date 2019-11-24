package gwicket;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.link.Link;

public abstract class BasePage extends WebPage {

	BasePage (){
		
		Link moviewLink = new Link("movies"){

			@Override
			public void onClick() {
				
				setResponsePage(Movies.class);
			}
			
		};
		
		Link eventLink = new Link ("events"){
			@Override
			public void onClick(){
				setResponsePage(Events.class);
			}
		};
		
		Link teletLink = new Link ("television"){
			@Override
			public void onClick(){
				setResponsePage(Television.class);
			}
		};
		Link loginFormlink = new Link ("loginFormlink"){
			@Override
			public void onClick(){
				setResponsePage(LoginPage.class);
			}
		};
		Link signupLink = new Link ("signupLink"){
			@Override
			public void onClick(){
				setResponsePage(Signup.class);
			}
		};
		
		add (signupLink);
		
		add (loginFormlink);
		add (moviewLink);
		add(eventLink);
		add(teletLink);
	}
}
