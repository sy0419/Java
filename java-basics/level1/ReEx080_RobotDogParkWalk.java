import java.util.Arrays;

public class ReEx080_RobotDogParkWalk {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new String[] {"SOO","OOO","OOO"}, new String[] {"E 2","S 2","W 1"})));
        System.out.println(Arrays.toString(solution(new String[] {"SOO","OXX","OOO"}, new String[] {"E 2","S 2","W 1"})));
        System.out.println(Arrays.toString(solution(new String[] {"OSO","OOO","OXO","OOO"}, new String[] {"E 2","S 3","W 1"}))); 
    }

    public static int[] solution(String[] park, String[] routes) {
        int row = 0;
        int col = 0;
        boolean sFind = false;

        for (int i = 0; i < park.length; i++) {
            for (int j = 0; j < park[i].length(); j++) {
                if (park[i].charAt(j) == 'S') {
                    row = i;
                    col = j;
                    sFind = true;
                    break;
                }
            }
            if (sFind) {
                break;
            }
        }

        for (String route: routes) {
            String[] parts = route.split(" ");

            String direction = parts[0];
            int distance = Integer.parseInt(parts[1]);

            int dr = 0;
            int dc = 0;
            
            switch (direction) {
                case "N" -> dr = -1;
                case "S" -> dr = +1;
                case "W" -> dc = -1;
                default -> dc = +1;
            }

            int nr = row;
            int nc = col;
            boolean canMove = true;
            for (int i = 0; i < distance; i++) {
                nr += dr;
                nc += dc;
                if (nr < 0 || nr >= park.length || nc < 0 || nc >= park[0].length()) {
                    canMove = false;
                    break;
                }

                if (park[nr].charAt(nc) == 'X') {
                    canMove = false;
                    break;
                }
            }

            if (canMove) {
                row = nr;
                col = nc;
            }
        }
        return new int[] {row, col};
    }
}