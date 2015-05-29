/**
 * 
 */
package edu.mum.mscs.waa.lab4.starbucksspringmvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.mum.mscs.waa.lab4.starbucksspringmvc.repository.AdviceRepository;

/**
 * @author janardhanbonu
 *
 */
@Service
public class AdviceServiceImpl implements AdviceService {

	@Autowired
	AdviceRepository adviceRepository;
	
	public List<String> getAdviceDetails(String roastAdvice){
		return adviceRepository.getRoastAdviceDetails(roastAdvice);
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
