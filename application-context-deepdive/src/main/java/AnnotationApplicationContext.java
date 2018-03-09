import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AnnotationApplicationContext {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.scan("bean");
        context.refresh();
//        context.refresh();
        context.getBean("simpleBean");
        context.close();
    }
}
