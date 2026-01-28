public class ReEx034_reverseTernary {
    public static void main(String[] args) {
        System.out.println(solution(45));
        System.out.println(solution(125));
    }

    public static int solution(int n) {
        String nStr = Integer.toString(n, 3);
        String reversed = new StringBuilder(nStr).reverse().toString();

        int result = Integer.parseInt(reversed, 3);

        return result;
    }
}