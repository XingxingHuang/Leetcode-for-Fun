//1002
class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        Set seen = new HashSet(), repeated = new HashSet();
        for (int i = 0; i + 9 < s.length(); i++) {
            String ten = s.substring(i, i + 10);
            if (!seen.add(ten))
                repeated.add(ten);
        }
        return new ArrayList(repeated);
    }
}

public List<String> findRepeatedDnaSequences(String s) {
    Set<Integer> words = new HashSet<>();
    Set<Integer> doubleWords = new HashSet<>();
    List<String> rv = new ArrayList<>();
    char[] map = new char[26];
    //map['A' - 'A'] = 0;
    map['C' - 'A'] = 1;
    map['G' - 'A'] = 2;
    map['T' - 'A'] = 3;

    for(int i = 0; i < s.length() - 9; i++) {
        int v = 0;
        for(int j = i; j < i + 10; j++) {
            v <<= 2;
            v |= map[s.charAt(j) - 'A'];
        }
        if(!words.add(v) && doubleWords.add(v)) {
            rv.add(s.substring(i, i + 10));
        }
    }
    return rv;
}


// @2017.08.24 XingxingHuang
// Convert the String into Numbers, you can also convert String into binary codes.
// 超时
class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        if (s.length() < 10) 
            return new ArrayList<String>();
        HashMap<Character, Integer> map = new HashMap<>();
        map.put('A', 1);
        map.put('C', 2);
        map.put('G', 3);
        map.put('T', 4);        
        Set<Long> set = new HashSet<>();
        Set<String> set_res = new HashSet<>();
        String ns = "";
        for (int i = 0; i < s.length(); i++) 
            ns += map.get(s.charAt(i));
        long n = Long.parseLong(ns.substring(0, 9));
        for (int i = 0; i <= s.length() - 10; i++) {
            n = (n % 1000000000) * 10 + (ns.charAt(i + 9) - '0');
            if (set.contains(n)) {
                set_res.add(s.substring(i, i + 10));
            } else {
                set.add(n);
            }
        }
        return new ArrayList<String>(set_res);
    }
}


// time exceed
// class Solution {
//     public List<String> findRepeatedDnaSequences(String s) {
//         HashMap<Character, Integer> map = new HashMap<>();
//         map.put('A', 1);
//         map.put('C', 2);
//         map.put('G', 3);
//         map.put('T', 4);        
//         Set<String> set = new HashSet<>();
//         String ns = "";
//         for (int i = 0; i < s.length(); i++) 
//             ns += map.get(s.charAt(i));
//         for (int i = 0; i < s.length() - 10; i++) {
//             long n = Long.parseLong(ns.substring(i, i + 10));
//             // long m = Long.parseLong(ns.substring(i + 9, i + 19));
//             long m = n;
//             for (int j = i + 1; j <= s.length() - 10; j++) {
//                 m = (m % 1000000000) * 10 + (ns.charAt(j + 9) - '0');
//                 if (m == n) {
//                     set.add(s.substring(j, j + 10));
//                     // System.out.println(i + " " + j + " " +s.substring(j, j + 10)+" "+ m + " " + n);
//                 }
//             }
//         }
//         return new ArrayList<String>(set);
//     }
// }