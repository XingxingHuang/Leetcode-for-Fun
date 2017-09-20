// 09.20 easy string program
class Solution {
    public String countAndSay(int n) {
        StringBuilder sb = new StringBuilder("1");
        StringBuilder prev;
        int count;
        char say;
        for (int i = 1; i < n; i++) {
            prev = sb;
            sb = new StringBuilder();
            count = 1;
            say = prev.charAt(0);
            for (int j = 1; j < prev.length(); j++) {
                if (prev.charAt(j) != say) {
                    sb.append(count).append(say);
                    count = 1;
                    say = prev.charAt(j);
                } else {
                    count++;
                }
            }
            sb.append(count).append(say);
        }
        return sb.toString();
    }
}