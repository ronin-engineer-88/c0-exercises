package _05_Arrays_TextIO.homework;

public class exercise_6 {
    public static void main(String[] args) {
        // Khởi tạo mảng và kiểm tra đx ko?
        int[] arr1 = {1, 3, 6, 3, 1};
        int[] arr2 = {1, 2, 3, 4, 5};

        // test
        System.out.println(isCheckArray(arr1) ? "YES" : "NO"); // Kết quả: YES
        System.out.println(isCheckArray(arr2) ? "YES" : "NO"); // Kết quả: NO

    }

    public static boolean isCheckArray(int[] arr) {
        int left = 0;
        int right = arr.length - 1;

        while (left < right) {
            if (arr[left] != arr[right]) {
                return false;
            }

            left++;
            right--;
        }

        return true;
    }
}

// Requirment:  Viết một chương trình kiểm tra một mảng một chiều có phải là một mảng đối xứng không, nếu có in ra “YES"
//             , nếu không in ra “NO". Biết một mảng đối xứng là một mảng đọc từ trái qua phải, đọc từ phải qua trái đều
//              giống nhau. Ví dụ một mảng đối xứng [1, 2, 3, 2, 1].