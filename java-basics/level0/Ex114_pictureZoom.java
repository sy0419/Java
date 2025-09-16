// 직사각형 형태의 그림 파일이 있고, 이 그림 파일은 1 × 1 크기의 정사각형 크기의 픽셀로 이루어져 있습니다. 
// 이 그림 파일을 나타낸 문자열 배열 picture과 정수 k가 매개변수로 주어질 때, 
// 이 그림 파일을 가로 세로로 k배 늘린 그림 파일을 나타내도록 문자열 배열을 return 하는 solution 함수를 작성해 주세요.

// 제한사항
// 1 ≤ picture의 길이 ≤ 20
// 1 ≤ picture의 원소의 길이 ≤ 20
// 모든 picture의 원소의 길이는 같습니다.
// picture의 원소는 '.'과 'x'로 이루어져 있습니다.
// 1 ≤ k ≤ 10

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Ex114_pictureZoom {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new String[] {".xx...xx.", "x..x.x..x", "x...x...x", ".x.....x.", "..x...x..", "...x.x...", "....x...."}, 2)));
        System.out.println(Arrays.toString(solution(new String[] {"x.x", ".x.", "x.x"}, 3)));
    }

    public static String[] solution(String[] picture, int k) {
        List<String> result = new ArrayList<>();
        
        for (String line : picture) {
            String expandedLine = "";
            // 각 줄의 문자들을 반복하여 가로로 늘리기
            // # Repeat each character k times horizontally
            for (int j = 0; j < line.length(); j++) {
                char ch = line.charAt(j);
                for (int repeat = 0; repeat < k; repeat++) {
                    expandedLine += ch;
                }
            }

            // 가로로 늘어난 줄을 k번 반복하여 세로로 늘리기
            // # Repeat the expanded line k times vertically
            for (int repeat = 0; repeat < k; repeat++) {
                result.add(expandedLine);
            }
        }
        // 리스트를 배열로 변환하여 반환
        // # Convert the list to an array before returning
        return result.toArray(new String[0]);
    }
}