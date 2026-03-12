import java.util.Arrays;

public class ReEx076_WallpaperDrag {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new String[] {".#...", "..#..", "...#."})));
        System.out.println(Arrays.toString(solution(new String[] {"..........", ".....#....", "......##..", "...##.....", "....#....."})));
        System.out.println(Arrays.toString(solution(new String[] {".##...##.", "#..#.#..#", "#...#...#", ".#.....#.", "..#...#..", "...#.#...", "....#...."})));
        System.out.println(Arrays.toString(solution(new String[] {"..", "#."})));
    }

    public static int[] solution(String[] wallpaper) {
        int[] result = new int[4];
        
        int lux = 50;
        int luy = 50;
        int rdx = 0;
        int rdy = 0;

        for (int i = 0; i < wallpaper.length; i++) {
            for (int j = 0; j < wallpaper[i].length(); j++) {
                if (wallpaper[i].charAt(j) == '#') {
                    lux = Math.min(lux, i);
                    luy = Math.min(luy, j);
                    rdx = Math.max(rdx, i+1);
                    rdy = Math.max(rdy, j+1);
                }
            }
        }
        result[0] = lux;
        result[1] = luy;
        result[2] = rdx;
        result[3] = rdy;
        
        return result;
    }
}