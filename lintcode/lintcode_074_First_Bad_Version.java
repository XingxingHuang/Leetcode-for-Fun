// http://www.lintcode.com/en/problem/first-bad-version/
/**
 * public class SVNRepo {
 *     public static boolean isBadVersion(int k);
 * }
 * you can use SVNRepo.isBadVersion(k) to judge whether 
 * the kth code version is bad or not.
*/
class Solution {
    /**
     * @param n: An integers.
     * @return: An integer which is the first bad version.
     */
    public int findFirstBadVersion(int n) {
        // write your code here
        int l = 1;
        int r = n;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (SVNRepo.isBadVersion(mid)) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        if (SVNRepo.isBadVersion(l)) {
            return l;
        } else {
            return l + 1;
        }
    }
}


class Solution {
    /**
     * @param n: An integers.
     * @return: An integer which is the first bad version.
     */
    public int findFirstBadVersion(int n) {
        // write your code here
        int l = 1;
        int r = n;
        while (l + 1 < r) {
            int mid = l + (r - l) / 2;
            if (SVNRepo.isBadVersion(mid)) {
                r = mid;
            } else {
                l = mid;
            }
        }
        if (SVNRepo.isBadVersion(l)) {
            return l;
        } 
        return r;
    }
}
