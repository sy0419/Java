public class ReEx065_splitStringCount {
    public static void main(String[] args) {
        System.out.println(solution("banana"));
        System.out.println(solution("abracadabra"));
        System.out.println(solution("aaabbaccccabba"));
    }

    public static int solution(String s) {
        int firstLetterCount = 0;
        int othersCount = 0;
        int result = 0;
        char x = s.charAt(0);

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            
            if (x == ch) {
                firstLetterCount++;
            } else {
                othersCount++;
            }

            if (firstLetterCount == othersCount) {
                result++;
                if (i + 1 < s.length()) {
                    x = s.charAt(i + 1);
                }
                firstLetterCount = 0;
                othersCount = 0;
            }
        }
        if (firstLetterCount != 0 || othersCount != 0) {
            result++;
        }

        return result;
    }
}