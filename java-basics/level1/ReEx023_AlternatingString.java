public class ReEx023_AlternatingString {
    public static void main(String[] args) {
        System.out.println(solution(3));
        System.out.println(solution(4));
    }

    public static String solution(int n) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                sb.append("a");
            } else {
                sb.append("b");
            }
        }

        return sb.toString();
    }
}