package hash;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        long tick = System.currentTimeMillis();
        String folder = "./files/";
        runForFile(folder + "a");
        runForFile(folder+ "b");
        runForFile(folder + "c");
        runForFile(folder + "d");
        runForFile(folder + "e");

        long tock = System.currentTimeMillis();

        System.out.println("Time : " + (tock - tick) + "ms");
        // orig 532 ms
        // weights 39000 ms
    }

    private static void runForFile(String fileName) {
        System.out.println("File : " + fileName + "ms");
        List<String> aaa = ReadFile.readFileAsStringsPerLine(fileName + ".txt");

        int index = 0;
        MainInfo a = new MainInfo(aaa.get(index));
        List<Street> streets = new ArrayList<>();
        List<CarPath> carPaths = new ArrayList<>();
        index++;
        for (int i = 1; i <= a.streetCount; i++) {
            Street s = new Street(aaa.get(i));
            streets.add(s);
            index++;
        }
        while (index < aaa.size()) {
            CarPath cp = new CarPath(aaa.get(index));
            carPaths.add(cp);
            index++;
        }

        Controller c = new Controller();
        List<SolutionPrinter> solutionPrinters = c.calculate(a, streets, carPaths);

        ReadFile.toFile(fileName + "_solution", solutionPrinters);
    }
}
