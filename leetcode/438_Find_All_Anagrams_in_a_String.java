// 2017.09.10 
class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        if (s == null || s.length() < p.length()) 
            return res;
        int[] map = new int[26];
        for (int i = 0; i < p.length(); i++) {
            map[p.charAt(i) - 'a']++;
        }
        //
        int i = 0;
        int j = 0;
        int count = p.length();
        while (j < s.length()) {
            //start
            if (j - i == p.length()) {
                if (map[s.charAt(i) - 'a'] >= 0) 
                    count++;
                map[s.charAt(i)-'a']++;
                i++;
            }
            //end
            if (map[s.charAt(j) - 'a'] >= 1) 
                count--;
            map[s.charAt(j) - 'a']--;
            j++;
            // check
            if (count == 0) 
                res.add(i);
        }
        return res;
    }
}



// the same code as above
// if too many duplicates in the slice, count != 0
class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        int[] chars = new int[26];
        List<Integer> result = new ArrayList<>();

        if (s == null || p == null || s.length() < p.length())
            return result;

        // main body
        for (char c : p.toCharArray())
            chars[c-'a']++;
        int start = 0, end = 0, count = p.length();
        while (end < s.length()) {
            // slice large enough, move start
            if (end - start == p.length()) {
                if (chars[s.charAt(start)-'a'] >= 0) 
                    count++;
                chars[s.charAt(start)-'a']++;
                start++;
            }
            // move end
            if (chars[s.charAt(end)-'a'] >= 1)
                count--;
            chars[s.charAt(end)-'a']--;
            end++;
            
            // check Anagram
            if (count == 0)
                result.add(start);
        }

        return result;
    }
}

// shorter but hard to understand
public List<Integer> findAnagrams(String s, String p) {
    List<Integer> list = new ArrayList<>();
    if (s == null || s.length() == 0 || p == null || p.length() == 0) return list;
    int[] hash = new int[256]; //character hash
    //record each character in p to hash
    for (char c : p.toCharArray()) {
        hash[c]++;
    }
    //two points, initialize count to p's length
    int left = 0, right = 0, count = p.length();
    while (right < s.length()) {
        //move right everytime, if the character exists in p's hash, decrease the count
        //current hash value >= 1 means the character is existing in p
        if (hash[s.charAt(right++)]-- >= 1) count--; 
        
        //when the count is down to 0, means we found the right anagram
        //then add window's left to result list
        if (count == 0) list.add(left);
    
        //if we find the window's size equals to p, then we have to move left (narrow the window) to find the new match window
        //++ to reset the hash because we kicked out the left
        //only increase the count if the character is in p
        //the count >= 0 indicate it was original in the hash, cuz it won't go below 0
        if (right - left == p.length() && hash[s.charAt(left++)]++ >= 0) count++;
    }
    return list;
}



// 2017.09.10 尝试过使用hashmap来存储p的内容，然后slice window方法进行，但是过程中发现不知如何判断扫描s的时候slice的内容是否与map相同，map减去之后不方便恢复。增加了count参数也不能简化代码。

// class Solution {
//     public List<Integer> findAnagrams(String s, String p) {
//         List<Integer> res = new ArrayList<>();
//         if (s == null || s.length() < p.length())
//             return res;
//         // init the hashmap
//         HashMap<Character, Integer> map = new HashMap<>();
//         for (int i = 0; i < p.length(); i++) {
//             map.set(p.charAt(i), map.getOrDefault(p.charAt(i), 0) + 1);
//         }
//         int i = 0;
//         int j = 0;
//         int count = p.length();
//         while (j < s.length()) {
//             if (!map.containsKey(s.charAt(j))) {
//                 j++;
//                 continue;
//             } 
//             if (map.get(s.charAt(j) == 0))
//         }
        
//         // // init the slide window
//         // int count = p.lenght(); 
//         // int start = 0; int end = 0;
//         // while (end < p.length()) {
//         //     if (!map.containkeys(s.charAt(i))) {
//         //         count++;
//         //     } else {
//         //         count--;
//         //         map.set(s.charAt(i), map.get(s.charAt(i)) - 1);
//         //     }
//         // }
//         // if (count == 0) 
//         //     res.add(0);
//         // // move the slide window
//         // while (end < s.length()) {
//         //     if (!map.containkeys(s.charAt(start))) {
//         //         count--;
//         //     } else { 
//         //         count++;
//         //         map.set(s.charAt(start), map.get(s.charAt(start)) + 1);
//         //     }
//         //     if (!map.containkeys(s.charAt(end))) {
//         //         count++;
//         //     } else {
//         //         count--;
//         //         map.get(s.charAt(end), map.get(s.charAt(end)) - 1);
//         //     }
//         //     start++;
//         //     end++;
//         // }
//     }
// }