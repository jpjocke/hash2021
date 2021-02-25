package hash;

import java.util.*;

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
            intersections.get(k).removeZeros();
        });

        List<SolutionPrinter> solutionPrinters = new ArrayList<>();

        intersections.keySet().stream().forEach(k -> {
            Node intersection = intersections.get(k);
            if (intersection.carsPassingThrough == 0) {
                return;
            }

            SolutionPrinter sp = new SolutionPrinter();

            sp.addLine(intersection.identifier);
            sp.addLine(intersection.incomingWeight.keySet().size());
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

    private int getGCD(Node intersection) {
        int[] weights = new int[intersection.incomingWeight.size()];
        Set s = intersection.incomingWeight.keySet();
        for(int i = 0; i < s.size(); i++) {
            weights[i] = intersection.incomingWeight.get(s.toArray()[i]);
        }
        return getGCD((Integer[])intersection.incomingWeight.values().toArray());
    }

    public int getGCD(int a, int b) {
        if (b == 0) {
            return a;
        }
        return getGCD(b, a % b);
    }
    public int getGCD(int... a) {
        // the GCD of a number with itself is... itself
        int gcd = a[0];
        // compute incrementally
        for( int i=1; i<a.length; i++ ) {
            gcd = getGCD( gcd, a[i] );
        }
        // return result
        return gcd;
    }
}