// AI 엔지니어인 현식이는 데이터를 분석하는 작업을 진행하고 있습니다. 
// 데이터는 ["코드 번호(code)", "제조일(date)", "최대 수량(maximum)", "현재 수량(remain)"]으로 구성되어 있으며 
// 현식이는 이 데이터들 중 조건을 만족하는 데이터만 뽑아서 정렬하려 합니다.

// 예를 들어 다음과 같이 데이터가 주어진다면
// data = [[1, 20300104, 100, 80], [2, 20300804, 847, 37], [3, 20300401, 10, 8]]
// 이 데이터는 다음 표처럼 나타낼 수 있습니다.

// code	   date    maximum	remain
//   1   20300104	 100	  80
//   2	 20300804	 847	  37
//   3	 20300401	 10	      8
// 주어진 데이터 중 "제조일이 20300501 이전인 물건들을 현재 수량이 적은 순서"로 정렬해야 한다면 
// 조건에 맞게 가공된 데이터는 다음과 같습니다.
// data = [[3,20300401,10,8],[1,20300104,100,80]]
// 정렬한 데이터들이 담긴 이차원 정수 리스트 data와 어떤 정보를 기준으로 데이터를 뽑아낼지를 의미하는 문자열 ext, 
// 뽑아낼 정보의 기준값을 나타내는 정수 val_ext, 정보를 정렬할 기준이 되는 문자열 sort_by가 주어집니다.
// data에서 ext 값이 val_ext보다 작은 데이터만 뽑은 후, sort_by에 해당하는 값을 기준으로 오름차순으로 정렬하여 
// return 하도록 solution 함수를 완성해 주세요. 단, 조건을 만족하는 데이터는 항상 한 개 이상 존재합니다.

// 제한사항
// 1 ≤ data의 길이 ≤ 500
// data[i]의 원소는 [코드 번호(code), 제조일(date), 최대 수량(maximum), 현재 수량(remain)] 형태입니다.
// 1 ≤ 코드 번호≤ 100,000
// 20000101 ≤ 제조일≤ 29991231
// data[i][1]은 yyyymmdd 형태의 값을 가지며, 올바른 날짜만 주어집니다. (yyyy : 연도, mm : 월, dd : 일)
// 1 ≤ 최대 수량≤ 10,000
// 1 ≤ 현재 수량≤ 최대 수량
// ext와 sort_by의 값은 다음 중 한 가지를 가집니다.
// "code", "date", "maximum", "remain"
// 순서대로 코드 번호, 제조일, 최대 수량, 현재 수량을 의미합니다.
// val_ext는 ext에 따라 올바른 범위의 숫자로 주어집니다.
// 정렬 기준에 해당하는 값이 서로 같은 경우는 없습니다.

import java.util.ArrayList;  // 리스트 사용 # Import ArrayList for dynamic array
import java.util.Arrays;     // 배열 출력 # Import Arrays for printing arrays
import java.util.HashMap;    // 해시맵 사용 # Import HashMap for mapping column names to indexes
import java.util.List;       // 리스트 사용 # Import List interface
import java.util.Map;        // 맵 사용 # Import Map interface

public class Ex071_FilterAndSortData {
    public static void main(String[] args) {
        // 배열 출력 시 Arrays.deepToString 사용 # Use Arrays.deepToString to print 2D array
        System.out.println(Arrays.deepToString(
                solution(
                        new int[][] {{1, 20300104, 100, 80}, {2, 20300804, 847, 37}, {3, 20300401, 10, 8}}, 
                        "date", 20300501, "remain")));
    }

    public static int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        Map<String, Integer> mapping = new HashMap<>();  // 속성 이름과 인덱스 매핑 # Map column names to indexes

        mapping.put("code", 0);      // code는 0번 인덱스 # code at index 0
        mapping.put("date", 1);      // date는 1번 인덱스 # date at index 1
        mapping.put("maximum", 2);   // maximum은 2번 인덱스 # maximum at index 2
        mapping.put("remain", 3);    // remain은 3번 인덱스 # remain at index 3

        int extIndex = mapping.get(ext);       // 필터 기준 열 인덱스 # Index of the column to filter
        int sortIndex = mapping.get(sort_by);  // 정렬 기준 열 인덱스 # Index of the column to sort

        List<int[]> filtered = new ArrayList<>();  // 조건 만족 데이터 저장 # List to store filtered rows
        for (int[] row: data) {
            if (row[extIndex] < val_ext) {  // ext 값이 val_ext보다 작은 경우만 # Keep rows where ext value < val_ext
                filtered.add(row);          // 조건 만족 시 추가 # Add to filtered list
            }
        }

        filtered.sort((a, b) -> Integer.compare(a[sortIndex], b[sortIndex]));  // sort_by 기준 오름차순 정렬 # Sort filtered rows by sort_by column

        int[][] result = new int[filtered.size()][4];  // 결과 배열 생성 # Create result 2D array
        for (int i = 0; i < filtered.size(); i++) {
            result[i] = filtered.get(i);  // 리스트 내용을 배열로 복사 # Copy list rows into array
        }

        return result;  // 최종 결과 반환 # Return the sorted and filtered array
    }
}