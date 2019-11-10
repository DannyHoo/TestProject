package com.example.aspect;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class HttpAspect {

    private static final Logger logger = LoggerFactory.getLogger(HttpAspect.class);

    @Pointcut("execution(public * com.example.controller.StudentController.*(..))")
    public void log()
    {

    }

    @Before("log()")
    public void doBefore()
    {
      logger.info("11111111");
    }

    @After("log()")
    public void doAfter()
    {
        logger.info("22222222");
    }
}
