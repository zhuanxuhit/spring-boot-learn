package aop;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.joda.time.LocalTime;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyRunner {
    @Data
    @Slf4j
    public static class RequestControlInvocationHandler implements InvocationHandler {

        Object target;

        public RequestControlInvocationHandler(Object target) {
            this.target = target;
        }


        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            if (method.getName().equals("request")){
                LocalTime startTime = new LocalTime(0,0,0);
                LocalTime endTime = new LocalTime(5,59,59);
                LocalTime currentTime = new LocalTime();
                if (currentTime.isAfter(startTime) && currentTime.isBefore(endTime)){
                    log.warn("service is not available now!");
                    return null;
                }
                return method.invoke(target,args);
            }
            return null;
        }
    }

    public static void main(String[] args) {
        ISubject subject = (ISubject) Proxy.newProxyInstance(
                ProxyRunner.class.getClassLoader(),
                new Class[] {ISubject.class},
                new RequestControlInvocationHandler(new SubjectImpl())
                );
        subject.request();

        IRequestable requestable = (IRequestable)Proxy.newProxyInstance(
                ProxyRunner.class.getClassLoader(),
                new Class[]{IRequestable.class},
                new RequestControlInvocationHandler(new RequestableImpl())
        );
        requestable.request();

    }
}
