package _12_Data_structure.exercise_10;

import java.util.NoSuchElementException;

public class DoubleLinkedList {
    private Node head;
    private Node tail;
    private int size;
    public DoubleLinkedList(){
        this.head = null;
        this.tail = null;
        size = 0;
    }
    public int size(){
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
    }
    public void addFirst(int data){
        Node newNode = new Node(data);
        if(isEmpty()){
            head = newNode;
            tail = newNode;
        } else {
            newNode.setNext(head);
            head.setPrev(newNode);
            head = newNode;
        }
        size++;
    }
    public void addLast(int data){
        Node newNode = new Node(data);
        if(isEmpty()){
            head = newNode;
            tail = newNode;
        } else {
            newNode.setPrev(tail);
            tail.setNext(newNode);
            tail = newNode;
        }
        size++;
    }
    public void insert(int index, int data){
        Node newNode = new Node(data);
        if(index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        if(index == 0)
            addFirst(data);
        else if (index == size - 1)
            addLast(data);
        else {
            Node current = head;

            int count = 0;
            while(count != index){
                current = current.getNext();
                count++;
            }

            newNode.setNext(current);
            newNode.setPrev(current.getPrev());
            current.getPrev().setNext(newNode);
            current.setPrev(newNode);
            size++;
        }
    }
    public int removeFirst(){
        if(isEmpty())
            throw new NoSuchElementException();

        Node current = head;
        head = current.getNext();

        if(head != null)
            head.setPrev(null);
        else
            tail = null;

        size--;

        return current.getData();
    }
    public int removeLast(){
        if(isEmpty())
            throw new NoSuchElementException();

        Node current = tail;
        tail = current.getPrev();

        if(tail != null)
            tail.setNext(null);
        else
            head = null;

        size--;

        return current.getData();
    }
    public int remove(int index){
        if(index < 0 || index >= size)
            throw new IndexOutOfBoundsException();

        if(index == 0)
            return removeFirst();

        else if(index == size - 1)
            return removeLast();

        else {
            Node current = head;
            int count = 0;
            while(count != index){
                current = current.getNext();
                count++;
            }

            current.getPrev().setNext(current.getNext());
            current.getNext().setPrev(current.getNext());
            size--;
            return current.getData();
        }
    }
    public int getFirst(){
        if(isEmpty())
            throw new NoSuchElementException();

        return head.getData();
    }
    public int getLast(){
        if(isEmpty())
            throw new NoSuchElementException();

        return tail.getData();
    }
    public int get(int index){
        if(index < 0 || index > size - 1)
            throw new NoSuchElementException();

        Node current = head;
        int count = 0;
        while(count != index){
            current = current.getNext();
            count++;
        }

        return current.getData();
    }
    public void clear(){
        if(isEmpty())
            return;
        else{
            head = null;
            tail = null;
            size = 0;
        }
    }
    public void showList(){
        if(isEmpty())
            System.out.println("Danh sách rỗng!");
        else{
            Node current = head;
            while(current != null){
                System.out.print(current.getData());
                current = current.getNext();
                if(current != null)
                    System.out.print(" --> ");
            }
        }
    }
}
