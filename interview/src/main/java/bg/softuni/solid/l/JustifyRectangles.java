package bg.softuni.solid.l;

import java.util.List;

public class JustifyRectangles {

  public void justify(List<Rectangle> rectangleList) {
    rectangleList.forEach(r -> r.setWidth(3));
  }

}
