import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.Assert.*;

public class AnnotationContextTest {

    @Test
    public void simple() throws Exception {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.scan("bean");
        context.refresh();
//        context.refresh();
        context.close();
    }
}