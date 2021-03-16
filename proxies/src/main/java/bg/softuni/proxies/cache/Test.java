package bg.softuni.proxies.cache;

import java.lang.reflect.Proxy;

public class Test {

  public static void main(String[] args) {
    Object toProxy = new StudentService();

    StudentServiceIfc studentService = (StudentServiceIfc)Proxy.
        newProxyInstance(
           Test.class.getClassLoader(),
           new Class[]{StudentServiceIfc.class},
           new CacheableInvocationHandler(toProxy)
        );

    System.out.println(studentService.getAllStudents());
    System.out.println(studentService.getAllStudents());
  }

}
