package bg.softuni.mapstuct.advanced;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CarMapperExample implements CommandLineRunner {

  private final CarMapper carMapper;

  public CarMapperExample(CarMapper carMapper) {
    this.carMapper = carMapper;
  }

  @Override
  public void run(String... args)  {

    Car car = new Car().setMake("Ford");
    CarDTO carDTO = new CarDTO().setManufacturer("Toyota");

    Car mappedCar = carMapper.carDTOToCar(carDTO);
    CarDTO mappedCarDTO = carMapper.carToCarDto(car);

    System.out.println(mappedCar);
    System.out.println(mappedCarDTO);

  }
}
