package mum.edu.service.impl;

import java.util.List;

import mum.edu.data.Database;
import mum.edu.service.AdviceService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdviceServiceImpl implements AdviceService  {

	 @Autowired
		Database data;

 	public List<String> getListByType(String type) {
 		return data.advice.get(type);
 	}
		   
}
 
