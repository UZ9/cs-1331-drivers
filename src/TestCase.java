import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.METHOD })
@interface TestCase {
    /**
     * The name of the TestCase, used for describing what a test might be doing
     * 
     * @return The name of the TestCase
     */
    public String name() default "UNNAMED_TEST";
}