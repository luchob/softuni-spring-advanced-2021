package bg.softuni.proxies.pattern;

public class RealGreeter implements GreeterIfc {
  @Override
  public void greet() {
    System.out.println("Hello, world!");
  }
}
