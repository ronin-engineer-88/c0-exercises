package _12_Data_structure.exercise_10;

import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        DoubleLinkedList list = new DoubleLinkedList();

        // Test addFirst() và addLast()
        list.addFirst(10);
        list.addFirst(20);
        list.addLast(30);
        list.addLast(40);
        System.out.println("Danh sách sau khi thêm phần tử:");
        list.showList();  // Kết quả mong muốn: 20 --> 10 --> 30 --> 40
        System.out.println("\nKích thước của danh sách: " + list.size());

        // Test getFirst() và getLast()
        System.out.println("Phần tử đầu tiên: " + list.getFirst());  // Kết quả mong muốn: 20
        System.out.println("Phần tử cuối cùng: " + list.getLast());  // Kết quả mong muốn: 40

        // Test insert()
        list.insert(2, 25);  // Chèn 25 vào vị trí thứ 2
        System.out.println("Danh sách sau khi chèn phần tử 25 vào vị trí thứ 2:");
        list.showList();  // Kết quả mong muốn: 20 --> 10 --> 25 --> 30 --> 40
        System.out.println("\nKích thước của danh sách: " + list.size());

        // Test removeFirst()
        list.removeFirst();
        System.out.println("Danh sách sau khi xóa phần tử đầu tiên:");
        list.showList();  // Kết quả mong muốn: 10 --> 25 --> 30 --> 40
        System.out.println("\nKích thước của danh sách: " + list.size());

        // Test removeLast()
        list.removeLast();
        System.out.println("Danh sách sau khi xóa phần tử cuối cùng:");
        list.showList();  // Kết quả mong muốn: 10 --> 25 --> 30
        System.out.println("\nKích thước của danh sách: " + list.size());

        // Test remove(int index)
        list.remove(1);  // Xóa phần tử ở vị trí thứ 1
        System.out.println("Danh sách sau khi xóa phần tử tại vị trí 1:");
        list.showList();  // Kết quả mong muốn: 10 --> 30
        System.out.println("\nKích thước của danh sách: " + list.size());

        // Test get()
        System.out.println("Phần tử ở vị trí 1: " + list.get(1));  // Kết quả mong muốn: 30

        // Test clear()
        list.clear();
        System.out.println("Danh sách sau khi xóa toàn bộ phần tử:");
        list.showList();  // Kết quả mong muốn: Danh sách rỗng!
        System.out.println("\nKích thước của danh sách: " + list.size());
    }
}
