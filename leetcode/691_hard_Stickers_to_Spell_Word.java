// hard problem unsolved 
// check the solution to see the answers 
// https://leetcode.com/problems/stickers-to-spell-word/solution/


// dp method
class Solution {
    public int minStickers(String[] stickers, String target) {
        int N = target.length();
        int[] dp = new int[1 << N];
        for (int i = 1; i < 1 << N; i++) dp[i] = -1;

        for (int state = 0; state < 1 << N; state++) {
            if (dp[state] == -1) continue;
            for (String sticker: stickers) {
                int now = state;
                for (char letter: sticker.toCharArray()) {
                    for (int i = 0; i < N; i++) {
                        if (((now >> i) & 1) == 1) continue;
                        if (target.charAt(i) == letter) {
                            now |= 1 << i;
                            break;
                        }
                    }
                }
                if (dp[now] == -1 || dp[now] > dp[state] + 1) {
                    dp[now] = dp[state] + 1;
                }
            }
        }
        return dp[(1 << N) - 1];
    }
}


//Approach #1: Optimized Exhaustive Search [Accepted]
// Intuition

// A natural answer is to exhaustively search combinations of stickers. Because the data is randomized, there are many heuristics available to us that will make this faster.

// For all stickers, we can ignore any letters that are not in the target word.

// When our candidate answer won't be smaller than an answer we have already found, we can stop searching this path.

// We should try to have our exhaustive search bound the answer as soon as possible, so the effect described in the above point happens more often.

// When a sticker dominates another, we shouldn't include the dominated sticker in our sticker collection. [Here, we say a sticker A dominates B if A.count(letter) >= B.count(letter) for all letters.]

class Solution {
    int best;
    int[][] stickersCount;
    int[] targetCount;

    public void search(int ans, int row) {
        if (ans >= best) return;
        if (row == stickersCount.length) {
            for (int c: targetCount) if (c > 0) return;
            best = ans;
            return;
        }

        int used = 0;
        for (int i = 0; i < stickersCount[row].length; i++) {
            if (targetCount[i] > 0 && stickersCount[row][i] > 0) {
                used = Math.max(used, (targetCount[i] - 1) / stickersCount[row][i] + 1);
            }
        }
        for (int i = 0; i < stickersCount[row].length; i++) {
            targetCount[i] -= used * stickersCount[row][i];
        }

        search(ans + used, row + 1);
        while (used > 0) {
            for (int i = 0; i < stickersCount[row].length; i++) {
                targetCount[i] += stickersCount[row][i];
            }
            used--;
            search(ans + used, row + 1);
        }
    }

    public int minStickers(String[] stickers, String target) {
        int[] targetNaiveCount = new int[26];
        for (char c: target.toCharArray()) targetNaiveCount[c - 'a']++;

        int[] index = new int[26];
        int t = 0;
        for (int i = 0; i < 26; i++) {
            if (targetNaiveCount[i] > 0) {
                index[i] = t++;
            } else {
                index[i] = -1;
            }
        }

        targetCount = new int[t];
        t = 0;
        for (int c: targetNaiveCount) if (c > 0) {
            targetCount[t++] = c;
        }

        stickersCount = new int[stickers.length][t];
        for (int i = 0; i < stickers.length; i++) {
            for (char c: stickers[i].toCharArray()) {
                int j = index[c - 'a'];
                if (j >= 0) stickersCount[i][j]++;
            }
        }

        int anchor = 0;
        for (int i = 0; i < stickers.length; i++) {
            for (int j = anchor; j < stickers.length; j++) if (j != i) {
                boolean dominated = true;
                for (int k = 0; k < t; k++) {
                    if (stickersCount[i][k] > stickersCount[j][k]) {
                        dominated = false;
                        break;
                    }
                }

                if (dominated) {
                    int[] tmp = stickersCount[i];
                    stickersCount[i] = stickersCount[anchor];
                    stickersCount[anchor++] = tmp;
                    break;
                }
            }
        }

        best = target.length() + 1;
        search(0, anchor);
        return best <= target.length() ? best : -1;
    }
}




class Solution {
    int min;
    int[][] cnt;
    int[] tCnt;
    
    void recur(int i, int c, int[] cCnt, int j) {
        if(c>min)
            return;
        while(i<26&&cCnt[i]>=tCnt[i])
            ++i;
        if(i>=26) {
            min=c;
            return;
        }
        for(; j<cnt.length; ++j) {
            if(cnt[j][i]==0)
                continue;
            for(int k=i; k<26; ++k)
                cCnt[k]+=cnt[j][k];
            if(cCnt[i]<tCnt[i])
                recur(i, c+1, cCnt, j);
            else
                recur(i+1, c+1, cCnt, 0);
            for(int k=i; k<26; ++k)
                cCnt[k]-=cnt[j][k];
        }
    }
    
    public int minStickers(String[] stickers, String target) {
        min=Integer.MAX_VALUE;
        cnt = new int[stickers.length][26];
        for(int i=0; i<stickers.length; ++i)
            for(char c : stickers[i].toCharArray())
                ++cnt[i][c-'a'];
        tCnt = new int[26];
        for(char c : target.toCharArray())
            ++tCnt[c-'a'];
        for(int i=0; i<26; ++i) {
            if(tCnt[i]==0)
                continue;
            boolean has=false;
            for(int j=0; j<stickers.length; ++j) {
                if(cnt[j][i]>0) {
                    has=true;
                    break;
                }
            }
            if(!has)
                return -1;
        }
        recur(0, 0, new int[26], 0);
        return min;
    }
}