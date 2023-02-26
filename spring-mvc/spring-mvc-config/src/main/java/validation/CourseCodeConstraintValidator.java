package validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

// Helper class that contains business rules for validation.
// Passes CourseCode annotation and the type of data we are validating against.
public class CourseCodeConstraintValidator implements ConstraintValidator<CourseCode, String> {
    private String coursePrefix;
    // When is created, then this will be the initialized. It sets everything up.
    @Override
    public void initialize(CourseCode courseCode) {
        this.coursePrefix = courseCode.value();
    }

    // Spring MVC will call this at runtime and check if is valid.
    @Override
    public boolean isValid(String code, ConstraintValidatorContext constraintValidatorContext) {
        boolean result;
        if(code != null){
            // If user does not enter anything.
            result = code.startsWith(this.coursePrefix);
        }else{
            // If the code is empty then pass true since it is not required.
            result = true;
        }
        return result;
    }
}
