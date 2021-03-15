package bg.softuni.mapstuct.advanced;

public class Car {

  private String make;

  public String getMake() {
    return make;
  }

  public Car setMake(String make) {
    this.make = make;
    return this;
  }

  @Override
  public String toString() {
    return "Car{" +
        "make='" + make + '\'' +
        '}';
  }
}
