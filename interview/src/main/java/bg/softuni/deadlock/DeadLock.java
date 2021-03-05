package bg.softuni.deadlock;

public class DeadLock {

// може да бъде и left , right , opposite and you за имена на пътищата
// в примера приемам , че колите се движат само направо , няма такива със специален режим на движение
// и пътищата са равнопоставени
// на пътя на който има кола се поставя 'true' , както съм написал по-долу
    public static void main(String[] args) {
        Map<String, Road> roads = new LinkedHashMap<>();
        roads.put("South", new Road(true, "East")); //your car
        roads.put("East", new Road(true, "North")); //'true' if have car on road
        roads.put("North", new Road(false, "West")); //'true' if have car on road
        roads.put("West", new Road(true, "South")); //'true' if have car on road
        final boolean[] haveCar = {true};
        while (haveCar[0]) {
            haveCar[0] = false;
            roads.keySet().forEach(r -> {
                if (crossRoad(roads, r, r)) {
                    haveCar[0] = true;
                }
            });
        }
    }

    private static boolean crossRoad(Map<String, Road> roads, String roadName, String startRoad) {
        if (roads.get(roadName).isHaveCar()) {
            if (roads.get(roads.get(roadName).getRightRoadName()).isHaveCar()) {
                if (startRoad.equals(roads.get(roadName).getRightRoadName())) {
                    System.out.println("We have deadlock.");
                    System.out.println("You must cross last.");
                    System.out.println();
                    System.out.println(String.format("Car on %s road pass.", roadName));
                    roads.get(roadName).setHaveCar(false);
                } else {
                    crossRoad(roads, roads.get(roadName).getRightRoadName(), startRoad);
                }
            } else {
                System.out.println(String.format("Car on %s road pass.", roadName));
                roads.get(roadName).setHaveCar(false);
            }
            return true;
        }
        return false;
    }

}
