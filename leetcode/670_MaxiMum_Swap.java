// brute force ugly code


class Solution {
    public int maximumSwap(int num) {
        List<Integer> arr = new ArrayList<>();
        int n = num;
        while (num != 0) {
            arr.add(num % 10);
            num /= 10;
        }
        
        int[] arr2 = new int[arr.size()];        
        for (int i = arr.size() - 1; i >= 0; i--) {
            arr2[arr.size() - 1 - i] = arr.get(i);
        }
        Collections.sort(arr);
        Collections.reverse(arr);
        // for (int i = 0; i < arr.size(); i++) {
        //     System.out.println(arr.get(i));
        //     System.out.println("   > "+arr2[i]);
        // }
        
        int len = arr.size();
        int idx = 0;
        while (idx < len && arr.get(idx) == arr2[idx]) idx++;
        if (idx == len) return n; // sorted already
        
        int tmp = arr2[idx];  // n1
        int largest = arr.get(idx); // n2
        arr2[idx] = largest;
        for (int i = arr.size() - 1; i >=0; i--) {
            if (arr2[i] == largest) {
                idx = i;
                break;
            }
        }
        arr2[idx] = tmp;
        
        int m = 0;
        for (int i = 0; i < arr.size(); i++) {
            m = m * 10 + arr2[i];
        }
        return m;
    }
}




class Solution {
    public int maximumSwap(int num) {
        int maxSeen = 0, maxIdx = -1, power = 0, swapIdx1 = 0, swapIdx2 = 0;
        List<Integer> list = new ArrayList<>();
        while(num > 0){
            int digit = num % 10;
            list.add(digit);
            if(maxSeen > digit){
                swapIdx1 = power;
                swapIdx2 = maxIdx;
            }
            else if(digit > maxSeen){
                maxSeen = digit;
                maxIdx = power;
            }
            num = num/10;
            power++;
        }
        
        Collections.swap(list, swapIdx1, swapIdx2);

        int result = 0;
        for(int i = 0; i < list.size(); i++){
            result += (int)(Math.pow(10, i) * list.get(i));
        }
        return result;
    }
}