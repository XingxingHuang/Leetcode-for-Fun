#### TIPs for coding
Practice is so helpful to improve one's coding skills. This github records the daily algorithm practice. In each directory, the java or python code and some tips are included. The following is some useful tips one would meet in these online coding.

#### common methods (must know):

 brute force, dfd/bfs, sorting, dp, recursive, math, number theory, bit, probabilities, games, greedy, combinatorics, divide and conquer.
 
 two pointer, Sweepline
 
 string, tree, graph, hashing, matrices

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
	
// get the last 1.
// in bit, -diff is reverse every bit position and plus 1.
diff &= -diff;
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

* to find the one different char or int, use bit manipulation like [389](https://leetcode.com/problems/find-the-difference/)

#### summarry
[动态规划，九章总结](http://hongzheng.me/nine-chapter-dynamic-programming/)

#### Recodes for some "Hard" questions
[649](https://leetcode.com/problems/dota2-senate/discuss/), [495](https://leetcode.com/problems/teemo-attacking/description/). greedy

[650](https://leetcode.com/problems/2-keys-keyboard/description/), [651](https://leetcode.com/problems/4-keys-keyboard/description/) DP 

[363](https://leetcode.com/problems/max-sum-of-rectangle-no-larger-than-k/description/) matrix sum, binary search, DP, TreeSet

[659](https://leetcode.com/contest/leetcode-weekly-contest-45/problems/remove-9/) Remove 9, Math,

[166](https://leetcode.com/problems/fraction-to-recurring-decimal) Fraction to Recurring Decimal, Math, corner cases.

[137](https://leetcode.com/problems/single-number-ii/discuss/) Single Number II, bit manipunation. very hard

[220](https://leetcode.com/problems/contains-duplicate-iii/discuss/) Contains Duplicate III, TreeSet

[564](https://leetcode.com/problems/find-the-closest-palindrome/discuss/) Find the Closest Palindrome. Hard. Becareful for corner cases.

[32](https://leetcode.com/problems/longest-valid-parentheses/) Longest Valid Parentheses DP, stack. hard problem but with many smart idea.

[218](https://leetcode.com/problems/the-skyline-problem/description/) The skyline problem. Use Sweepline method. 

[30](https://leetcode.com/problems/substring-with-concatenation-of-all-words/description/) Substring with Concatenation of All Words. Two different method, the fast one is hard. 

[146](https://leetcode.com/problems/lru-cache) LRU Cache LinkedHashMap


#### Recodes for some "must do" questions

[1](https://leetcode.com/problems/two-sum/description/) [167](https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/) Two Sum and related two sum and other N sum questions. Must do!

[11](https://leetcode.com/problems/container-with-most-water/discuss/)   [42](https://leetcode.com/problems/trapping-rain-water) Container With Most Water. Trapping Rain Water. Two pointers.

[Subsets, Permutations, Combination Sum, Palindrome Partioning](https://leetcode.com/problems/permutations/discuss/) backtrack problems

[44](https://leetcode.com/problems/wildcard-matching/discuss/) Wildcard Matching basic DP method

[54](https://leetcode.com/problems/spiral-matrix/description/) Spiral Matrix. Print maxtix problem. Practice the basic coding skill with edges.

[97](https://leetcode.com/problems/interleaving-string/description/) InterLeaving String. brute force > memorization > 2D dp > 1D dp


[189](https://leetcode.com/problems/rotate-array/description/) Easy but interesting, use as many methods as you can to rotate array.  Must know the reverse method by two reverses.

[202](https://leetcode.com/problems/happy-number/description/) Happy Number. Interesting problem with two solutions. One solution is similiar to the cycle detetion in linkedlist.

[373](https://leetcode.com/problems/find-k-pairs-with-smallest-sums/) Find K Pairs with Smallest Sums. Use priority queue for questions about "Top K". This is a hard problem.

[401](https://leetcode.com/problems/binary-watch/discuss/) easy question. Attention: think more about each question. Every question has its own method. 

[404](https://leetcode.com/problems/sum-of-left-leaves) Sum of Left Leaves. Many tree problems can be solved with iterative and recursive methods.

[458](https://leetcode.com/problems/poor-pigs/) Poor Pigs.

[609](https://leetcode.com/problems/find-duplicate-file-in-system/description/) Find Duplicate File in System. Interesting, BFS/DFS for the follow up question about big files. 

--

http://wiki.jikexueyuan.com/project/for-offer/question-three.html

### Resources
[www.glassdoor.ca](www.glassdoor.ca)	
[www.careercup.com](www.careercup.com)	
[www.geeksforgeeks.com](www.geeksforgeeks.com)	
[www.leetcode.com](www.leetcode.com)	
[www.hackerrank.com](www.hackerrank.com)	
[www.topcoder.com](www.topcoder.com)	

**Mock Interviews**

* groups of 2 or 3(max)
* Interviewee, ask questions, discuss approach, though as code 
* Interviewer, pick question, guide if lost


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
