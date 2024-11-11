package _24_Algorithm3_Advanced_sort;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Exercise10 {

    public static int count = 0;
    public static boolean found = false;

    public static void main(String[] args) {
        ArrayList<HashMap<Integer, Integer>> listInput = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        while(true) {
            if (!scanner.hasNextInt()) break;
            int k = scanner.nextInt();
            if (!scanner.hasNextInt()) break;
            int n = scanner.nextInt();
            if(k == 0 && n == 0)
                break;
            else {
                listInput.add(new HashMap<>() {{put(k,n);}});
            }
        }

        int count1 = 1;
        for(HashMap<Integer, Integer> input : listInput) {
            System.out.print("Case " + count1 + ": ");
            for (HashMap.Entry<Integer, Integer> entry : input.entrySet()) {
                int k = entry.getKey();
                int n = entry.getValue();
                chuyen(k, n, 'A', 'B', 'C');
            }
            count = 0;
            found = false;
            count1++;
        }
    }

    public static void chuyen(int k, int n, char CocNguon, char CocTG, char CocDich) {
        if(n == 0 || found) return;
        chuyen(k, n-1, CocNguon, CocDich, CocTG);
        count++;
        if(count == k) {
            System.out.println(n + " " + CocNguon + " " + CocDich);
            found = true;
            return;
        }
        chuyen(k,n-1, CocTG, CocNguon, CocDich);
    }




}
