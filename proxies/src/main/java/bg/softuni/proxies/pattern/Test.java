package bg.softuni.proxies.pattern;

public class Test {

  public static void main(String[] args) {
    GreeterIfc greeterIfc = new ProxyGreeter(new RealGreeter());
    greeterIfc.greet();
  }

}
