import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> numbers = new ArrayList<>();
        String[] tokens = sc.nextLine().split("\\s+");
        for (String token : tokens) {
            numbers.add(Integer.parseInt(token));
        }
        int sum = 0;
        for (Integer number : numbers) {
            sum += number;
        }
        System.out.println(sum);
        sc.close();
    }
}