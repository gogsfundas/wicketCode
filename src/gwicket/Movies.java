package gwicket;

import java.util.ArrayList;
import java.util.List;

import org.apache.wicket.extensions.markup.html.repeater.data.table.DefaultDataTable;
import org.apache.wicket.extensions.markup.html.repeater.data.table.IColumn;
import org.apache.wicket.extensions.markup.html.repeater.data.table.PropertyColumn;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.model.Model;
class movieDetails {
	public String name; 
	public String price;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	
}
public class Movies extends BasePage{

	
	public Movies()
	{
		ListView lview =new ListView("moviews",getMoviews()){

			
			@Override
			protected void populateItem(ListItem item) {
				movieDetails movie = (movieDetails) item.getModelObject();
				 item.add(new Label("moviename", movie.getName()));
				 item.add(new Label("price", movie.getPrice())); 
				 item.add(new Link("add", item.getModel()) {
					 @Override 
					 public void onClick() { 
						 movieDetails selected = (movieDetails) getModelObject(); 
						System.out.println(selected.getName());
						 } 
					 });                               
			}
		
		};
		add(lview);
	//adding data table 
		IColumn [] columns = new IColumn[2];
		
		columns[0] = new PropertyColumn<>(new Model("Username"),"Username", "Username");
		columns[1] = new PropertyColumn<>(new Model("Password"),"Password", "Password");
		DefaultDataTable table = new DefaultDataTable("datatable", columns, new UserDataProvider(),10);
		add(table);
	}

	public List<movieDetails> getMoviews(){
		
		List<movieDetails> listDB = new  ArrayList<>();
		for (int i=0; i <100; i++)
		{
			movieDetails movie = new movieDetails();
		
			movie.setName( "user"  +"_0_"+i);
			movie.setPrice( "pass"  +"_0_"+i);
			listDB.add(movie);
		}
		return listDB;
	}
	
}
