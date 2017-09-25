class Solution {
    public String nextClosestTime(String time) {
        String t = time.replace(":", "");
        char[] digits = t.toCharArray();
        Set<Character> set = new HashSet<>();
        List<String> res = new ArrayList<>();
        for (char c : digits) {
            set.add(c);
        }
        backtrack(res, set, "");

        int min = 25 * 60;
        String out = null;
        for (String str : res) {
            int diff = compareTime(str, t);
            if (diff < min) {
                min = diff;
                out = str;
            }
        }

        return out.substring(0,2) + ":" + out.substring(2,4);
    }
    
    private void backtrack(List<String> res, Set<Character> set, String cur) {
        if (cur.length() == 4) {
            res.add(cur);
            return;
        }

        if (!isValidTime(cur)) return ;

        for (Character ch : set) {
            backtrack(res, set, cur + ch);
        }
    }

    private boolean isValidTime(String time) {
        int n = time.length();

        if (n == 0) return true;
        if (n == 1 && time.compareTo("2") > 0) return false;
        if (n == 2 && time.compareTo("23") > 0) return false;
        if (n == 3 && time.charAt(2) > '5') return false;

        return true;
    }

    public int compareTime(String t1, String t2) {
        int hr1 = Integer.parseInt(t1.substring(0,2));
        int hr2 = Integer.parseInt(t2.substring(0,2));
        int mn1 = Integer.parseInt(t1.substring(2,4));
        int mn2 = Integer.parseInt(t2.substring(2,4));

        if (hr1 < hr2 || (hr1 == hr2 && mn1 <= mn2)) {
            hr1 += 24;
        }

        return hr1 * 60 + mn1 - hr2 * 60 - mn2;
    }
}

