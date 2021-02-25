package hash;

import java.util.ArrayList;
import java.util.List;

public class Node {
    int identifier;
    List<String> incoming;

    public Node(int identifier) {
        this.identifier = identifier;
        incoming = new ArrayList<>();
    }

    public void addIncoming(String streetIn) {
        incoming.add(streetIn);
    }

    @Override
    public String toString() {
        return "Node{" +
                "identifier=" + identifier +
                ", incoming=" + incoming +
                '}';
    }
}
