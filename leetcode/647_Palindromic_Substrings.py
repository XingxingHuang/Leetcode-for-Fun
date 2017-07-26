class Solution(object):
    def countSubstrings(self, s):
        """
        :type s: str
        :rtype: int
        """
        count = 0;
        for i in range(len(s)):
            # # itself
            # count += 1
            # 2n + 1
            for j in range(len(s)):
                if (i - j >= 0 and i + j < len(s) and s[i - j] == s[i + j]):
                    count += 1
                else:
                    break
            # 2n
            if (i + 1 < len(s) and s[i] == s[i + 1]):
                m = i
                n = i + 1
                while (m >= 0 and n < len(s) and s[m] == s[n]):
                    count += 1
                    m -= 1
                    n += 1
        return count