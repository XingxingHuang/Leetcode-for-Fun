# Code
Learning the coding day by day

[128. Longest Consecutive Sequence](https://leetcode.com/problems/longest-consecutive-sequence/?tab=Description) 
  complexity of HashMap/HashSet ~ O(1)
  利用HashMap存储每个位置的连通的个数。在HashMap中，每次只需要连通数组两端的统计值，其余的值在循环中将不在用到，因此不需要更新。
  

[445. Add Two Numbers II](https://leetcode.com/problems/add-two-numbers-ii/)
  通过链表的方式实现两个整数的相加。利用stack存储链表，每次提取出最后一位相加，最后存储在链表中。


[148. Sort List](https://leetcode.com/problems/sort-list/) 两种思路实现链表的排序，merge sort 和 quick sort。 用递归完成归并排序程序非常简洁，很好理解。