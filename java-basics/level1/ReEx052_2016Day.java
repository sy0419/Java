public class ReEx052_2016Day {
    public static void main(String[] args) {
        System.out.println(solution(5, 24));
    }

    public static String solution(int a, int b) {
        int[] daysInMonth = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int totalDays = 0;

        for (int i = 0; i < a-1; i++) {
            totalDays = daysInMonth[i];
        }
        totalDays += b;

        int dayIndex = (totalDays - 1) % 7;
        switch (dayIndex) {
            case 0 -> { return "FRI"; }
            case 1 -> { return "SAT"; }
            case 2 -> { return "SUN"; }
            case 3 -> { return "MON"; }
            case 4 -> { return "TUE"; }
            case 5 -> { return "WED"; }
            case 6 -> { return "THU"; }
            default -> { return "ERROR";}
        }
    }
}