import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.junit.Test;
import org.springframework.context.ApplicationContext;

import static org.junit.Assert.*;

public class StaticContextTest {

    @Data
    public static class InnerBean {

        private String prop1;
        private String prop2;

//        public InnerBean() {
//        }
    }
    @Data
    public static class OuterBean {
        private String prop1;
        private InnerBean inner;
    }



    @Test
    public void basicBean(){
        StaticContext sc = StaticContext.create();
        sc.bean("basic", InnerBean.class).prop("prop1", "abc").
                prop("prop2", "def").build();
        ApplicationContext ctx = sc.build();
        assertNotNull(ctx);
        InnerBean bean = (InnerBean) ctx.getBean("basic");
        assertNotNull(bean);
        assertEquals("abc", bean.getProp1());
        assertEquals("def", bean.getProp2());
    }

    @Test
    public void innerBean() {
        StaticContext sc = StaticContext.create();
        sc.bean("outer", OuterBean.class).prop("prop1", "xyz").
                ref("inner", "inner").build();
        sc.bean("inner", InnerBean.class).prop("prop1", "ghi").
                prop("prop2", "jkl").build();
        ApplicationContext ctx = sc.build();
        assertNotNull(ctx);
        InnerBean inner = (InnerBean) ctx.getBean("inner");
        assertNotNull(inner);
        assertEquals("ghi", inner.getProp1());
        assertEquals("jkl", inner.getProp2());
        OuterBean outer = (OuterBean) ctx.getBean(OuterBean.class);
        assertNotNull(outer);
        assertEquals("xyz", outer.getProp1());
        assertEquals(inner, outer.getInner());
    }
}