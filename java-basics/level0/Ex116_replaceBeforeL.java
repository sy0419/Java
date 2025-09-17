// 알파벳 소문자로 이루어진 문자열 myString이 주어집니다. 알파벳 순서에서 "l"보다 앞서는 모든 문자를 "l"로 바꾼 문자열을 return 하는 solution 함수를 완성해 주세요.

// 제한사항
// 1 ≤ myString ≤ 100,000
// myString은 알파벳 소문자로 이루어진 문자열입니다.

public class Ex116_replaceBeforeL {
    public static void main(String[] args) {
        System.out.println(solution1("abcdevwxyz"));
        System.out.println(solution1("jjnnllkkmm"));
        System.out.println(solution2("abcdevwxyz"));
        System.out.println(solution2("jjnnllkkmm"));
    }

    public static String solution1(String myString) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < myString.length(); i++) {
            char ch = myString.charAt(i);
            if (ch < 'l') {
                sb.append('l');
            } else {
                sb.append(ch);
            }
        }
        return sb.toString();
    }

    public static String solution2(String myString) {
        return myString.replaceAll("[^l-z]", "l");
    }
}