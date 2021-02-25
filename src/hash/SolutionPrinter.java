package hash;

import java.util.ArrayList;
import java.util.List;

public class SolutionPrinter {
    public List<String> solution = new ArrayList<>();

    public void addLine(String line) {
        solution.add(line);
    }


    public void addLine(int line) {
        solution.add(Integer.toString(line));
    }

}
