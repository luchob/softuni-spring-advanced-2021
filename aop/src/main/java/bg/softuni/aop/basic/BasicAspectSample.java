package bg.softuni.aop.basic;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

//@Aspect
//@Component
public class BasicAspectSample {

  @Pointcut("execution(* bg.softuni.aop.model.Student.sayHello())")
  public void trackSayHello() { }

  @Before("trackSayHello()")
  public void before() {
    System.out.println("Before hello.");
  }

  @After("trackSayHello()")
  public void after() {
    System.out.println("After hello.");
  }

  @Around("trackSayHello()")
  public void around(ProceedingJoinPoint pjp) throws Throwable {
    System.out.println("In around, before");
    pjp.proceed();
    System.out.println("In around after.");
  }
}
