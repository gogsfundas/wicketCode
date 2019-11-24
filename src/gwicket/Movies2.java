package gwicket;

import org.apache.wicket.extensions.markup.html.repeater.data.table.DefaultDataTable;
import org.apache.wicket.extensions.markup.html.repeater.data.table.IColumn;
import org.apache.wicket.extensions.markup.html.repeater.data.table.PropertyColumn;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.model.Model;

public class Movies2 extends BasePage{

	
	public Movies2()
	{
	//adding data table 
		IColumn [] columns = new IColumn[2];
		
		columns[0] = new PropertyColumn<>(new Model("Username"),"Username", "Username");
		columns[1] = new PropertyColumn<>(new Model("Password"),"Password", "Password");
		DefaultDataTable table = new DefaultDataTable("datatable", columns, new UserDataProvider(),10);
		add(table);
	}
		
}
