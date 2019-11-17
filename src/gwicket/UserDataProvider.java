package gwicket;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.wicket.extensions.markup.html.repeater.util.SortableDataProvider;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.LoadableDetachableModel;

public class UserDataProvider extends SortableDataProvider<User>{

	List <User> userDB = new ArrayList<>();
	
	 public UserDataProvider() {
		for (int i=0; i <100; i++)
		{
			User user = new User();
		
			user.setUsername( "user"  +"_0_"+i);
			user.setPassword( "pass"  +"_0_"+i);
			userDB.add(user);
		}
	}
	@Override
	public Iterator<? extends User> iterator(int first, int count) {
		List <User> newUserList = new ArrayList<>();
		newUserList=	userDB.subList(first,first+count);
		
		return 	newUserList.iterator();	
		}

	@Override
	public IModel<User> model(User Object) {
		return new LoadableDetachableModel<User>(){

			@Override
			protected User load() {
				// TODO Auto-generated method stub
				return Object;
			}
		};
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return userDB.size();
	}

}
