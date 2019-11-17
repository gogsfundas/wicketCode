package gwicket;




import org.apache.wicket.PageParameters;
import org.apache.wicket.feedback.FeedbackMessage;
import org.apache.wicket.feedback.FeedbackMessages;
import org.apache.wicket.markup.html.JavascriptPackageResource;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Button;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.markup.html.resources.CompressedResourceReference;
import org.apache.wicket.model.Model;

public class Homepage  extends BasePage{

	
	public Homepage ()
	{
	/*	CompressedResourceReference conResouceRef = new CompressedResourceReference(Homepage.class, "hello.js");
		Form loginForm = new Form<>("loginForm");
		Model userModel = new Model<>();
		TextField   username = new TextField("username",userModel);
		UsernameValidator uValidator = new UsernameValidator();
		  username.add(uValidator);
		loginForm.add(username);
		FeedbackPanel fpanel = new FeedbackPanel("feedback");
		add(fpanel);
		Button  subBnt = new Button("submit"){
			@Override
			public void onSubmit() {
				System.out.println(userModel.getObject());
				
				//setResponsePage(seondPage.class);
			}
		};
				
		loginForm.add(subBnt);
		Label hello = new Label ( "hello_label","hello");
		
		Link mylink = new Link("secondPage"){

			@Override
			public void onClick() {
				
				
			}
			
		};
		add(JavascriptPackageResource.getHeaderContribution(conResouceRef));
		//add(conResouce);
		add(loginForm);
		add(hello);
		add(mylink);*/
	}
}