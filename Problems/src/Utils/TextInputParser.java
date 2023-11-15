package Utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class TextInputParser {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(parseText("TestArr.txt")));
    }

    public static int[] parseText(String name) {
        File file = new File("Problems/src/DataInput/" + name);
        Scanner scanner = null;
        try {
            scanner = new Scanner(file);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        String line = scanner.nextLine();
        String[] splitLine = line.split(",");

        List<Integer> temp = new ArrayList<>();

        for (String entry : splitLine) {
            Integer number = Integer.parseInt(entry);
            temp.add(number);
        }

        int[] result = new int[temp.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = temp.get(i);
        }

        return result;
    }
}
