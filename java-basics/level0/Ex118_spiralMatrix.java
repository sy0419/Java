
import java.util.Arrays;

// 양의 정수 n이 매개변수로 주어집니다. n × n 배열에 1부터 n2 까지 정수를 인덱스 [0][0]부터 시계방향 나선형으로 
// 배치한 이차원 배열을 return 하는 solution 함수를 작성해 주세요.

// 제한사항
// 1 ≤ n ≤ 30

public class Ex118_spiralMatrix {
    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(solution(4)));
        System.out.println(Arrays.deepToString(solution(5)));
    }

    public static int[][] solution(int n) {
        int[][] arr = new int[n][n];
        int[] dx = {0, 1, 0, -1}; 
        int[] dy = {1, 0, -1, 0};
        int x = 0, y = 0;
        int dir = 0;
        for (int i = 1; i <= n*n; i++) {
            arr[x][y] = i;

            int nx = x + dx[dir];
            int ny = y + dy[dir];
            if (nx < 0 || ny < 0 || nx >= n || ny >= n || arr[nx][ny] != 0) {
                dir = (dir + 1) % 4;
                nx = x + dx[dir];
                ny = y + dy[dir];
            }
            x = nx;
            y = ny;
        }
        return arr;
    }
}