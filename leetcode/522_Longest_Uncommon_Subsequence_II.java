// 2017.08.02  XingxingHuang 
// 题目的意思是求一个最长substring， 这个substring只能是其中一个字符串的子串(可以不连续)，但不能是其他所有字符串的子串。

public class Solution{
    public int findLUSlength(String[] strs) {
        if (strs == null || strs.length == 0) 
            return -1;
        Arrays.sort(strs, (s1, s2) -> (-s1.length() + s2.length()));
        // 统计string出现次数，重复的不会是满足条件的字符串。
        HashMap<String, Integer> map = new HashMap<>();
        for (String str: strs) 
            map.put(str, map.getOrDefault(str, 0) + 1);
        // 开始查找最长的满足条件子串，该子串必为某一个字符串，分析可参考leetcode 521
        int idx = -1;
        for (int i = 0; i < strs.length; i++) {
            if (map.get(strs[i]) > 1) 
                continue;
            if (idx == -1) {
                idx = i;
                for (int j = 0; j < i; j++) {
                    if (check(strs[i], strs[j])) {
                        idx = -1;
                        break;
                    } 
                }  
            } else {
                break;
            }
        }
        return idx == -1 ? -1 : strs[idx].length();
    }
    private boolean check(String subs, String str) {
        // check whether subs is the substring of str
        int i = 0;
        int j = 0;
        while (i < str.length() && j < subs.length()) {
            if (subs.charAt(j) == str.charAt(i)) 
                j++;
            i++;
        }
        return j == subs.length();
    }
}


// Discussion 中的参考答案
public class Solution{
    public int findLUSlength(String[] strs) {
        Map<String, Integer> subseqFreq = new HashMap<>();
        for (String s : strs) 
            for (String subSeq : getSubseqs(s))
                subseqFreq.put(subSeq, subseqFreq.getOrDefault(subSeq, 0) + 1);
        int longest = -1;
        for (Map.Entry<String, Integer> entry : subseqFreq.entrySet()) 
            if (entry.getValue() == 1) longest = Math.max(longest, entry.getKey().length());
        return longest;
    }

    public static Set<String> getSubseqs(String s) {
        Set<String> res = new HashSet<>();
        if (s.length() == 0) {
             res.add("");
             return res;
        }
        Set<String> subRes = getSubseqs(s.substring(1));
        res.addAll(subRes);
        for (String seq : subRes) res.add(s.charAt(0) + seq);
        return res;
    }
}
// python 
// https://discuss.leetcode.com/topic/85044/python-simple-explanation
class Solution(object):
    def findLUSlength(self, strs):
        def subseq(w1, w2):
            #True iff word1 is a subsequence of word2.
            i = 0
            for c in w2:
                if i < len(w1) and w1[i] == c:
                    i += 1
            return i == len(w1)

        A.sort(key = len, reverse = True)
        for i, word1 in enumerate(A):
            if all(not subseq(word1, word2) 
                    for j, word2 in enumerate(A) if i != j):
                return len(word1)
        return -1


// // 这里是连续的子串的情况，题目理解错误
// public class Solution{
//     public int findLUSlength(String[] strs) {
//         if (strs == null || strs.length == 0) 
//             return -1;
//         Arrays.sort(strs, (s1, s2) -> (-s1.length() + s2.length()));
//         int idx = -1;
//         for (int i = 0; i < strs.length; i++) {
//             if (idx == -1 || strs[i].length() == strs[idx].length()) {
//                 for (int j = 0; j < i; j++) {
//                     if (check(strs[i], strs[j])) {
//                         idx = -1;
//                         break;
//                     } else {
//                         idx = i;
//                     }
//                 }
//             } else {
//                 break; 
//             }
//         }
//         return idx == -1 ? -1 : strs[idx].length();
//     }
//     private boolean check(String subs, String str) {
//         // check whether subs is the substring of str
//         for (int i = 0; i + subs.length() <= str.length(); i++) {
//             int j = 0;
//             while(j < subs.length() && subs.charAt(j) == str.charAt(i + j)) {
//                 j++;
//             } 
//             if (j == subs.length()) 
//                 return true;
//         } 
//         return false;
//     }
// }


// // 这个代码理解错误，计算的是一个最长的字符串，它不是其它字符串的子串。
// public class Solution {
//     public int findLUSlength(String[] strs) {
//         if (strs == null || strs.length == 0) 
//             return -1;
//         if (strs[0].length() == 0) 
//             return 0;
//         //
//         HashSet<String> set = new HashSet<>();
//         int idx = 0;
//         for (int i = 1; i < strs.length; i++) {
//             set.add(strs[i - 1]);
//             if (strs[i].length() == 0) {
//                 return 0;
//             } else if (strs[idx].length() > strs[i].length() && check(strs[idx], strs[i])) {
//                 idx = i;
//             } else {
//                 boolean flag = true;
//                 for (String tmp : set) {
//                     if (check(tmp, strs[i])) {
//                         flag = false;
//                         break;
//                     }
//                 }
//                 if (flag) 
//                     idx = i;
//             }
//         }
//         return strs[idx].length();
//     }
//     private boolean check(String str1, String str2) {
//         for (int i = 0; i < str1.length() - str2.length(); i++) 
//             if (str1.substring(i, i + str2.length()).equals(str1))
//                 return true;
//         return false;
//     }
// }