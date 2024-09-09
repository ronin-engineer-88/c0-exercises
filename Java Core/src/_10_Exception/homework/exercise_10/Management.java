package _10_Exception.homework.exercise_10;

public class Management {
    private Student[] studentList;
    private final int capacity = 10000;
    private int count;

    public Management() {
        this.count = 0;
        this.studentList = new Student[capacity];
    }

    public void add(Student student) {
        try {
            studentList[count] = student;
            count++;
        } catch (IndexOutOfBoundsException ex) {
            System.out.println("Danh sách sinh viên đã đầy!");
        }
    }

    public Student remove(int index) throws EmptyStudentException, InvalidStudentException {
        Student student = null;
        if(count == 0){
            throw new EmptyStudentException("Danh sách sinh viên rỗng!");
        }
        if(index < 0 || index >= count)
            throw new InvalidStudentException("Chỉ số sinh viên trong danh sách không hợp lệ!");

        for(int i = index; i < count; i++){
            studentList[i] = studentList[i+1];
        }
        studentList[count] = null;
        count--;

        return studentList[index];
    }

    public Student searchStudent(String id) throws InvalidStudentException {
        for(Student s : studentList){
            if(s != null && s.getId().equals(id) ) {
                return s;
            }
        }

        throw new InvalidStudentException("Không có sinh viên nào với id " + id);
    }

    public void displayStudentList(){
        System.out.printf("%-5s %-10s %-20s %-15s %-5s\n",
                           "No.", "Id", "Name", "Department", "GPA");
        for(int i = 0; i < count; i++){
            Student student = studentList[i];
            System.out.printf("%-5d %-10s %-20s %-15s %-5.2f\n",
                    i,                                 // Chỉ số
                    student.getId(),                    // ID
                    student.getName(),                  // Tên sinh viên
                    student.getDepartment(),            // Khoa
                    student.getGPA());                  // GPA
        }
    }


    public Student[] getStudentList() {
        return studentList;
    }

    public void setStudentList(Student[] studentList) {
        this.studentList = studentList;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
