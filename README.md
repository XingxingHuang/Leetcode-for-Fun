#### TIPs for coding
Practice is so helpful to improve one's coding skills. This github records the daily algorithm practice. In each directory, the java or python code and some tips are included. The following is some useful tips one would meet in these online coding.

#### common methods (must know):
> brute force, dfd/bfs, sorting, dp, recursive, math, number theory, bit, probabilities, games, greedy, combinatorics, divide and conquer.
> 
> two pointer
> 
> string, tree, graph, hashing, matrices

* gcd method to calculate greatest common divisor.

```java
    static long gcd(long a, long b) {
        return b == 0 ? a : gcd(b, a % b);
    }
```
* Compare two tree, please first serialize and deserialize tree.
* While using DP, we may modify the dp array with another non-linear way. 
* While use hashmap for char in string, use int[256] as HashMap instead.
* bit 
		
```java
// exchange x, y 
	x = x + y;
	y = x - y;
	x = x - y; 
	
	x = x^y; // 只能对int,char. 存不一样的bit位
	y = x^y; 
	x = x^y;
```
* for most substring problems. [leetcode discussion](https://discuss.leetcode.com/topic/30941/here-is-a-10-line-template-that-can-solve-most-substring-problems)	

```java
	string minWindow(string s, string t) {
        vector<int> map(128,0);
        for(auto c: t) map[c]++;
        int counter=t.size(), begin=0, end=0, d=INT_MAX, head=0;
        while(end<s.size()){
            if(map[s[end++]]-->0) counter--; //in t
            while(counter==0){ //valid
                if(end-begin<d)  d=end-(head=begin);
                if(map[s[begin++]]++==0) counter++;  //make it invalid
            }  
        }
        return d==INT_MAX? "":s.substr(head, d);
    }
```

#### summarry
[动态规划，九章总结](http://hongzheng.me/nine-chapter-dynamic-programming/)

#### Recodes for some "Hard" questions
[649](https://leetcode.com/problems/dota2-senate/discuss/), [495](https://leetcode.com/problems/teemo-attacking/description/). greedy

[650](https://leetcode.com/problems/2-keys-keyboard/description/), [651](https://leetcode.com/problems/4-keys-keyboard/description/) DP 

[363](https://leetcode.com/problems/max-sum-of-rectangle-no-larger-than-k/description/) matrix sum, binary search, DP, TreeSet

[659](https://leetcode.com/contest/leetcode-weekly-contest-45/problems/remove-9/) Remove 9, Math,

[166](https://leetcode.com/problems/fraction-to-recurring-decimal) Fraction to Recurring Decimal, Math, corner cases.

[137](https://leetcode.com/problems/single-number-ii/discuss/) Single Number II, bit manipunation.

[220](https://leetcode.com/problems/contains-duplicate-iii/discuss/) Contains Duplicate III, TreeSet

[564](https://leetcode.com/problems/find-the-closest-palindrome/discuss/) Find the Closest Palindrome. Hard. Becareful for corner cases.


#### Recodes for some "must do" questions

[97](https://leetcode.com/problems/interleaving-string/description/) InterLeaving String. brute force > memorization > 2D dp > 1D dp

[609](https://leetcode.com/problems/find-duplicate-file-in-system/description/) Find Duplicate File in System. BFS/DFS following up question about big files. 

[11](https://leetcode.com/problems/container-with-most-water/discuss/)   [42](https://leetcode.com/problems/trapping-rain-water) Container With Most Water. Trapping Rain Water. Two pointers.

[Subsets, Permutations, Combination Sum, Palindrome Partioning](https://leetcode.com/problems/permutations/discuss/) backtrack problems

--

http://wiki.jikexueyuan.com/project/for-offer/question-three.html

### 刷题经历 
* coursera Algorithm I, 学习java，看了大神如何分析。花了不少时间。
* （曲折）听了不少讲座，然而收效甚微
* 牛客网 直通BAT。从而建立基本的数据结构的概念
* cc150或者剑指offer。从lintcode上刷，建立起各种问题分析方法。于此同时查看cc150后面的OOD的几个经典内容
* 总结各种方法。（豁然开朗）
* leetcode一遍。(Not possible)。200 题之后应该快速过，保持速度与量，多思考，多总结。
* leetcode contest 强制自己思考和总结，认识不足，看牛人代码。
* 


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
