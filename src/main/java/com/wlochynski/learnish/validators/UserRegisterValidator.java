package com.wlochynski.learnish.validators;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.wlochynski.learnish.constants.WebSecurityConstants;
import com.wlochynski.learnish.model.User;
import com.wlochynski.learnish.utilites.WebSecurityUtils;


public class UserRegisterValidator implements Validator {
	
	@Override
	public boolean supports(Class<?> cls) {
		return User.class.equals(cls);
	}
	
	@Override
	public void validate(Object obj, Errors errors) {
		User u = (User) obj;
		
		ValidationUtils.rejectIfEmpty(errors, "email", "error.userEmail.empty");
		ValidationUtils.rejectIfEmpty(errors, "password", "error.userPassword.empty");
		
		if(!u.getEmail().equals(null))
		{
			boolean isMatch = WebSecurityUtils.checkEmailOrPassword(WebSecurityConstants.EMAIL_PATTERN, u.getEmail());
			if(!isMatch) {
				errors.rejectValue("email", "error.userEmailIsNotMatch");
			}
		}
		if(!u.getPassword().equals(null)) {
			boolean isMatch = WebSecurityUtils.checkEmailOrPassword(WebSecurityConstants.PASSWORD_PATTERN, u.getPassword());
			if(!isMatch) {
				errors.rejectValue("password", "error.userPasswordIsNotMatch");
			}
		}
	}
	
	public void ValidateEmailExist(User user, Errors errors)
	{
		if(user != null)
		{
			errors.rejectValue("email", "error.userEmailExist");
		}
	}
}