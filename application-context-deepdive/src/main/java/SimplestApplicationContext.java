import org.springframework.context.support.StaticApplicationContext;

public class SimplestApplicationContext {
    public static void main(String[] args) {
        StaticApplicationContext simplestAppCtx = new StaticApplicationContext();
        simplestAppCtx.refresh();
        simplestAppCtx.close();
    }
}
