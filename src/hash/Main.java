package hash;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        List<String> aaa = ReadFile.readFileAsStringsPerLine("a.txt");
        aaa.stream().forEach(s -> System.out.println(s));

        int index = 0;
        MainInfo a = new MainInfo(aaa.get(index));
        System.out.println(a);
        List<Street> streets = new ArrayList<>();
        List<CarPath> carPaths = new ArrayList<>();
        index++;
        for (int i = 1; i <= a.streetCount; i++) {
            Street s = new Street(aaa.get(i));
            streets.add(s);
            System.out.println(s);
            index++;
        }
        while (index < aaa.size()) {
            CarPath cp = new CarPath(aaa.get(index));
            carPaths.add(cp);
            System.out.println(cp);
            index++;
        }

        Controller c = new Controller();
        c.calculate(a, streets, carPaths);
    }
}
