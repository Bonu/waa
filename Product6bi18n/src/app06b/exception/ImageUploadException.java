package app06b.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.INTERNAL_SERVER_ERROR, reason="Issue iwth Image upload")
public class ImageUploadException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5287067299974337786L;
	
	public ImageUploadException(){
		
	}
	
	public ImageUploadException(String message){
		
	}

}
