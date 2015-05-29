package edu.mum.mscs.waa.lab4.starbucksspringmvc.service;

import edu.mum.mscs.waa.lab4.starbucksspringmvc.domain.User;

public interface AuthenticationService {

	public boolean validateUserCredentials(User user);
}
