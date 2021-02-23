package bg.softuni.solid.o;

import java.util.List;

public class ShapeCalculator {

  public double calculateArea(List<Shape> shapes) {

    double area = 0;

    for (Shape shape : shapes) {
      if (shape instanceof Circle) {
        area += 3.14 * ((Circle) shape).getRadius() * ((Circle) shape).getRadius();
      } else if (shape instanceof Rectangle) {
        area += ((Rectangle) shape).getHeight() * ((Rectangle) shape).getWidth();
      }
    }

    return area;
  }

}
