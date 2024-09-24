package _12_Data_structure.exercise_6;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập vào đường dẫn địa chỉ của file html muốn test: ");
        String location = scanner.nextLine();
        System.out.print("Nhập tên file html: ");
        String fileName = scanner.nextLine();

        String filePath = location + File.separator + fileName;
        boolean isValid = isValidHTMLFile(filePath);

        if (isValid) {
            System.out.println("Tất cả thẻ đều hợp lệ.");
        } else {
            System.out.println("Có thẻ không hợp lệ trong file.");
        }

        scanner.close();
    }

    public static boolean isValidHTMLFile(String filePath){
        Stack<String> tagStack = new Stack<>();
        try(BufferedReader br = new BufferedReader(new FileReader(filePath))){
            String line;
            List<String> lines = new ArrayList<>();
            while((line  = br.readLine()) != null) {
                line = line.trim();
                lines.add(line);
            }
            List<String> tags = new ArrayList<>();
            for(String l : lines) {
                tags.addAll(extractTags(l));
            }
            tags = correctData(tags);
            for(String tag : tags){
                if(!isValidTag(tag))
                    return false;
                if(isClosingTag(tag)){
                    if(tagStack.isEmpty() || !tagStack.pop().equals(getTagName(tag))){
                        return false;
                    }
                } else if(!isSelfClosingTag(tag)){
                    tagStack.push(getTagName(tag));
                }
            }

        } catch(IOException ex){
            System.out.println("Error with open the file!");
        }

        return tagStack.isEmpty();
    }

    public static List<String> extractTags(String line) {
        List<String> tags = new ArrayList<>();
        int pos = 0;
        String l = line;
        while(pos < l.length()){
            if(!l.startsWith("<")){
                int end = l.indexOf('>', pos);
                if(end == -1) break;
                int start = l.indexOf('<', pos);
                if(start == -1){
                    if(l.endsWith(">")) {
                        tags.add(l);
                        break;
                    }
                }
                tags.add(l.substring(pos, end+1));
                l = l.substring(start);
            } else {
                int start = l.indexOf('<', pos);
                if(start == -1) break;
                int end = l.indexOf('>', start);
                if(end == -1) {
                    tags.add(l.substring(start));
                    break;
                } else {
                    tags.add(l.substring(start, end+1));
                    pos = end + 1;
                }
            }
        }
        return tags;
    }

    public static String getTagName(String tag) {
        if(isClosingTag(tag))
            return tag.substring(2, tag.length() - 1).toLowerCase();
        if(tag.startsWith("<"))
            return tag.substring(1, tag.length() - 1).split("\\s+")[0].toLowerCase();

        return "";
    }

    public static boolean isClosingTag(String tag) {
        return tag.startsWith("</");
    }

    public static boolean isSelfClosingTag(String tag) {
        return tag.endsWith("/>") || getTagName(tag).equals("!doctype")
                || getTagName(tag).equals("area")
                || getTagName(tag).equals("area")
                || getTagName(tag).equals("base")
                || getTagName(tag).equals("br")
                || getTagName(tag).equals("col")
                || getTagName(tag).equals("embed")
                || getTagName(tag).equals("hr")
                || getTagName(tag).equals("img")
                || getTagName(tag).equals("input")
                || getTagName(tag).equals("link")
                || getTagName(tag).equals("meta")
                || getTagName(tag).equals("param")
                || getTagName(tag).equals("source")
                || getTagName(tag).equals("track")
                || getTagName(tag).equals("wbr")
                || getTagName(tag).equals("command")
                || getTagName(tag).equals("keygen")
                || getTagName(tag).equals("menuitem")
                || getTagName(tag).equals("frame");

    }

    public static boolean isValidTag(String tag){
        return tag.startsWith("<") && tag.endsWith(">");
    }

    public static List<String> correctData(List<String> tags){
        for(int i = 0; i < tags.size()-1; i++){
            String tag = tags.get(i);
            if(!tag.endsWith(">") && !tags.get(i+1).startsWith("<")){
                tags.set(i, tag + " " + tags.get(i+1));
                tags.remove(i+1);
                i--;
            }
            if(!tag.endsWith("/>") && !tags.get(i+1).startsWith("<")){
                tags.set(i, tag + " " + tags.get(i+1));
                tags.remove(i+1);
                i--;
            }
        }
        return tags;
    }
}
