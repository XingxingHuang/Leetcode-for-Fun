// O(n) O(n)
// These two lines are used to track previous consecutive sequences next elements' values. 
// If current element can be next element of one of previous consecutive sequences, 
// it means we can append it to that sequence. 
// We don't need to worry about whether we can use this element to be a new start point of a new consecutive sequence, 
// that's because even though the current element can be a new start point of a consecutive sequence, 
// we can simply append those consecutive elements following this current element at the end of the previous consecutive sequence.

public boolean isPossible(int[] nums) {
    Map<Integer, Integer> freq = new HashMap<>(), appendfreq = new HashMap<>();
    for (int i : nums) freq.put(i, freq.getOrDefault(i,0)+1);
    for (int i : nums) {
        if (freq.get(i) == 0) continue;
        else if (appendfreq.getOrDefault(i,0) > 0) {
            appendfreq.put(i, appendfreq.get(i)-1);
            appendfreq.put(i+1, appendfreq.getOrDefault(i+1,0)+1);
        }   
        else if (freq.getOrDefault(i+1,0) > 0 && freq.getOrDefault(i+2,0) > 0) {
            freq.put(i+1, freq.get(i+1) - 1);
            freq.put(i+2, freq.get(i+2) - 1);
            appendfreq.put(i+3, appendfreq.getOrDefault(i+3,0) + 1);
        }
        else return false;
        freq.put(i, freq.get(i) - 1);
    }
    return true;
}cd