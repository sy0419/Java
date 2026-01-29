

public class ReEx041_FoodFightArrangement {
    public static void main(String[] args) {
        System.out.println(solution1(new int[] {1, 3, 4, 6}));
        System.out.println(solution1(new int[] {1, 7, 1, 2}));
        System.out.println(solution2(new int[] {1, 3, 4, 6}));
        System.out.println(solution2(new int[] {1, 7, 1, 2}));
    }

    public static String solution1(int[] food) {
        String half = "";

        for (int i = 1; i < food.length; i++) {
            if (food[i] % 2 == 0) {
                int n = food[i] / 2;
                half += String.valueOf(i).repeat(n);
            } else {
                int n = (food[i] - 1) / 2;
                half += String.valueOf(i).repeat(n);
            }
        }
        String result = half + '0' + new StringBuilder(half).reverse().toString();

        return result;
    }

    public static String solution2(int[] food) {
        String half = "";

        for (int i = 1; i < food.length; i++) {
            int repeat = food[i] / 2;
            half += String.valueOf(i).repeat(repeat);
        }

        String result = half + '0' + new StringBuilder(half).reverse().toString();

        return result;
    }
}