// Binary search
public class Solution {
    public List<Integer> findClosestElements(List<Integer> arr, int k, int x) {
        List<Integer> res = new ArrayList<Integer>();
        int idx = binarySearch(arr, x, 0, arr.size() - 1);
        res.add(arr.get(idx));
        int count = 1;
        int i = idx + 1;
        int j = idx - 1;
        while (count < k) {
            // System.out.println(i + " "+ j);
            if (j < 0 || (i < arr.size() && (arr.get(i) - x) < (x - arr.get(j))))  {
                res.add(arr.get(i));
                count++;
                i++;
            } else if (i >= arr.size() || (arr.get(i) - x) >= (x - arr.get(j))) {
                res.add(arr.get(j));
                count++;
                j--;
            }
        }
        Collections.sort(res);
        return res;
    }
    private int binarySearch(List<Integer> arr, int x, int m, int n) {
        while (m + 1 < n) {
            int mid = m + (n - m)/2;
            if (arr.get(mid) == x) {
                return mid;
            } else if (arr.get(mid) > x) {
                n = mid;
            } else {
                m = mid;
            }
        }
        if (arr.get(m) - x > arr.get(n) -x) {
            return n;
        } else {
            return m;
        }
    }
}

// straight forward and easy solution. More time. O(nlogn)
public List<Integer> findClosestElements(List<Integer> arr, int k, int x) {
     Collections.sort(arr, (a,b) -> a == b ? a - b : Math.abs(a-x) - Math.abs(b-x));
     arr = arr.subList(0, k);
     Collections.sort(arr);
     return arr;
}

// O(n)
public List<Integer> findClosestElements(List<Integer> arr, int k, int x) {
    List<Integer> less = new ArrayList<>(), greater = new ArrayList<>(),
                  lessResult = new LinkedList<>(), greaterResult = new LinkedList<>();
 
    for (Integer i : arr) {
        if (i <= x) less.add(i);
        else greater.add(i);
    }
    
    Collections.reverse(less);
    int  i = 0, j = 0, n = less.size(), m = greater.size();
    for (int size=0;size<k;size++) {
        if (i < n && j < m) {
            if (Math.abs(less.get(i) - x) <= Math.abs(greater.get(j) - x)) lessResult.add(less.get(i++));
            else greaterResult.add(greater.get(j++));
        }
        else if (i < n) lessResult.add(less.get(i++));
        else greaterResult.add(greater.get(j++));
    }

    Collections.reverse(lessResult);
    lessResult.addAll(greaterResult);
    return lessResult;
}