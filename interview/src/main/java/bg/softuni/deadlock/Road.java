package bg.softuni.deadlock;

public class Road {
    private boolean haveCar;
    private String rightRoadName;

    public Road( boolean haveCar, String rightRoadName) {
        this.haveCar = haveCar;
        this.rightRoadName = rightRoadName;
    }

    public boolean isHaveCar() {
        return haveCar;
    }

    public void setHaveCar(boolean haveCar) {
        this.haveCar = haveCar;
    }

    public String getRightRoadName() {
        return rightRoadName;
    }

    public void setRightRoadName(String rightRoadName) {
        this.rightRoadName = rightRoadName;
    }
}
