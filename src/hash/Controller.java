package hash;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Controller {

    public List<SolutionPrinter> calculate(MainInfo mi, List<Street> streets, List<CarPath> carPaths) {
        Map<Integer, Node> intersections= new HashMap<>();
        streets.stream().forEach(street -> {
            int id = street.intersectionEnd;
            Node n = intersections.getOrDefault(id, new Node(id));
            n.addIncoming(street.name);
            intersections.put(id, n);
        });

        List<SolutionPrinter> solutionPrinters = new ArrayList<>();

        intersections.keySet().stream().forEach(k -> {
            SolutionPrinter sp = new SolutionPrinter();

            Node intersection = intersections.get(k);
            sp.addLine(intersection.identifier);
            sp.addLine(intersection.incoming.size());
            intersection.incoming.stream().forEach(in -> sp.addLine(in + " 1"));
            solutionPrinters.add(sp);
        });

        return solutionPrinters;


    }
}