package hash;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Controller {

    public List<SolutionPrinter> calculate(MainInfo mi, List<Street> streets, List<CarPath> carPaths) {
        Map<Integer, Node> intersections = new HashMap<>();
        streets.stream().forEach(street -> {
            int id = street.intersectionEnd;
            Node n = intersections.getOrDefault(id, new Node(id));
            n.addIncoming(street.name);
            intersections.put(id, n);
        });

        intersections.keySet().stream().forEach(k -> {
            intersections.get(k).simulateCars(carPaths);
            // System.out.println(intersections.get(k));
        });

        List<SolutionPrinter> solutionPrinters = new ArrayList<>();

        intersections.keySet().stream().forEach(k -> {
            Node intersection = intersections.get(k);
            if (intersection.carsPassingThrough == 0) {
                return;
            }

            SolutionPrinter sp = new SolutionPrinter();

            sp.addLine(intersection.identifier);
            sp.addLine(intersection.streetsWithCarsPassingThrough());
            intersection.incomingWeight.keySet().stream().forEach(key -> {
                int weight = intersection.incomingWeight.get(key);
                if (weight == 0) {
                    return;
                }
                sp.addLine(key + " " + "1");
            });
            solutionPrinters.add(sp);
        });

        return solutionPrinters;


    }
}