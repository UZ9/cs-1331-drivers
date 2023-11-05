import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.FIELD })
public @interface InjectData {
    /**
     * The name of the file data is injected from
     * 
     * @return The name of the TestCase
     */
    public String name();
}
