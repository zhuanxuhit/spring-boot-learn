package aop;

import lombok.extern.slf4j.Slf4j;
import org.joda.time.LocalTime;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;

@Slf4j
public class CGlibRunner {
    public static void main(String[] args) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(Requestable.class);
        enhancer.setCallback(
                (MethodInterceptor) (object, method, var3, methodProxy) -> {
                    if (method.getName().equals("request")){
                        log.info(String.join("||",(new String[]{object.toString(),method.toString(),var3.toString(),methodProxy.toString()})));
                        LocalTime startTime = new LocalTime(0,0,0);
                        LocalTime endTime = new LocalTime(5,59,59);
                        LocalTime currentTime = new LocalTime();
                        if (currentTime.isAfter(startTime) && currentTime.isBefore(endTime)){
                            log.warn("service is not available now!");
                            return null;
                        }
                        return methodProxy.invokeSuper(object, var3);
                    }
                    return null;
                });
        Requestable proxy = (Requestable) enhancer.create();
        proxy.request();
    }
}
