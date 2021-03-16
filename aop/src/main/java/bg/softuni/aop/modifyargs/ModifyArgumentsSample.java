package bg.softuni.aop.modifyargs;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ModifyArgumentsSample {

  @Pointcut("execution(* bg.softuni.aop.model.Student.echo(..))")
  public void modifyEcho() { }

  @Around("modifyEcho()")
  public void around(ProceedingJoinPoint pjp) throws Throwable {
    Object argument = pjp.getArgs()[0];
    if (argument != null) {
      argument = argument.toString() + " Modified by me";
    }
    pjp.proceed(new Object[]{argument});
  }
}
