package bg.softuni.proxies.pattern;

public class ProxyGreeter implements GreeterIfc{

  private final GreeterIfc greeterIfc;

  public ProxyGreeter(GreeterIfc greeterIfc) {
    this.greeterIfc = greeterIfc;
  }
  @Override
  public void greet() {
    System.out.println("Hello, I'm proxy...");
    greeterIfc.greet();
    System.out.println("Bye from proxy...");
  }
}
