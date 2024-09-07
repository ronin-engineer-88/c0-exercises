package _12_Data_structure;

public class exercise_9 {
    static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    static class SinglyLinkedList {
        Node head;

        public SinglyLinkedList() {
            this.head = null;
        }

        public void insert(int data) {
            Node newNode = new Node(data); // Tạo một nút mới
            if (head == null) {
                head = newNode;
            } else {
                Node current = head;
                while (current.next != null) {
                    current = current.next;
                }
                current.next = newNode;
            }
        }

        public void delete(int data) {
            if (head == null) {
                System.out.println("Danh sách rỗng.");
                return;
            }
            if (head.data == data) {
                head = head.next;
                return;
            }

            Node current = head;
            while (current.next != null && current.next.data != data) {
                current = current.next;
            }

            if (current.next != null) {
                current.next = current.next.next;
            } else {
                System.out.println("Không tìm thấy phần tử " + data);
            }
        }

        public void showNode() {
            if (head == null) {
                System.out.println("Danh sách rỗng.");
                return;
            }

            Node current = head;
            while (current != null) {
                System.out.print(current.data + " -> ");
                current = current.next;
            }
            System.out.println("null");
        }
    }

    public static void main(String[] args) {
        SinglyLinkedList list = new SinglyLinkedList();

        // Thêm phần tử vào danh sách
        list.insert(10);
        list.insert(20);
        list.insert(30);
        list.insert(40);

        // Hiển thị danh sách
        System.out.println("Danh sách sau khi thêm các phần tử:");
        list.showNode();

        // delete một phần tử trong danh sách
        list.delete(20);
        System.out.println("Danh sách sau khi xóa phần tử 20:");
        list.showNode();

        // delete phần tử không tồn tại
        list.delete(50);
        System.out.println("Danh sách sau khi thử xóa phần tử không tồn tại:");
        list.showNode();
    }
}

