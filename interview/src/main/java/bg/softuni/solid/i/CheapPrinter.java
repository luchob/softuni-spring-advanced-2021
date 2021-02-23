package bg.softuni.solid.i;

public class CheapPrinter implements SmartDevice{

  @Override
  public void print() {
    //todo
  }

  @Override
  public void scan() {
    throw new UnsupportedOperationException();
  }

  @Override
  public void fax() {
    throw new UnsupportedOperationException();
  }
}
