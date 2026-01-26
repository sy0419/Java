public class ReEx019_HidePhoneNumber {
    public static void main(String[] args) {
        System.out.println(solution("01033334444"));
        System.out.println(solution("027778888"));
    }

    public static String solution(String phone_number) {
        int numberLength = phone_number.length();
        int replacedNum = numberLength - 4;
        String result = "";

        for (int i = 0; i < numberLength; i++) {
            if (i < replacedNum) {
                result += "*";
            } else {
                result += phone_number.charAt(i);
            }
        }
        return result;
    }
}