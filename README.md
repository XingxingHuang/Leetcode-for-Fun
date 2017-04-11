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

[151. Reverse Words in a String](https://leetcode.com/problems/reverse-words-in-a-string/?tab=Solutions) 完成字符串中单词的翻转。不适用API的情况下可以用stack结构完成，也可以使用从后往前读取字符串的方式完成。还可以考虑**翻转整个字符串**的方式。

[214. Shortest Palindrome](https://leetcode.com/problems/shortest-palindrome/?tab=Solutions) 修改字符串达到最小回文字符串，暴力解法不难，但是需要注意边界情况。开始没有处理好完全没有回文字符串的情况。另外时间复杂度可以优化，通过[KMP方法](https://discuss.leetcode.com/topic/27261/clean-kmp-solution-with-super-detailed-explanation)。代码简洁度可以优化，例如用[递归的方法](https://discuss.leetcode.com/topic/21068/my-7-lines-recursive-java-solution)

[503. Next Greater](https://leetcode.com/problems/next-greater-element-ii/?tab=Description) 维护一个最小栈结构，注意corner case的考虑。

[451. Sort Characters By Frequency](https://leetcode.com/problems/sort-characters-by-frequency/?tab=Solutions) 计数问题可以想到用HashMap来快速记录和读取每个元素出现的个数。用bucket sort的方法来对计数问题进行快速排序。

[150. Evaluate Reverse Polish Notation](https://leetcode.com/problems/evaluate-reverse-polish-notation/?tab=Solutions) 用栈结构即可解决。注意处理运算次序问题。**每次写完程序请跑一下test case**

[373. Find K Pairs with Smallest Sums] (https://leetcode.com/problems/find-k-pairs-with-smallest-sums/?tab=Description) 注意一系列的TOP K 的问题，解法很类似。考虑哈希堆，最大/小堆。**熟练代码**

[263. Ugly Number] (https://leetcode.com/problems/ugly-number/?tab=Description) 判断是否为ugly number, 注意考虑后续问题。

[475. Heaters] (https://leetcode.com/problems/heaters/#/solutions) 应用二分查找法，或者直接暴力查找。很好的corner case 的练习

[278. First Bad Version] (https://leetcode.com/problems/first-bad-version/#/solutions) 二分法的基础训练，注意位移操作优先级低于加减符号，高于大于小于号。二分法注意指标corner case

[74. Search a 2D Matrix] (https://leetcode.com/problems/search-a-2d-matrix/#/description) 初级二分法题目。[二分法总结](https://mp.weixin.qq.com/s?__biz=MzAwMDk1MTUyNw==&mid=2247484110&idx=3&sn=c6403ffc79f278affcdf651e7ed8437e&chksm=9ae05746ad97de50a131c586272a6ab2a6dbb19186c0e92aa387c61d725db7d367e18df0614e&mpshare=1&scene=1&srcid=03149mRY4cn1dmyw7hDfpGeL&key=32ff7e6b073562f957522cfd39539c30bdab6c9beb05ffbb79eec8be5bf9b2b23a3cb866ef0467bef8684a002f1bb925b1fd4f0a810089352a9ca5cb4a5eb68f7d015d05b303378b3274313d8ab8a479&ascene=0&uin=NzIzOTQyODAx&devicetype=iMac+MacBookPro11%2C1+OSX+OSX+10.9.5+build(13F1911)&version=11020201&pass_ticket=usXZy7VMRtnoFNo4bPHKthdhL%2FjUpdAOJ1iPEB8Q61r6cM3KmbHGv35B3YiNFjXS)

[153. Find Minimum in Rotated Sorted Array] (https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/#/description) 采用标准的二分法模板结题，好处是每次不用为边界的条件考虑太多，只是最终的代码行数会多一点点。

[78. subsets](https://leetcode.com/problems/subsets/#/solutions) 回溯法 backtrack。该题需要练习

[139. Word Break](https://leetcode.com/problems/word-break/#/description) 用DP方法分割字符。

[140. Word Break II](https://leetcode.com/problems/word-break-ii/#/description) 这一题需要重新审查，HARD难度 重新联系。DFS。见[每日一题](https://mp.weixin.qq.com/s?__biz=MzAwMDk1MTUyNw==&mid=2247484710&idx=1&sn=4cd1f71258d64e365eb632bcea368ed4&chksm=9ae050aead97d9b886acc87e7af313a863416a790a6948d5a64093d535856fdb36d05615b26c&mpshare=1&scene=1&srcid=0327QGTsI4ihK0ZdhKOdCiTP&key=056e2b9cbd625ceac4870f519af30a3b4626083f30946a8c65aa942ad24d933b1b2da1246d4cbffcab2dcd3d3215df0012f42f2ddf5f201c2b0f3478030c9207c08c37cb6b1403db8a4bb11e56681ede&ascene=0&uin=NzIzOTQyODAx&devicetype=iMac+MacBookPro11%2C1+OSX+OSX+10.9.5+build(13F1911)&version=11020201&pass_ticket=4gxhVzKA%2FMbWwKr26bHjhhM19bLa1cgo%2Bf41rJB2OYlhuE2LC9F3uawL5YGsFRDj)

[121. Best Time to Buy and Sell Stock](https://leetcode.com/problems/best-time-to-buy-and-sell-stock/#/description) 从 O(N^2) 到 O(N) 的进化。
> 关于股票问题的相关总结 [见这里](https://sophiesongge.github.io/leetcode/2017/02/15/buy-sell-stock.html)

[122. Best Time to Buy and Sell Stock II](https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/#/description) 注意与实际股票的差异，实际是寻找波峰和波谷这样的最大最小子结构.
>动态规划: 初始状态→│决策１│→│决策２│→…→│决策ｎ│→结束状态	
>贪心: 初始状态→│第一步最优解│→│第二步最优解│→…→│第n步最优解│→结束状态

>很多问题都可以用动态规划和贪心两种方法来解决, 比如著名的背包问题(这是宝宝大学时期的一个大作业, 至今印象深刻)。 相对来讲, 一般情况下, 贪心算法占的空间会小一点, 但是, 贪心算法并不能保证最终得到的是全局最优解。
>
> 每个问题拿到的时候请先用数学形式描述出来，这时候基本上暴力解法就差不多了。

[435. Non-overlapping Intervals] (https://leetcode.com/problems/non-overlapping-intervals/#/description) 问题的本质是查找overlap的数目，这时候需要考虑到底有多少中overlap的情况。主要想到先排序比较难。

[452. Minimum Number of Arrows to Burst Balloons] (https://leetcode.com/problems/minimum-number-of-arrows-to-burst-balloons/#/description) 贪心算法的基本题型，注意考虑的是原始数据排序是递增和递减的情况

[321. Create Maximum Number] (https://leetcode.com/problems/create-maximum-number/#/description)  hard难度，适合练习！！重新练习

[179. Largest Number](https://leetcode.com/problems/largest-number/#/solutions) 思路的思考

[324. Wiggle Sort I] () O(n)算法，简单循环即可。

[324. Wiggle Sort II] (https://leetcode.com/problems/wiggle-sort-ii/#/solutions) 快排+index mapping，重新读代码，难度略大。

[102. Binary Tree Level Order Traversal I](https://leetcode.com/problems/binary-tree-level-order-traversal/#/solutions) DFS BFS 

[107. Binary Tree Level Order Traversal II](https://leetcode.com/problems/binary-tree-level-order-traversal-ii/#/description)  DFS BFS 必须练习题目. Given a binary tree, return the bottom-up level order traversal of its nodes' values. (ie, from left to right, level by level from leaf to root).