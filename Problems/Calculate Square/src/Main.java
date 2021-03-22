import java.util.Scanner;

class FixingExceptions {

    public static void calculateSquare(int[] array, int index) {
        // write your code here
        if(index < 0 || index > array.length) {
            System.out.println("Exception!");
        }else {
            System.out.println(Math.pow(array[index], index));
        }
    }
}
