import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AnnotationContext {
    private AnnotationConfigApplicationContext ctx;

    public AnnotationContext() {
        ctx = new AnnotationConfigApplicationContext();
    }

    public static AnnotationContext create() {
        return new AnnotationContext();
    }

}
