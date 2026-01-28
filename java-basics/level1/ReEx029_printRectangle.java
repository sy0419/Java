import java.util.Scanner;

public class ReEx029_printRectangle {
    public static void main(String[] args) {
        solution();
    }

    public static void solution() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        for (int i = 0; i < m; i++) {
            System.out.println("*".repeat(n));
        }
    }
}