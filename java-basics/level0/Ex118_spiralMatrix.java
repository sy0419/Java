import java.util.Arrays;

// 양의 정수 n이 매개변수로 주어집니다. n × n 배열에 1부터 n² 까지 정수를 인덱스 [0][0]부터 시계방향 나선형으로 
// 배치한 이차원 배열을 return 하는 solution 함수를 작성해 주세요.

// 제한사항
// 1 ≤ n ≤ 30

public class Ex118_spiralMatrix {
    public static void main(String[] args) {
        // 2차원 배열은 Arrays.deepToString으로 출력해야 함 # Use Arrays.deepToString to print 2D arrays
        System.out.println(Arrays.deepToString(solution(4))); // 4x4 나선형 배열
        System.out.println(Arrays.deepToString(solution(5))); // 5x5 나선형 배열
    }

    // 나선형 배열 생성 함수 # Function to generate spiral matrix
    public static int[][] solution(int n) {
        int[][] arr = new int[n][n]; // n x n 크기의 배열 생성 # Create n x n array

        // 방향 배열: 오른쪽, 아래, 왼쪽, 위 순서로 움직이기 위한 dx, dy # Direction vectors: right, down, left, up
        int[] dx = {0, 1, 0, -1}; // 행의 변화량 # Row change
        int[] dy = {1, 0, -1, 0}; // 열의 변화량 # Column change

        int x = 0, y = 0; // 시작 위치는 왼쪽 위 # Start position is top-left
        int dir = 0; // 처음 방향은 오른쪽 # Initial direction is right

        // 1부터 n^2까지 순서대로 채우기 # Fill numbers from 1 to n^2
        for (int i = 1; i <= n * n; i++) {
            arr[x][y] = i; // 현재 위치에 숫자 채우기 # Place number at current position

            int nx = x + dx[dir]; // 다음 이동할 행 위치 # Next row
            int ny = y + dy[dir]; // 다음 이동할 열 위치 # Next column

            // 배열 범위를 벗어나거나, 이미 숫자가 채워진 경우 방향 전환 # If out of bounds or cell already filled, change direction
            if (nx < 0 || ny < 0 || nx >= n || ny >= n || arr[nx][ny] != 0) {
                dir = (dir + 1) % 4; // 시계방향으로 방향 전환 # Rotate direction clockwise
                nx = x + dx[dir]; // 새로운 방향으로 이동 # Move in new direction
                ny = y + dy[dir];
            }

            x = nx; // 위치 갱신 # Update position
            y = ny;
        }

        return arr; // 완성된 나선형 배열 반환 # Return completed spiral matrix
    }
}