public class ReEx017_FindKim {
    public static void main(String[] args) {
        System.out.println(solution(new String[] {"Jane", "Kim"}));
    }
    
    public static String solution(String[] seoul) {
        int index = 0;
        for (int i = 0; i < seoul.length; i++) {
            if (seoul[i].equals("Kim")) {
                index = i;
            }
        }
        return String.format("Kim is in %d.", index);
    }
}