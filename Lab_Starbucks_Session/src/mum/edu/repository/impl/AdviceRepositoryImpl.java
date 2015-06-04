package mum.edu.repository.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import mum.edu.data.Database;
import mum.edu.repository.AdviceRepository;

@Repository 
public class AdviceRepositoryImpl implements AdviceRepository  {

	 @Autowired
	Database data;

 	public List<String> getListByType(String type) {
 		return data.advice.get(type);
 	}
		   
}
 
