package edu.mum.mscs.waa.lab4.starbucksspringmvc.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale.Category;

import org.springframework.stereotype.Repository;

import edu.mum.mscs.waa.lab4.starbucksspringmvc.domain.User;

@Repository
public class UserRepositoryImpl implements UserRepository {

	private List<User> users;

	public UserRepositoryImpl() {
		users = new ArrayList<User>();
		users.add(new User( "Dave", "111"));
		users.add(new User("Steve", "222"));
		users.add(new User("Ralph", "333"));
	}

	@Override
	public boolean checkUser(User inuser) {
		for (User user : users) {
			if(user.equals(inuser)){
				return true;
			}else{
				return false;
			}
		}
		return false;
	}

}
