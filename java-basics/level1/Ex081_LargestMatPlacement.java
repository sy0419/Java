// 지민이는 다양한 크기의 정사각형 모양 돗자리를 가지고 공원에 소풍을 나왔습니다. 
// 공원에는 이미 돗자리를 깔고 여가를 즐기는 사람들이 많아 지민이가 깔 수 있는 가장 큰 돗자리가 어떤 건지 확인하려 합니다.
// 예를 들어 지민이가 가지고 있는 돗자리의 한 변 길이가 5, 3, 2 세 종류이고, 
// 사람들이 다음과 같이 앉아 있다면 지민이가 깔 수 있는 가장 큰 돗자리는 3x3 크기입니다.

// 지민이가 가진 돗자리들의 한 변 길이들이 담긴 정수 리스트 mats, 
// 현재 공원의 자리 배치도를 의미하는 2차원 문자열 리스트 park가 주어질 때 
// 지민이가 모든 명령을 수행 후 놓인 위치를 [세로 방향 좌표, 가로 방향 좌표] 순으로 배열에 담아 return 하도록 solution 함수를 완성해 주세요.
// 아무런 돗자리도 깔 수 없는 경우 -1을 return합니다.

// 제한사항
// 1 ≤ mats의 길이 ≤ 10
// 1 ≤ mats의 원소 ≤ 20
// mats는 중복된 원소를 가지지 않습니다.
// 1 ≤ park의 길이 ≤ 50
// 1 ≤ park[i]의 길이 ≤ 50
// park[i][j]의 원소는 문자열입니다.
// park[i][j]에 돗자리를 깐 사람이 없다면 "-1", 사람이 있다면 알파벳 한 글자로 된 값을 갖습니다.
import java.util.Arrays;

public class Ex081_LargestMatPlacement {
    public static void main(String[] args) {
        System.out.println(solution(new int[] {5, 3, 2}, 
                            new String[][] {{"A", "A", "-1", "B", "B", "B", "B", "-1"}, 
                                            {"A", "A", "-1", "B", "B", "B", "B", "-1"}, 
                                            {"-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1"}, 
                                            {"D", "D", "-1", "-1", "-1", "-1", "E", "-1"}, 
                                            {"D", "D", "-1", "-1", "-1", "-1", "-1", "F"}, 
                                            {"D", "D", "-1", "-1", "-1", "-1", "-1", "F"}}));
    }

    public static int solution(int[] mats, String[][] park) {
        Arrays.sort(mats); // 돗자리 크기를 오름차순으로 정렬 # Sort mat sizes in ascending order

        // 가장 큰 돗자리부터 확인하기 위해 뒤에서부터 반복 # Loop from largest mat to smallest
        for (int idx = mats.length - 1; idx >= 0; idx--) {
            int mat = mats[idx]; // 현재 확인할 돗자리 크기 # Current mat size
            int rows = park.length; // 공원 세로 길이 # Number of rows in park
            int cols = park[0].length; // 공원 가로 길이 # Number of columns in park

            // 돗자리를 놓을 수 있는 시작 위치 탐색 # Check all possible starting positions
            for (int i = 0; i <= rows - mat; i++) { // 세로 시작 위치 # Start row
                for (int j = 0; j <= cols - mat; j++) { // 가로 시작 위치 # Start column
                    boolean canPlace = true; // 일단 놓을 수 있다고 가정 # Assume mat can be placed

                    // 현재 위치에서 돗자리 전체 확인 # Check the whole area of the mat
                    for (int x = i; x < i + mat; x++) { // 세로 탐색 # Check rows
                        for (int y = j; y < j + mat; y++) { // 가로 탐색 # Check columns
                            if (!park[x][y].equals("-1")) { // 사람이 있으면 # If a person is present
                                canPlace = false; // 놓을 수 없음 # Cannot place mat
                                break; // 현재 줄 반복 중단 # Stop checking current row
                            }
                        }
                        if (!canPlace) break; // 이미 못 놓으면 다른 줄도 중단 # Stop checking mat area
                    }

                    if (canPlace) return mat; // 놓을 수 있으면 해당 크기 반환 # Return mat size if possible
                }
            }
        }

        return -1; // 어떤 돗자리도 놓을 수 없으면 -1 반환 # Return -1 if no mat can be placed
    }
}