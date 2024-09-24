package _12_Data_structure;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class exercise_1 {
    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> pascal = new ArrayList<>();
        pascal.add(new ArrayList<>(Arrays.asList(1)));

        for (int i = 1; i < numRows; i++) {
            List<Integer> prevRow = pascal.get(i - 1);
            List<Integer> row = new ArrayList<>();
            row.add(1);

            for (int j = 1; j < i; j++) {
                row.add(prevRow.get(j - 1) + prevRow.get(j));
            }

            row.add(1);
            pascal.add(row);
        }

        return pascal;
    }

    public static void main(String[] args) {
        int numRows = 5;
        System.out.println(generate(numRows));
    }
}
