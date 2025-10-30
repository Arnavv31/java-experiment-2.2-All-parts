import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> numbers = new ArrayList<>();
        System.out.println("Enter integers (separated by space):");
        String[] input = sc.nextLine().split(" ");

        for (String s : input) {
            Integer num = Integer.parseInt(s);
            numbers.add(num);
        }

        int sum = 0;
        for (Integer num : numbers) {
            sum += num;
        }

        System.out.println("Sum of entered integers: " + sum);
        sc.close();
    }
}
