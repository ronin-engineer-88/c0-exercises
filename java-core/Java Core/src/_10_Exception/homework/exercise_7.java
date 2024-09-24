package _10_Exception.homework;


import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class exercise_7 {

    public static void main(String[] args) throws IOException {
        String filePath = "D:\\test.txt";   // file your.
        System.out.println(readFile(filePath));
    }

    public static String readFile(String filename) throws IOException {
        String content = null;
        File file = new File(filename);
        FileReader reader = null;
        try {
            reader = new FileReader(file);
            char[] chars = new char[(int) file.length()];
            reader.read(chars);
            content = new String(chars);
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(reader != null){
                reader.close();
            }
        }
        return content;
    }
}
