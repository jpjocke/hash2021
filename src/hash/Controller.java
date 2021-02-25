package hash;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Controller {

    public void calculate(MainInfo mi, List<Street> streets, List<CarPath> carPaths) {
        Map<Integer, Node> intersections= new HashMap<>();
        streets.stream().forEach(street -> {
            int id = street.intersectionEnd;
            Node n = intersections.getOrDefault(id, new Node(id));
            n.addIncoming(street.name);
            intersections.put(id, n);
        });

        System.out.println(intersections.keySet().size());
        intersections.keySet().stream().forEach(k -> {
            Node intersection = intersections.get(k);
            //System.out.println(intersection);
            System.out.println(intersection.identifier);
            System.out.println(intersection.incoming.size());
            intersection.incoming.stream().forEach(in -> System.out.println(in + " 1"));

        });


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