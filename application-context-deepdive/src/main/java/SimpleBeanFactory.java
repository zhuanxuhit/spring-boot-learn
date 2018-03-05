import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.annotation.AnnotatedBeanDefinitionReader;

@Slf4j
public class SimpleBeanFactory {

    public static void main(String[] args) {
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        AnnotatedBeanDefinitionReader reader = new AnnotatedBeanDefinitionReader(beanFactory);
//        reader.registerBean(SimpleBean.class);
        reader.register(SimpleBean.class);
        System.out.println( beanFactory.getBean(SimpleBean.class));
    }
}
