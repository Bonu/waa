/**
 * 
 */
package edu.mum.mscs.waa.calculator.validator;

import java.util.ArrayList;
import java.util.List;

import edu.mum.mscs.waa.calculator.domain.Calculator;



/**
 * @author 984417
 *
 */
public class CalculatorValidatorImpl implements CalculatorValidator {

	@Override
	public List<String> validate(Object object) {
		List<String> errors = new ArrayList<String>();
		
		Calculator calculator = (Calculator) object;
				
		if (calculator.getAdd1() <= 0) {
			errors.add("Please enter valid number in field Add1");
		}
		if (calculator.getAdd2() <= 0) {
			errors.add("Please enter valid number in field Add2");
		}
		if (calculator.getPrd1() <= 0) {
			errors.add("Please enter valid number in field Prd1");
		}
		if (calculator.getPrd2() <= 0) {
			errors.add("Please enter valid number in field Prd2");
		}
		return errors;
	}
	
	
}
