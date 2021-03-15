package bg.softuni.mapstuct.advanced;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CarMapper {

  @Mapping(source = "make", target = "manufacturer")
  CarDTO carToCarDto(Car car);

  @Mapping(source = "manufacturer", target = "make")
  Car carDTOToCar(CarDTO car);

}
