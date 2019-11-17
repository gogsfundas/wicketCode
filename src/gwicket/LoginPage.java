package gwicket;




import org.apache.wicket.Page;
import org.apache.wicket.PageParameters;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.AjaxLink;
import org.apache.wicket.extensions.ajax.markup.html.modal.ModalWindow;
import org.apache.wicket.extensions.markup.html.repeater.data.table.DefaultDataTable;
import org.apache.wicket.extensions.markup.html.repeater.data.table.IColumn;
import org.apache.wicket.extensions.markup.html.repeater.data.table.PropertyColumn;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Button;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.PasswordTextField;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.model.Model;
import org.apache.wicket.model.PropertyModel;

public class LoginPage extends BasePage{
	
	public LoginPage() {
		
		ModalWindow helpWindow = new ModalWindow("help");
		///
		helpWindow.setPageCreator(new ModalWindow.PageCreator() {
			
			@Override
			public Page createPage() {
				// TODO Auto-generated method stub
				return new CopyrightPage();
			}
		});
		///
		
		
		helpWindow.setTitle(new Model("Help"));
		//if afcted / rendered using ajax the belwo line is mandatory 
		helpWindow.setOutputMarkupId(true);
		AjaxLink help = new AjaxLink("help_link") {

			@Override
			public void onClick(AjaxRequestTarget target) {
				// TODO Auto-generated method stub
				helpWindow.show(target);
			}

		};
		
		
		User user = new User();
	//create a reusable component panel 
	FeedbackPanel fpannel = new FeedbackPanel("feedbkPannel");
	Form loginForm  = new Form<>("loginForm");
	
	Label lusername = new Label("lusername","Email id");
	Label lpassword = new Label("lpassword","Password");
	
	TextField tusername = new TextField ( "tusername",new PropertyModel(user,"username"));
	tusername.setRequired(true);
	PasswordTextField tpassword = new PasswordTextField ( "tpassword",new PropertyModel(user,"password"));
	tpassword.setRequired(true);
	UNameValidator uValidator = new UNameValidator();
	tusername.add(uValidator);
	
	loginForm.add(lusername);
	loginForm.add(tusername);
	loginForm.add(lpassword);
	loginForm.add(tpassword);
	add(fpannel);
	add(help);
	add(helpWindow);
	
	Button sbt   = new Button("loginButton"){
		@Override 
		public void onSubmit (){
			super.onSubmit();
			System.out.println(" this button is pressed for home page ");
			System.out.println("user name "+ user.getUsername());
			System.out.println("password name "+ user.getPassword());
			//getApplication().getSessionStore().setAttribute(getRequest(), "logged_id", "logged_in");
			getApplication().getSessionStore().setAttribute(getRequest(), "user",user);
			setResponsePage(Homepage.class);
			
		}
	};
	
	loginForm.add(sbt);
    add( loginForm);
    
	//adding data table 
	IColumn [] columns = new IColumn[2];
	
	columns[0] = new PropertyColumn<>(new Model("Username"),"Username", "Username");
	columns[1] = new PropertyColumn<>(new Model("Password"),"Password", "Password");
	DefaultDataTable table = new DefaultDataTable("datatable", columns, new UserDataProvider(),10);
	add(table);
	
	
	
	
	

	}

}
