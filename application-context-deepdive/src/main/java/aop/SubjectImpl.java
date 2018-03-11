package aop;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SubjectImpl implements ISubject{
    @Override
    public void request() {
        log.info("=========== in SubjectImpl ===========");
    }
}
