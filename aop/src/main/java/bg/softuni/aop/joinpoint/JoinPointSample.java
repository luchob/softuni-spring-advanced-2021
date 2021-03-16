package bg.softuni.aop.joinpoint;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

//@Aspect
//@Component
public class JoinPointSample {

  @Pointcut("execution(* bg.softuni.aop.model.Student.echo(..))")
  public void trackEcho() { }

  @Before("trackEcho()")
  public void around(JoinPoint jp) throws Throwable {
    for (Object argument: jp.getArgs()) {
      System.out.println("Argument: " + argument);
    }
    System.out.println(jp.getKind());
    System.out.println(jp.getSignature());
    System.out.println(jp.getTarget());
  }

}
