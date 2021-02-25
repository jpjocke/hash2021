package hash;

import sun.misc.IOUtils;
import sun.reflect.misc.FieldUtil;

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

        System.out.println(intersections.keySet().size());
        intersections.keySet().stream().forEach(k -> {
            SolutionPrinter sp = new SolutionPrinter();

            Node intersection = intersections.get(k);
            //System.out.println(intersection);
            sp.addLine(intersection.identifier);
            sp.addLine(intersection.incoming.size());
            intersection.incoming.stream().forEach(in -> sp.addLine(in + " 1"));
            solutionPrinters.add(sp);
        });

        return solutionPrinters;


    }
}

/**
 3
 1
 2
 rue-d-athenes 2
 rue-d-amsterdam 1
 0
 1
 rue-de-londres 2
 2
 1
 rue-de-moscou 1

 */