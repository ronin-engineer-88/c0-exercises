package _12_Data_structure;

import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Scanner;

public class exercise_4 {
    public static void main(String[] args) {
        Deque<Integer> queue = new LinkedList<>();
        Deque<Object> result = new LinkedList<>();
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        while(n > 0){
            boolean flag = false;
            int choice = scanner.nextInt();
            switch(choice){
                case 1:
                    result.add(queue.size());
                    flag = true;
                    break;
                case 2:
                    if(queue.isEmpty())
                        result.add("YES");
                    else
                        result.add("NO");
                    flag = true;
                    break;
                case 3:
                    int num = scanner.nextInt();
                    queue.add(num);
                    flag = true;
                    break;
                case 4:
                    if(!queue.isEmpty())
                        queue.poll();
                    flag = true;
                    break;
                case 5:
                    if(!queue.isEmpty())
                        result.add(queue.peek());
                    else
                        result.add(-1);
                    flag = true;
                    break;
                case 6:
                    if(!queue.isEmpty())
                        result.add(queue.getLast());
                    else
                        result.add(-1);
                    flag = true;
                    break;
                default:
                    System.out.println("Nhập lại");
                    break;
            }
            if(flag) n--;
        }

        while (!result.isEmpty()){
            System.out.println(result.poll());
        }
    }
}
