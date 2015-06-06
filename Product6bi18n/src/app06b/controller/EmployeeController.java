package app06b.controller;

import java.io.File;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import app06b.domain.Employee;
import app06b.exception.ImageUploadException;

@org.springframework.stereotype.Controller

public class EmployeeController {
	
	private static final Log logger = LogFactory.getLog(EmployeeController.class);
		
	@RequestMapping(value={"/","employee_input"})
	public String inputEmployee(Employee employee) {
		return "EmployeeForm";
	}

	@RequestMapping(value="/employee_save")
	public String saveEmployee(@Valid @ModelAttribute  Employee employee, BindingResult bindingResult,
			Model model, HttpServletRequest request) {
 		
		if (bindingResult.hasErrors()) {
			return "EmployeeForm";
		}
		
		MultipartFile empImage = employee.getEmployeeImage();
		String rootDirectory = request.getSession().getServletContext().getRealPath("/");
		if(empImage == null || empImage.isEmpty()){
			throw new ImageUploadException();
		}else if(empImage != null && !empImage.isEmpty()){
			try{
				empImage.transferTo(new File(rootDirectory+"/images/"+employee.getId()+".png"));
				System.out.println("File transfered to "+rootDirectory+"/images/"+employee.getId()+".png");
				
			}catch(Exception e){
				//TODO
				System.err.println("Image file upload failed");
				throw new RuntimeException("Image file upload failed");
			}
		}
		
		String[] suppressedFields = bindingResult.getSuppressedFields();
		
		if (suppressedFields.length > 0) {
		 throw new RuntimeException("You've attempted to bind fields that haven't been allowed in initBinder(): "
		 + StringUtils.addStringToArray(suppressedFields, ", "));
		 }
		
		
		// save product here
		
	    model.addAttribute("employee", employee);
	    
	   
		return "EmployeeDetails";
	}
	
	
	@InitBinder
    public void initBinder(WebDataBinder binder) {
//         binder.setDisallowedFields("id");
//        binder.setRequiredFields("username", "password", "emailAddress");
        logger.info("initBinderin EmployeeController");
    }
}
