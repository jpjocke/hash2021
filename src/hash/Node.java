package hash;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Node {
    int identifier;
    int carsPassingThrough;
    Map<String, Integer> incomingWeight;
    List<String> incoming;

    public Node(int identifier) {
        this.identifier = identifier;
        incoming = new ArrayList<>();
        incomingWeight = new HashMap<>();
    }

    public void addIncoming(String streetIn) {
        incoming.add(streetIn);
        incomingWeight.put(streetIn, 0);
    }

    public int streetsWithCarsPassingThrough() {
        int count = (int) incomingWeight.keySet().stream().filter(key -> incomingWeight.get(key) != 0).count();
        return count;
    }

    public void simulateCars(List<CarPath> carPaths) {
        carPaths.stream().forEach(carPath -> {
            for(int i = 0; i < carPath.streets.length - 1; i++) {
                String street = carPath.streets[i];
                Integer weight = incomingWeight.get(street);
                if (weight != null) {
                    weight++;
                    incomingWeight.put(street, weight);
                    carsPassingThrough++;
                }
            }
        });
    }

    @Override
    public String toString() {
        return "Node{" +
                "identifier=" + identifier +
                ", carsPassingThrough=" + carsPassingThrough +
                ", incomingWeight=" + incomingWeight +
                ", incoming=" + incoming +
                '}';
    }
}
