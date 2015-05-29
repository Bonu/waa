package mum.edu.service.impl;

import java.util.List;

import mum.edu.repository.AdviceRepository;
import mum.edu.service.AdviceService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdviceServiceImpl implements AdviceService  {

	 @Autowired
	AdviceRepository adviceRepository;

 	public List<String> getListByType(String type) {
 		return adviceRepository.getListByType(type);
 	}
		   
}
 
