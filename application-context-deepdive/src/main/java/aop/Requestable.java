package aop;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Requestable {
    void request(){
        log.info("in Requestable without implement any interface.");
    }
}
