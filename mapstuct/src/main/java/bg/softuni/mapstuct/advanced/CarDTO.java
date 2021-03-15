package bg.softuni.mapstuct.advanced;

public class CarDTO {

  private String manufacturer;

  public String getManufacturer() {
    return manufacturer;
  }

  public CarDTO setManufacturer(String manufacturer) {
    this.manufacturer = manufacturer;
    return this;
  }

  @Override
  public String toString() {
    return "CarDTO{" +
        "manufacturer='" + manufacturer + '\'' +
        '}';
  }
}
