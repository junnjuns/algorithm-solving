class Solution {
    public String solution(String s) {
        StringBuilder sb = new StringBuilder();
        boolean isStartOfWord = true;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (ch == ' ') {
                sb.append(ch);
                isStartOfWord = true;
                continue;
            }

            if (isStartOfWord) {
                sb.append(Character.toUpperCase(ch));
                isStartOfWord = false;
            } else {
                sb.append(Character.toLowerCase(ch));
            }
        }

        return sb.toString();
    }
}