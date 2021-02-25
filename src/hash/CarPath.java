package hash;

import java.util.Arrays;

public class CarPath {
    public int streetsToRun;
    public String[] streets;
    public CarPath(String a) {
        String split[] = a.split(" ");
        streetsToRun = Integer.parseInt(split[0]);
        streets = new String[streetsToRun];
        for (int i = 1; i < split.length; i++) {
            streets[i - 1] = split[i];
        }
    }

    @Override
    public String toString() {
        return "CarPath{" +
                "streetsToRun=" + streetsToRun +
                ", streets=" + Arrays.toString(streets) +
                '}';
    }
}
