[Educational Codeforces Round 26](Educational Codeforces Round 26)
---
[Tutorial](http://codeforces.com/blog/entry/53662)

A. Text Volume
-
```java
import java.io.*;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        char[] cc = br.readLine().toCharArray();
        int cnt = 0, max = 0;
        for (int i = 0; i < n; i++) {
            char c = cc[i];
            if (c == ' ')
                cnt = 0;
            else if (c >= 'A' && c <= 'Z') {
                cnt++;
                max = Math.max(max, cnt);
            }
        }
        System.out.println(max);
    }
}
```


B. Flag of Berland
-
```java
import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.InputStream;

public class Main {
	public static void main(String[] args) {
		InputStream inputStream = System.in;
		OutputStream outputStream = System.out;
		FastScanner in = new FastScanner(inputStream);
		PrintWriter out = new PrintWriter(outputStream);
		TaskB solver = new TaskB();
		solver.solve(1, in, out);
		out.close();
	}

	static class TaskB {
		public void solve(int testNumber, FastScanner in, PrintWriter out) {
			int n = in.nextInt();
			in.next();
			char[][] s = new char[n][];
			for (int i = 0; i < s.length; i++) {
				s[i] = in.next().toCharArray();
			}
			if (f(s)) {
				out.println("YES");
				return;
			}
			s = transpose(s);
			if (f(s)) {
				out.println("YES");
				return;
			}
			out.println("NO");
		}

		private char[][] transpose(char[][] s) {
			int n = s.length;
			int m = s[0].length;
			char[][] t = new char[m][n];
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					t[j][i] = s[i][j];
				}
			}
			return t;
		}

		private boolean f(char[][] s) {
			int n = s.length;
			int m = s[0].length;
			if (n % 3 != 0) {
				return false;
			}
			int k = n / 3;
			int[] ids = {0, k, 2 * k};
			for (int i : ids) {
				for (int j : ids) {
					if (i != j && s[i][0] == s[j][0]) {
						return false;
					}
				}
			}
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					if (s[i][j] != s[i / k * k][0]) {
						return false;
					}
				}
			}
			return true;
		}

	}

	static class FastScanner {
		private BufferedReader in;
		private StringTokenizer st;

		public FastScanner(InputStream stream) {
			in = new BufferedReader(new InputStreamReader(stream));
		}

		public String next() {
			while (st == null || !st.hasMoreTokens()) {
				try {
					String rl = in.readLine();
					if (rl == null) {
						return null;
					}
					st = new StringTokenizer(rl);
				} catch (IOException e) {
					throw new RuntimeException(e);
				}
			}
			return st.nextToken();
		}

		public int nextInt() {
			return Integer.parseInt(next());
		}

	}
}
```


C. Two Seals
-
```java
import java.io.*;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.Scanner;
import java.util.HashMap;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 *
 * @author XingxingHuang
 */
public class Main{
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
        int n = sc.nextInt();
        int a = sc.nextInt();
        int b = sc.nextInt();

        int[] x = new int[n];
        int[] y = new int[n];

        for (int i = 0; i < n; i++) {
            x[i] = sc.nextInt();
            y[i] = sc.nextInt();
        }

        int ans = 0;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int d1 = x[i] + x[j];
                int d2 = Math.max(y[i], y[j]);
                int A = x[i] * y[i] + x[j] * y[j];
                if(d1 <= a & d2 <= b || d1 <= b && d2 <= a)
                    ans = Math.max(A, ans);

                d1 = y[i] + y[j];
                d2 = Math.max(x[i], x[j]);
                if(d1 <= a & d2 <= b || d1 <= b && d2 <= a)
                    ans = Math.max(A, ans);

                d1 = x[i] + y[j];
                d2 = Math.max(y[i], x[j]);
                if(d1 <= a & d2 <= b || d1 <= b && d2 <= a)
                    ans = Math.max(A, ans);

                d1 = y[i] + x[j];
                d2 = Math.max(x[i], y[j]);
                if(d1 <= a & d2 <= b || d1 <= b && d2 <= a)
                    ans = Math.max(A, ans);
            }
        }

        out.println(ans);
        out.flush();
    }


    static class Scanner {
        StringTokenizer st;
        BufferedReader br;

        public Scanner(InputStream s) {
            br = new BufferedReader(new InputStreamReader(s));
        }

        public String next() throws IOException {
            while(st == null || !st.hasMoreTokens())
                st = new StringTokenizer(br.readLine());
            return st.nextToken();
        }

        public String nextLine() throws IOException {
            return br.readLine();
        }

        public int nextInt() throws NumberFormatException, IOException {
            return Integer.parseInt(next());
        }
        public long nextLong() throws NumberFormatException, IOException {
            return Long.parseLong(next());
        }
    }
}
```

D. Round Subset
-
参考[CSDN](http://blog.csdn.net/mengxiang000000/article/details/76732230)的分析，题目大意：

给你N个数，可以从中任意取出K个数，使得其K个数相乘最末尾的0的个数最多，问最多0的个数。

思路：

很显然，如果我们可以选的数中，没有2的倍数的数，也没有5的倍数的数的话，无论怎样相乘得到的结果都一定不会出现末尾的0.

如果我们可以选的数中，有2的倍数的数，但是没有5的倍数的数的话，无论怎样相乘得到的结果都一定不会出现"新"的末尾的0，那么我们考虑问题的关键点，就在于相乘的这K个数中，有多少个2，又有多少个5..

那么我们处理出num_two[i]，表示第i个数中包含多少个2(while(num%2==0)num_two[i]++)，同理再预处理出num_fIve[i]；

那么我们考虑最优的去Dp，设定dp[i][j][k]表示我们进行Dp到第i个数，选了j个数，2的个数为k个的话，能够获得的5的个数的最大个数。

Let dp[i][j][l] be the maximum amount of twos we can collect by checking first i numbers, taking j of them with total power of five equal to l. It is usually called "the knapsack problem".

```java
import java.util.*;

public class d{
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt(), K = in.nextInt();
		int[][] pairs = new int[N][];
		int sumFives = 0;
		for(int n=0;n<N;n++){
			long a = in.nextLong();
			pairs[n] = new int[]{0,0};
			for(; a % 2 == 0; a /= 2){
				pairs[n][0]++;
			}
			for(; a % 5 == 0; a /= 5){
				pairs[n][1]++;
			}
			sumFives += pairs[n][1];  // total 5 in those numbers
		}
		
		int[][] dp = new int[sumFives+1][K+1];
		for(int[] a : dp) Arrays.fill(a, -1);
		dp[0][0] = 0; // initialized
		
		int ans = 0;
		for(int n=0;n<N;n++){
			int d2 = pairs[n][0], d5 = pairs[n][1]; // count 2, 5 in the nth number
			for(int s = sumFives; s >= d5; s--){  // number of 5 
				for(int k = K; k > 0; k--){
					if(dp[s-d5][k-1] != -1){
						// first dimesion optimized
						dp[s][k] = Math.max(dp[s][k], dp[s-d5][k-1] + d2); 					}
				}
			}
		}

		for(int s=0;s<=sumFives;s++){
//			System.out.println(Arrays.toString(dp[s]));
			ans = Math.max(ans, Math.min(s, dp[s][K]));
		}
		
		System.out.println(ans);
	}
}
```
E. Vasya's Function
-
One important fact is that when we subtract gcd(x, y) from y, new gcd(x, y) will be divisible by old gcd(x, y). And, of course, x is always divisible by gcd(x, y).

Let's factorize x. Consider the moment when gcd(x, y) changes. If we denote old value of gcd(x, y) by g, the new value of gcd(x, y) will be divisible by some k·g, where k is a prime divisor of x. Let's check all prime divisors of x and for each of these divisors find the number of times we need to subtract g from y to get gcd(x, y) divisible by k·g; that is just (don't forget that x also has to be divisible by k·g). Among all prime divisors of x pick one with the minimum required number of operations (let this number of operations be m), add m to answer, subtract m·g from y and repeat the process.

``` java
import java.io.*;
import java.util.*.

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 */
public class Main {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        Scanner in = new Scanner(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        TaskE solver = new TaskE();
        solver.solve(1, in, out);
        out.close();
    }

    static class TaskE {
        long solve(long a, long b) {
            if (b == 0) return 0;
            long g = gcd(a, b);
            long bestNeeded = Long.MAX_VALUE, num = g;
            for (long d = 1; d * d <= a; d++) {
                if (a % d == 0) {
                    // 对于a的某个约数(要求大于g，并且能被g整除)，我们计算最小的需要扣除次数needed
                    if (d % g == 0 && d > g) {
                        long needed = (b - (b / d) * d) / g;
                        if (needed < bestNeeded) {
                            bestNeeded = needed;
                            num = d;
                        }
                    }
                    long d2 = a / d;
                    if (d2 > g && d2 % g == 0) {
                        long needed = (b - (b / d2) * d2) / g;
                        if (needed < bestNeeded) {
                            bestNeeded = needed;
                            num = d2;
                        }
                    }
                }
            }
            if (num == g) 
                return b / g;
            else 
                return bestNeeded + solve(a, b - g * bestNeeded);
        }

        public void solve(int testNumber, Scanner sc, PrintWriter out) {
            out.println(solve(sc.nextLong(), sc.nextLong()));
        }

        static long gcd(long a, long b) {
            return b == 0 ? a : gcd(b, a % b);
        }
    }

    static class Scanner {
        StringTokenizer st;
        BufferedReader br;

        public Scanner(InputStream s) {
            br = new BufferedReader(new InputStreamReader(s));
        }

        public String next() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (Exception e) {
                };
            }
            return st.nextToken();
        }

        public long nextLong() {
            return Long.parseLong(next());
        }
    }
}
```

By Dukkha

```java
import java.io.*;
import java.util.*;

public class CF837E {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		long x = Long.parseLong(st.nextToken());
		long y = Long.parseLong(st.nextToken());
		long[] aa = new long[6720];	// http://oeis.org/A066150
		int n = 0;
		// 提前计算好 a 的约数。
		for (long a = 1; a * a <= x; a++)
			if (x % a == 0) {
				aa[n++] = a;
				if (a * a < x)
					aa[n++] = x / a;
			}
		aa = Arrays.copyOf(aa, n);
		Arrays.sort(aa);
		int h = n - 1;
		while (h > 0 && y % aa[h] != 0)
			h--;
		long f = 0;
		while (y > 0) {
			long kmin = y / aa[h];
			int imin = h;
			for (int i = h + 1; i < n; i++)
				if (aa[i] % aa[h] == 0) {
					long k = y % aa[i] / aa[h];
					if (kmin >= k) {
						kmin = k;
						imin = i;
					}
				}
			f += kmin;
			y -= kmin * aa[h];
			h = imin;
		}
		System.out.println(f);
	}
}
```
F. Prefix Sums
-
```java
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.InputMismatchException;

public class G {
	InputStream is;
	PrintWriter out;
	String INPUT = "";
	
	void solve()
	{
		int n = ni();
		int[][] ps = new int[n][];
		for(int i = 0;i < n;i++){
			ps[i] = na(6);
		}
		PersistentSegmentTreeRSQSimple pst0 = new PersistentSegmentTreeRSQSimple(200005, n*3);
		PersistentSegmentTreeRSQSimple pst1 = new PersistentSegmentTreeRSQSimple(200010, n*2);
		for(int i = 0;i < n;i++){
			pst0.add(0, ps[i][2]);
			pst0.add(ps[i][0]+1, -ps[i][2]+ps[i][4]);
			pst0.add(ps[i][1]+1, -ps[i][4]+ps[i][5]);
			pst1.add(ps[i][0]+1, ps[i][3]);
			pst1.add(ps[i][1]+1, -ps[i][3]);
		}
		long last = 0;
		for(int Q = ni();Q > 0;Q--){
			int l = ni()-1, r = ni()-1, x = ni();
			x = (int)((x+last)%1000000000);
			x = Math.min(x, 200005);
			long R = pst0.sum(0, x+1, 3*(r+1)) + pst1.sum(0, x+1, 2*(r+1)) * x;
			long L = pst0.sum(0, x+1, 3*l) + pst1.sum(0, x+1, 2*l) * x;
			out.println(last = R-L);
		}
	}
	
	public static class PersistentSegmentTreeRSQSimple {
		public long[] st;
		public int[] len;
		public int[] L;
		public int[] R;
		public int gen;
		public int egen;
		public int H;
		public int[] entries;
		
		public PersistentSegmentTreeRSQSimple(int n, int q) {
			H = Integer.highestOneBit(Math.max(n-1, 1))<<1;
			int bufsize = (1+Integer.numberOfTrailingZeros(H)) * q + 2*H;
			
			gen = 0;
			entries = new int[q+1];
			st = new long[bufsize];
			len = new int[bufsize];
			L = new int[bufsize];
			R = new int[bufsize];
			Arrays.fill(L, -1);
			Arrays.fill(R, -1);
			
			egen = 0;
			entries[egen++] = make(0, H);
		}
		
		private int make(int l, int r)
		{
			int id = gen++;
			len[id] = r-l;
			if(r-l > 1){
				L[id] = make(l, l+r>>>1);
				R[id] = make(l+r>>>1, r);
			}
			return id;
		}
		
		public void add(int x, long v)
		{
			add(x, v, egen-1);
		}
		
		public void add(int x, long v, int eid)
		{
			entries[egen++] = adddfs(x, v, entries[eid]);
		}
		
		private int clone(int id)
		{
			int cloned = gen++;
			len[cloned] = len[id];
			L[cloned] = L[id];
			R[cloned] = R[id];
			st[cloned] = st[id];
			return cloned;
		}
		
		private int adddfs(int x, long v, int cur)
		{
			assert cur != -1;
			int cloned = clone(cur);
			if(len[cloned] == 1){
				st[cloned] += v;
				return cloned;
			}else{
				int h = len[cloned]/2;
				if(x < h){
					L[cloned] = adddfs(x, v, L[cloned]);
				}else{
					R[cloned] = adddfs(x-h, v, R[cloned]);
				}
				propagate(cloned);
				return cloned;
			}
		}
		
		
		public long sum(int l, int r, int eid)
		{
			return l >= r ? 0L : sumdfs(l, r, entries[eid]);
		}
		
		private long sumdfs(int l, int r, int cur)
		{
//				tr(l, r, cur, len[cur]);
			assert cur != -1;
			if(l == 0 && r == len[cur]){
				return st[cur];
			}else{
				int h = len[cur]/2;
				long ret = 0;
				if(l < h)ret += sumdfs(l, Math.min(h, r), L[cur]);
				if(h < r)ret += sumdfs(Math.max(l-h, 0), r-h, R[cur]);
				return ret;
			}
		}
		
		private void propagate(int cur)
		{
			st[cur] = 0;
			if(L[cur] != -1)st[cur] += st[L[cur]];
			if(R[cur] != -1)st[cur] += st[R[cur]];
		}
	}
	
	void run() throws Exception
	{
		is = oj ? System.in : new ByteArrayInputStream(INPUT.getBytes());
		out = new PrintWriter(System.out);
		
		long s = System.currentTimeMillis();
		solve();
		out.flush();
		tr(System.currentTimeMillis()-s+"ms");
	}
	
	public static void main(String[] args) throws Exception { new G().run(); }
	
	private byte[] inbuf = new byte[1024];
	public int lenbuf = 0, ptrbuf = 0;
	
	private int readByte()
	{
		if(lenbuf == -1)throw new InputMismatchException();
		if(ptrbuf >= lenbuf){
			ptrbuf = 0;
			try { lenbuf = is.read(inbuf); } catch (IOException e) { throw new InputMismatchException(); }
			if(lenbuf <= 0)return -1;
		}
		return inbuf[ptrbuf++];
	}
	
	private boolean isSpaceChar(int c) { return !(c >= 33 && c <= 126); }
	private int skip() { int b; while((b = readByte()) != -1 && isSpaceChar(b)); return b; }
	
	private double nd() { return Double.parseDouble(ns()); }
	private char nc() { return (char)skip(); }
	
	private String ns()
	{
		int b = skip();
		StringBuilder sb = new StringBuilder();
		while(!(isSpaceChar(b))){ // when nextLine, (isSpaceChar(b) && b != ' ')
			sb.appendCodePoint(b);
			b = readByte();
		}
		return sb.toString();
	}
	
	private char[] ns(int n)
	{
		char[] buf = new char[n];
		int b = skip(), p = 0;
		while(p < n && !(isSpaceChar(b))){
			buf[p++] = (char)b;
			b = readByte();
		}
		return n == p ? buf : Arrays.copyOf(buf, p);
	}
	
	private char[][] nm(int n, int m)
	{
		char[][] map = new char[n][];
		for(int i = 0;i < n;i++)map[i] = ns(m);
		return map;
	}
	
	private int[] na(int n)
	{
		int[] a = new int[n];
		for(int i = 0;i < n;i++)a[i] = ni();
		return a;
	}
	
	private int ni()
	{
		int num = 0, b;
		boolean minus = false;
		while((b = readByte()) != -1 && !((b >= '0' && b <= '9') || b == '-'));
		if(b == '-'){
			minus = true;
			b = readByte();
		}
		
		while(true){
			if(b >= '0' && b <= '9'){
				num = num * 10 + (b - '0');
			}else{
				return minus ? -num : num;
			}
			b = readByte();
		}
	}
	
	private long nl()
	{
		long num = 0;
		int b;
		boolean minus = false;
		while((b = readByte()) != -1 && !((b >= '0' && b <= '9') || b == '-'));
		if(b == '-'){
			minus = true;
			b = readByte();
		}
		
		while(true){
			if(b >= '0' && b <= '9'){
				num = num * 10 + (b - '0');
			}else{
				return minus ? -num : num;
			}
			b = readByte();
		}
	}
	
	private boolean oj = System.getProperty("ONLINE_JUDGE") != null;
	private void tr(Object... o) { if(!oj)System.out.println(Arrays.deepToString(o)); }
}
```

G. Functions On The Segments
-

