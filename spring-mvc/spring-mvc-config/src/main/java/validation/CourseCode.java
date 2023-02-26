package validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

// Give the class that has the business rules to validate the process.
@Constraint(validatedBy = CourseCodeConstraintValidator.class)
// Tells where you can apply this annotation. Methods or fields.
@Target({ElementType.METHOD, ElementType.FIELD})
// How long should we keep this annotation.
@Retention(RetentionPolicy.RUNTIME)
// Custom Annotation
public @interface CourseCode {
    // Parameter with value, if none, then is provided with default.
    // Define default course code.
    public String value() default "LUV";
    // Parameter with message, if none , then is provided with default.
    // Define default error message.
    public String message() default "must start with LUV";
    // Define default groups.
    public Class<?>[] groups() default {};
    // Define default payloads
    public Class<? extends Payload>[] payload() default {};
}
