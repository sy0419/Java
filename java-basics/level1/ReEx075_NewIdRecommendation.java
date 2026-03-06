public class ReEx075_NewIdRecommendation {
    public static void main(String[] args) {
        System.out.println(solution("...!@BaT#*..y.abcdefghijklm"));
        System.out.println(solution("z-+.^."));
        System.out.println(solution("=.="));
        System.out.println(solution("123_.def"));
        System.out.println(solution("abcdefghijklmn.p"));
    }

    public static String solution(String newId) {
        String editedId = newId.toLowerCase().replaceAll("[^a-z0-9-_.]", "")
                                             .replaceAll("\\.{2,}", ".")
                                             .replaceAll("^\\.|\\.$", "");  

        if (editedId.isEmpty()) {
            editedId = "a";
        } if (editedId.length() > 16) {
            editedId = editedId.substring(0, 15);
            editedId = editedId.replaceAll("\\.$", "");
        }

        while (editedId.length() < 3) {
            editedId += editedId.charAt(editedId.length() - 1);
        }
        
        return editedId;
    }
}