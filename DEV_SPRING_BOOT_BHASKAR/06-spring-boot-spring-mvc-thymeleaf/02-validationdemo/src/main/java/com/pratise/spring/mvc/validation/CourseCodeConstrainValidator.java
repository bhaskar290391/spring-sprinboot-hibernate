package com.pratise.spring.mvc.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.lang.annotation.Annotation;

public class CourseCodeConstrainValidator implements ConstraintValidator<CourseCode,String> {

    public String prefix;

    @Override
    public void initialize(CourseCode code) {
        prefix=code.value();
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {

        if(value !=null){
            return value.startsWith(prefix);
        }else {
            return  true;
        }

    }
}
