#### TIPs for coding
Practice is so helpful to improve one's coding skills. This github records the daily algorithm practice. In each directory, the java or python code and some tips are included. The following is some useful tips one would meet in these online coding.

* common methods (must know):
> brute force, dfd/bfs, sorting, dp, recursive, math, number theory, bit, probabilities, games, greedy, combinatorics, divide and conquer.
> 
> two pointer
> 
> string, tree, graph, hashing, matrices

* gcd method to calculate greatest common divisor.
* 
```java
        static long gcd(long a, long b) {
            return b == 0 ? a : gcd(b, a % b);
        }
```
* Compare two tree, please first serialize and deserialize tree.
* While using DP, we may modify the dp array with another non-linear way. 

* bit 
* 		
```java
	x = x + y;
	y = x - y;
	x = x - y; 
	
	x = x^y; // 只能对int,char. 存不一样的bit位
	y = x^y; 
	x = x^y;
```

#### Recodes for some "Hard" questions
[649](https://leetcode.com/problems/dota2-senate/discuss/), [495](https://leetcode.com/problems/teemo-attacking/description/). greedy

[650](https://leetcode.com/problems/2-keys-keyboard/description/), [651](https://leetcode.com/problems/4-keys-keyboard/description/) DP 

[363](https://leetcode.com/problems/max-sum-of-rectangle-no-larger-than-k/description/) matrix sum, binary search, DP, TreeSet

[659](https://leetcode.com/contest/leetcode-weekly-contest-45/problems/remove-9/) Remove 9, Math,

[166](https://leetcode.com/problems/fraction-to-recurring-decimal) Fraction to Recurring Decimal, Math, corner cases.

[137](https://leetcode.com/problems/single-number-ii/discuss/) Single Number II, bit manipunation.

--

http://wiki.jikexueyuan.com/project/for-offer/question-three.html

* 刷题步骤 
* 牛客网 直通BAT。从而建立基本的数据结构的概念
* cc150或者剑指offer。从lintcode上刷，建立起各种问题分析方法。于此同时查看cc150后面的OOD的几个经典内容
* 总结各种方法。
* 刷leetcode一遍。


基础数据结构

数组

链表

堆栈

队列

树

图

HashTable

字符串

算法思想

贪心算法

动态规划

二分法

分治算法

双指针

滑动窗口

其他主题

位运算

大数据
