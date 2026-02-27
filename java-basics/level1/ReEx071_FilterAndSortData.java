import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ReEx071_FilterAndSortData {
    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(
                solution(
                        new int[][] {{1, 20300104, 100, 80}, {2, 20300804, 847, 37}, {3, 20300401, 10, 8}}, 
                        "date", 20300501, "remain")));
    }

    public static int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        Map<String, Integer> mapping = new HashMap<>();

        mapping.put("code", 0);
        mapping.put("date", 1);
        mapping.put("maximum", 2);
        mapping.put("remain", 3);

        int exdIndex = mapping.get(ext);
        int sortIndex = mapping.get(sort_by);

        List<int[]> filtered = new ArrayList<>();
        
        for (int i = 0; i < data.length; i++) {
            if (data[i][exdIndex] < val_ext) {
                filtered.add(data[i]);
            }
        }

        filtered.sort((a, b) -> a[sortIndex] - b[sortIndex]);

        int[][] result = new int[filtered.size()][4];
        for (int i = 0; i < filtered.size(); i++) {
            result[i] = filtered.get(i);
        }

        return result;
    }
}