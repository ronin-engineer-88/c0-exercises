package _12_Data_structure;

public class exercise_2 {
    public static void main(String[] args) {
        int[] arr1 = new int[] {1,2,3};
        int[] arr2 = new int[] {4,2,3,1};
        int[] arr3 = new int[] {9};

        System.out.print("Test case 1 with [1,2,3]: "); printArr(plusOne(arr1));
        System.out.print("Test case 2 with [4,2,3,1]: "); printArr(plusOne(arr2));
        System.out.print("Test case 3 with [9]: "); printArr(plusOne(arr3));
    }

    public static int[] plusOne(int[] digits) {
        digits[digits.length - 1] += 1;
        for(int i = digits.length - 1; i > 0; i--){
            if(digits[i] != 10)
                return digits;

            digits[i] = 0;
            digits[i-1] += 1;
        }
        if(digits[0] == 10){
            digits = new int[digits.length+1];
            digits[0] = 1;
        }

        return digits;
    }

    public static void printArr(int[] arr){
        for(int i : arr){
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
