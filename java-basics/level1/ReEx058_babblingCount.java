

public class ReEx058_babblingCount {
    public static void main(String[] args) {
        System.out.println(solution(new String[] {"aya", "yee", "u", "maa"}));
        System.out.println(solution(new String[] {"ayaye", "uuu", "yeye", "yemawoo", "ayaayaa"}));
    }

    public static int solution(String[] babbiling) {
        int result = 0;
        String[] sounds = {"aya", "ye", "woo", "ma"};

        for (String word : babbiling) {
            String last = "";
            while (!word.isEmpty()) {
                boolean found = false;

                for (String sound: sounds) {
                    if (word.startsWith(sound) && !sound.equals(last)) {
                        word = word.substring(sound.length());
                        last = sound;
                        found = true;
                        break;
                    }
                }
                if (!found) {
                    break;
                }
            } if (word.isEmpty()) {
                result++;
            }
        }

        return result;
    }
}