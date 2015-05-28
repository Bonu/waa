package mum.edu.data;

import java.util.List;

public class TestDataImpl implements DataFacade {
	public String findPassword (String name ) {
		Database data = new Database();
		String expectedPassword = data.getPassword(name);
		return expectedPassword;
	}
	
	public List<String> getAdvice(String roast) { 
		Database data = new Database();
		return data.getAdvice(roast);
	}
}
