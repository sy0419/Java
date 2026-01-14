public class ReEx007_stringToNumber {
    public static void main(String[] args) {
        System.out.println(solution("1234"));
        System.out.println(solution("-1234"));
    }

    public static int solution(String s) {
        int result = Integer.parseInt(s);
        return result;
    }
}