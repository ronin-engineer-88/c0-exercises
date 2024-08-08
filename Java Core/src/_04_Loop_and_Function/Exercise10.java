package _04_Loop_and_Function;

public class Exercise10 {
    public static void main(String[] args) {
        String str = "ab@#AB69C!}+21";

        StringBuilder digits = new StringBuilder();
        StringBuilder letters = new StringBuilder();
        StringBuilder specialChars = new StringBuilder();

        for (char ch : str.toCharArray()) {
            if (Character.isDigit(ch)) {
                digits.append(ch);
            } else if (Character.isLetter(ch)) {
                letters.append(ch);
            } else {
                specialChars.append(ch);
            }
        }

        System.out.println("Chuỗi số: " + digits);
        System.out.println("Chuỗi chữ: " + letters);
        System.out.println("Chuỗi đặc biệt: " + specialChars);
    }
}
/*
     Cho trước str là chuỗi bất kỳ gồm có kí tự chữ, kí tự số và kí tự đặc biệt.
     Bạn hãy viết chương trình để in ra chuỗi chỉ chứa số, chuỗi chỉ chứa chữ và chuỗi chỉ chứa kí tự đặc biệt từ str
        Input: str = "ab@#AB69C!}+21"
        Output:
        Chuỗi số: 6921
        Chuỗi chữ: abABC
        Chuỗi đặc biệt: @#!}+
*/
