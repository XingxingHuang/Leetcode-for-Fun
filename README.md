# Code
Learning the coding day by day

[128. Longest Consecutive Sequence](https://leetcode.com/problems/longest-consecutive-sequence/?tab=Description) 
  complexity of HashMap/HashSet ~ O(1)
  利用HashMap存储每个位置的连通的个数。在HashMap中，每次只需要连通数组两端的统计值，其余的值在循环中将不在用到，因此不需要更新。
