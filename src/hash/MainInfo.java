package hash;

public class MainInfo {
    public int simulationTime, intersections, streetCount, cars, points;
    public MainInfo(String a) {
        String split[] = a.split(" ");
        simulationTime = Integer.parseInt(split[0]);
        intersections = Integer.parseInt(split[1]);
        streetCount = Integer.parseInt(split[2]);
        cars = Integer.parseInt(split[3]);
        points = Integer.parseInt(split[4]);
    }

    @Override
    public String toString() {
        return "LineOne{" +
                "simulationTime=" + simulationTime +
                ", intersections=" + intersections +
                ", streets=" + streetCount +
                ", cars=" + cars +
                ", points=" + points +
                '}';
    }
}
