[Educational Codeforces Round 27](http://codeforces.com/contest/845)
---
[Tutorial not yet]()

Tips and answers for the questions by XingxingHuang. Finished A, B, C, D, not for E, F. B is hacked.

A. Text Volume
-
Sort the array and check whether the middle values equals. As the best case is for the two teams, the highest rating person is matched with the lowest rating persion.

B. Luba And The Ticket
-
Solution: 29654620
Brute force solution, for every number, calculate whether it faces the requirement and then determine the numbers of digits that need to be replaced.
```java
public class b {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.next();
        int[] arr = new int[6];
        for (int i = 0; i < 6; i++) {
            arr[i] = str.charAt(i) - '0';
        }
        int min = 6;
        for (int a = 0; a <= 999999; a++) {
            str = String.format("%06d", a);
            int[] arr2 = new int[6];
            for (int i = 0; i < 6; i++) {
                arr2[i] = str.charAt(i) - '0';
            }
            if (arr2[0] + arr2[1] + arr2[2] != arr2[3] + arr2[4] + arr2[5]) continue;
            
            int x = 0;
            for (int i = 0; i < 6; i++) {
                if (arr[i] != arr2[i]) {
                    x++;
                }
            }
            min = Math.min(min, x);
        }
        System.out.println(min);
    }
}
```


C. Two TVs
-
Just check whether two tv shows can be collected.

D. Driving Test
-
Need to understand the problem clearly. A stack to store the passed speed limit, another number to store the passed "no overtake allowed" sign.

Solution: 29657299

```java
public class D845 {

	public static void main(String[] args) throws IOException {
		IO io = new IO(System.in);

		int no_overtake = 0;
		long INF = 1000;
		long res = 0;
		long speed = 0;

		int n = io.nextInt();

		Stack<Long> st = new Stack<>();
		st.push(INF);

		for (int i = 0; i < n; i++) {
			int t = io.nextInt();
			long s = 0;
			if (t == 1 || t == 3) {
				s = io.nextLong();
			}

			if (t == 1) {
				speed = s;
				while (st.peek() < speed) {
					res++;
					st.pop();
				}
			} else if (t == 2) {
				res += no_overtake;
				no_overtake = 0;
			} else if (t == 3) {
				if (s >= speed) {
					st.push(s);
				} else {
					res++;
				}
			} else if (t == 4) {
				no_overtake = 0;
			} else if (t == 5) {
				st.push(INF);
			} else if (t == 6) {
				no_overtake++;
			}
		}

		io.println(res);
		io.close();
	}
```

E.
-

Solution: 29663127

```java
By kammola, contest: Educational Codeforces Round 27, problem: (E) Fire in the City, Accepted, #, hack it!
 import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Abood1A {

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);

		int n = sc.nextInt();
		int m = sc.nextInt();

		int k = sc.nextInt();

		Integer[] ordX = new Integer[k];
		Integer[] ordY = new Integer[k];

		int[] X = new int[k];
		int[] Y = new int[k];

		for (int i = 0; i < k; i++) {
			ordX[i] = i;
			ordY[i] = i;
			X[i] = sc.nextInt();
			Y[i] = sc.nextInt();
		}
		Arrays.sort(ordX, new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				if(X[o1] != X[o2])
					return X[o1] - X[o2];
				return o1 - o2;
			}
		});

		Arrays.sort(ordY, new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				if(Y[o1] != Y[o2])
					return Y[o1] - Y[o2];
				return o1 - o2;
			}
		});

		int lo = 0;
		int hi = (int) 1e9 + 5;
		int ans = -1;
		while(lo <= hi) {
			int mid = (lo + hi) / 2;
			int[] x1 = new int[k];
			int[] x2 = new int[k];
			int[] y1 = new int[k];
			int[] y2 = new int[k];

			ArrayList<Integer> rowTochB = new ArrayList<>();
			ArrayList<Integer> colTochB = new ArrayList<>();
			ArrayList<Integer> rowTochE = new ArrayList<>();
			ArrayList<Integer> colTochE = new ArrayList<>();

			rowTochB.add(1);
			colTochB.add(1);
			rowTochE.add(n);
			colTochE.add(m);

			for (int i = 0; i < k; i++) { 
				x1[i] = Math.max(1, X[i] - mid);
				if(x1[i] - 1 >= 1)
					rowTochE.add(x1[i] - 1);
				x2[i] = Math.min(n, X[i] + mid);
				if(x2[i] + 1 <= n)
					rowTochB.add(x2[i] + 1);
				y1[i] = Math.max(1, Y[i] - mid);
				if(y1[i] - 1 >= 1)
					colTochE.add(y1[i] - 1);
				y2[i] = Math.min(m, Y[i] + mid);
				if(y2[i] + 1 <= m)
					colTochB.add(y2[i] + 1);
			}
			// xxxxxxxxxxxxxxxx
			int sXE = -1;
			for (int i = 0; i < rowTochB.size(); i++) {
				int r = rowTochB.get(i);
				int fE = 1;
				for (int j = 0; j < k; j++) {
					if(r < x1[ordY[j]] || r > x2[ordY[j]])
						continue;
					if(y1[ordY[j]] > fE)
						break;
					else
						fE = y2[ordY[j]] + 1;
				}

				if(fE <= m) {
					if(sXE == -1)
						sXE = r;
					else
						sXE = Math.min(sXE, r);
				}
			}

			int eXE = -1;
			for (int i = 0; i < rowTochE.size(); i++) {
				int r = rowTochE.get(i);
				int fE = 1;
				for (int j = 0; j < k; j++) {
					if(r < x1[ordY[j]] || r > x2[ordY[j]])
						continue;
					if(y1[ordY[j]] > fE)
						break;
					else
						fE = y2[ordY[j]] + 1;
				}
				if(fE <= m) {
					if(eXE == -1)
						eXE = r;
					else
						eXE = Math.max(eXE, r);
				}
			}


			// yyyyyyyyyyyyyyyyyyyy

			int sYE = -1;
			for (int i = 0; i < colTochB.size(); i++) {
				int c = colTochB.get(i);
				int fE = 1;
				for (int j = 0; j < k; j++) {
					if(c < y1[ordX[j]] || c > y2[ordX[j]])
						continue;
					if(x1[ordX[j]] > fE)
						break;
					else
						fE = x2[ordX[j]] + 1;
				}

				if(fE <= n) {
					if(sYE == -1)
						sYE = c;
					else
						sYE = Math.min(sYE, c);
				}
			}

			int eYE = -1;
			for (int i = 0; i < colTochE.size(); i++) {
				int c = colTochE.get(i);
				int fE = 1;
				for (int j = 0; j < k; j++) {
					if(c < y1[ordX[j]] || c > y2[ordX[j]])
						continue;
					if(x1[ordX[j]] > fE)
						break;
					else
						fE = x2[ordX[j]] + 1;
				}

				if(fE <= n) {
					if(eYE == -1)
						eYE = c;
					else
						eYE = Math.max(eYE, c);
				}
			}
			int need = Math.max((eXE - sXE + 1) / 2, (eYE - sYE + 1) / 2);
			if(need <= mid) {
				hi = mid - 1;
				ans = mid;
			}else
				lo = mid + 1;

		}

		out.println(ans);
		out.flush();
		out.close();
	}
```
