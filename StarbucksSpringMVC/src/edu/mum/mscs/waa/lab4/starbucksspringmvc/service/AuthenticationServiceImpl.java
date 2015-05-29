/**
 * 
 */
package edu.mum.mscs.waa.lab4.starbucksspringmvc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.mum.mscs.waa.lab4.starbucksspringmvc.domain.User;
import edu.mum.mscs.waa.lab4.starbucksspringmvc.repository.UserRepository;

/**
 * @author janardhanbonu
 *
 */
@Service
public class AuthenticationServiceImpl implements AuthenticationService {

	@Autowired
	UserRepository userRepository;
	
	public boolean validateUserCredentials(User user){
		return userRepository.checkUser(user);
	}
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
