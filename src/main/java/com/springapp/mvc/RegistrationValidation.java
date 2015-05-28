package com.springapp.mvc;

import com.springapp.mvc.form.Registration;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;

@Component("registrationValidator")
public class RegistrationValidation {
    Errors errors;
    public boolean supports(Class<?> klass) {
        return Registration.class.isAssignableFrom(klass);
    }

    public void validate(Object target, Errors err) {
        Registration registration = (Registration) target;
        errors = err;
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "firstName","","Имя не заполнено");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "lastName","","Фамилия не заполнена");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "", "E-mail не заполнен");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "", "Пароль не заполнен");
        String email = registration.getEmail();
        if ((email.length()) > 60) {
            errors.rejectValue("email","","E-mail длинный");
        }
        String firstName = registration.getFirstName();
        if ((firstName.length()) > 30) {
            errors.rejectValue("firstName","","Имя слишком длинное");
        }
        String lastName = registration.getLastName();
        if ((lastName.length()) > 30) {
            errors.rejectValue("lastName","","Фамилия слишком длинная");
        }
        String phone = registration.getPhone();
        if ((phone.length()) > 20) {
            errors.rejectValue("phone","","Телефон слишком длинный");
        }
        if (!(registration.getPassword()).equals(registration.getConfirmPassword())) {
            errors.rejectValue("password","","Пароли не совпадают");
        }
    }

    public void userExistsError()
    {
        errors.rejectValue("email", "", "Пользователь уже существует");
    }
}