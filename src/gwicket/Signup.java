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

public class Signup extends BasePage{
	
	public Signup() {
		
		ModalWindow termandconditionsWindow = new ModalWindow("termandconditionmodle");
		///
		termandconditionsWindow.setPageCreator(new ModalWindow.PageCreator() {
			
			@Override
			public Page createPage() {
				// TODO Auto-generated method stub
				return new TermAndConditions();
			}
		});
		///
		
		
		termandconditionsWindow.setTitle(new Model("Term And Conditions"));
		//if afcted / rendered using ajax the belwo line is mandatory 
		termandconditionsWindow.setOutputMarkupId(true);
		AjaxLink tandclink = new AjaxLink("tandc_link") {

			@Override
			public void onClick(AjaxRequestTarget target) {
				// TODO Auto-generated method stub
				termandconditionsWindow.show(target);
			}

		};
		
	
		SignupPojo user = new SignupPojo();
	//create a reusable component panel 
	FeedbackPanel fpannel = new FeedbackPanel("feedbkPannel");
	Form loginForm  = new Form<>("loginForm");
	
	Label lusername = new Label("luseremail","Email id");
	Label lfirstname = new Label("lfirstname","First Name");
	Label llastname = new Label("llastname","Last Name");
	Label lpassword = new Label("lpassword","Password");
	
	Label lrepassword = new Label("lrepassword","repassword");
	
	TextField tusername = new TextField ( "tuseremail",new PropertyModel(user,"email"));
	tusername.setRequired(true);
	
	TextField tfirstname = new TextField ( "tfirstname",new PropertyModel(user,"firstname"));
	//tusername.setRequired(true);
	
	TextField tlastname = new TextField ( "tlastname",new PropertyModel(user,"lastname"));
	//tusername.setRequired(true);
	PasswordTextField trepassword = new PasswordTextField ( "trepassword",new PropertyModel(user,"repassword"));
	
	
	PasswordTextField tpassword = new PasswordTextField ( "tpassword",new PropertyModel(user,"password"));
	tpassword.setRequired(true);
	UNameValidator uValidator = new UNameValidator();
	ExistingUserValidation existingUserValidation = new ExistingUserValidation();
	tusername.add(existingUserValidation);
	tusername.add(uValidator);
	loginForm.add(lrepassword);
	loginForm.add(trepassword);
	loginForm.add(lusername);
	loginForm.add(tusername);
	
	loginForm.add(lpassword);
	loginForm.add(tpassword);
	loginForm.add(lfirstname);
	loginForm.add(tfirstname);
	loginForm.add(llastname);
	loginForm.add(tlastname);
	
	
add(fpannel);
add(tandclink);
	add(termandconditionsWindow);
	
	Button sbt   = new Button("loginButton"){
		@Override 
		public void onSubmit (){
			super.onSubmit();
			System.out.println(" this button is pressed for home page ");
			System.out.println("email id  "+ user.getEmail());
			System.out.println("password name "+ user.getPassword());
			System.out.println("First  name "+ user.getFirstname());
			System.out.println("Last  name "+ user.getLastname());
			System.out.println("repassword name "+ user.getRepassword());
			
			//getApplication().getSessionStore().setAttribute(getRequest(), "logged_id", "logged_in");
			getApplication().getSessionStore().setAttribute(getRequest(), "user",user);
			setResponsePage(Homepage.class);
			
		}
	};
	
	loginForm.add(sbt);
    add( loginForm);
    
	//adding data table 
	/*IColumn [] columns = new IColumn[2];
	
	columns[0] = new PropertyColumn<>(new Model("Username"),"Username", "Username");
	columns[1] = new PropertyColumn<>(new Model("Password"),"Password", "Password");
	DefaultDataTable table = new DefaultDataTable("datatable", columns, new UserDataProvider(),10);
	add(table);*/
	
	
	
	
	

	}

}
