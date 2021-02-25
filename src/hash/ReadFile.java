package hash;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadFile {

    public static List<String> readFileAsStringsPerLine(String file) {
        List<String> items = new ArrayList<>();
        BufferedReader br = null;
        try {
           br  = new BufferedReader(new FileReader(file));
            String line = br.readLine();

            while (line != null) {
                items.add(line);
                line = br.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return items;
    }

    public static void toFile(String fileName, List<SolutionPrinter> solutionPrinters) {
        try {
            Writer fileWriter = new FileWriter(fileName + ".txt");

            fileWriter.write(solutionPrinters.size() + "\n");
            solutionPrinters.stream().forEach(sp -> {
                sp.solution.stream().forEach(line -> {
                    try {
                        fileWriter.write(line + "\n");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                });
            });

            fileWriter.close();
        } catch (Exception e) {
            System.out.println(e);
        }

    }
}
