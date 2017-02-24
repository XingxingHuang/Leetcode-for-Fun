# Code
Learning the coding day by day

[128. Longest Consecutive Sequence](https://leetcode.com/problems/longest-consecutive-sequence/?tab=Description) 
  complexity of HashMap/HashSet ~ O(1)
  利用HashMap存储每个位置的连通的个数。在HashMap中，每次只需要连通数组两端的统计值，其余的值在循环中将不在用到，因此不需要更新。
  

[445. Add Two Numbers II](https://leetcode.com/problems/add-two-numbers-ii/)
  通过链表的方式实现两个整数的相加。利用stack存储链表，每次提取出最后一位相加，最后存储在链表中。


[148. Sort List](https://leetcode.com/problems/sort-list/) 两种思路实现链表的排序，merge sort 和 quick sort。 用递归完成归并排序程序非常简洁，很好理解。

[147. Insertion Sort List](https://leetcode.com/problems/insertion-sort-list/) 用insertion sort的方法对链表进行排序, 复杂度O(n^2), 注意对链表的排序并没有意义，速度太慢。

[328. Odd Even Linked List](https://leetcode.com/problems/odd-even-linked-list/) 与147的思路一样，考虑的是链表的基本操作。注意的是不要使用暴力的奇偶节点直接相加的方法，可以只把后面偶数节点放在前面，最后循环后将偶数节点放在奇数节点后。	
>所有链表题目注意保存最初节点位置，保存的数目跟最后需要返回的节点数目有关。

[88. Merge Sorted Array](https://leetcode.com/problems/merge-sorted-array/?tab=Solutions) 简单题，考虑的merger排序的基本过程。
>一般题目都是变种题，在特定的环境下，结题方法都会有改进的空间。这一题中直接在数组nums1中操作即可，不需要额外空间。

[19. Remove Nth Node From End of List
](https://leetcode.com/problems/remove-nth-node-from-end-of-list/) 用双指针操作链表。思路比较巧，难度不大。

[61. Rotate List
](https://leetcode.com/problems/rotate-list/) 难度不大，巧妙。将链表改变为环形链表然后移动。


[125. Valid Palindrome
](https://leetcode.com/problems/valid-palindrome/?tab=Solutions) 简单题，判断回文字符串。使用字符数字判断函数Character.isLetterOrDigit()。还有一个[简洁解法](125_easySolution.java)，不过调用了库函数。

[9. Palindrome Number] (https://leetcode.com/problems/palindrome-number/?tab=Solutions) 回文数字的判断，注意情况的判断，有一定的tricky。

[234. Palindrome Linked List](https://leetcode.com/problems/palindrome-linked-list/?tab=Solutions) 在O(n)的时间复杂度下判断链表的回文情况，这里用到了快慢指针，注意考虑指针的数目和指针的多少。运用到了链表的reverse。

[25. Reverse Nodes in k-Group] (https://leetcode.com/problems/reverse-nodes-in-k-group/?tab=Solutions) 递归的指针操作。思想不难，体会到了递归的困难之处。用递归结题时请考虑好每次递归的初始条件输出条件。其实一般程序都应如此。

[400. Nth Digit] (https://leetcode.com/problems/nth-digit/?tab=Description) 思想不难，算准很难。还有溢出问题需要考虑。

[221. Maximal Square] (https://leetcode.com/problems/maximal-square/?tab=Solutions) 动态规划练手，注意矩阵大小的初始化。

[112. Path Sum] (https://leetcode.com/problems/path-sum/?tab=Solutions) 二叉树，递归求解即可

[230. Kth Smallest Element in a BST](https://leetcode.com/problems/kth-smallest-element-in-a-bst/?tab=Solutions) 二叉树，递归求解训练好题 

[385. Mini Parser](https://leetcode.com/problems/mini-parser/?tab=Description) 练习堆栈的好题，容易出错。 

	> recursion 和 stack 方法往往是可以相互转化的
	
[67. Add Binary](https://leetcode.com/problems/add-binary/?tab=Solutions) string练手题目。字符与数字的相关操作。

> Integer.parseInt(string)	
>  int i = Integer.valueOf(my_str).intValue();	
> StringBuilder s = new StringBuilder();	
> s.reverse().toString();	
> String s = String.valueOf(i);	
> String s = Integer.toString(i);	
> String s = "" + i;	

[64. Minimum Path Sum](https://leetcode.com/problems/minimum-path-sum/?tab=Description) 动态规划简单题，直接练手。

[22. Generate Parentheses](https://leetcode.com/problems/generate-parentheses/?tab=Solutions) 找出所有可能的正反括号组合，使用递归方法求解，由下而上的思路。

[49. Group Anagrams](https://leetcode.com/problems/anagrams/?tab=Description) 字符串可以使用下面的语句来完成排序。
           
>char[] c = s.toCharArray();	
>arrays.sort(c);

python 里面也有快速排序字符串的程序

> "".join(sorted(s))
> list(s)

[71. Simplify Path](https://leetcode.com/problems/simplify-path/) 将路径转化成绝对路径。注意考虑corner case 多测试。

[3. Longest Substring Without Repeating Characters] (https://leetcode.com/problems/longest-substring-without-repeating-characters/?tab=Solutions)  找到字符串中最长子字符串的长度，非常好的string练习题。可以有的思想包括：
> 二分法	
> DP法	
> 双指针法	

[43. Multiply Strings] (https://leetcode.com/problems/multiply-strings/?tab=Solutions) 完成两个长整数字符串的相加。

[91. Decode Ways](https://leetcode.com/problems/decode-ways/?tab=Solutions) 用动态规划解决，注意0 的情况。