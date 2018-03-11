package aop;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class RequestableImpl implements IRequestable{
    @Override
    public void request() {
        log.info("=========== in RequestableImpl ===========");
    }
}
