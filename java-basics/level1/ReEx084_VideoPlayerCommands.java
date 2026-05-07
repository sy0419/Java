public class ReEx084_VideoPlayerCommands {
    public static void main(String[] args) {
        System.out.println(solution("34:33", "13:00", "00:55", "02:55", new String[] {"next", "prev"}));
        System.out.println(solution("10:55", "00:05", "00:15", "06:55", new String[] {"prev", "next", "next"}));
        System.out.println(solution("07:22", "04:05", "00:15", "04:07", new String[] {"next"}));
    }

    public static String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        int videoLength = toSeconds(video_len);
        int currentPos = toSeconds(pos);
        int opStart = toSeconds(op_start);
        int opEnd = toSeconds(op_end);

        if (opStart <= currentPos && currentPos <= opEnd) {
            currentPos = opEnd;
        }

        for (String command: commands) {
            if (command.equals("prev")) {
                currentPos = Math.max(0, currentPos - 10);
            } else {
                currentPos = Math.min(videoLength, currentPos + 10);
            }

            if (opStart <= currentPos && currentPos <= opEnd) {
                currentPos = opEnd;
            }
        }
        int resultMinute = currentPos / 60;
        int resultSecond = currentPos % 60;
        return  String.format("%02d:%02d", resultMinute, resultSecond);
    }

    public static int toSeconds(String time) {
        String[] parts = time.split(":");

        int minute = Integer.parseInt(parts[0]);
        int second = Integer.parseInt(parts[1]);
        int totalSeconds = minute * 60 + second;

        return totalSeconds;
    }
}
