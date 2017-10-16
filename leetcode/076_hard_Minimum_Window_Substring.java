// 10.15  must practice two pointer
class Solution {
    public String minWindow(String source, String target) {
        HashMap<Character, Integer> map = new HashMap<>();
        int countT = target.length();
        for(int i = 0; i < target.length(); i++){
            char c = target.charAt(i);
            if(map.containsKey(c)){
                map.put(c, map.get(c) + 1);
            }else{
                map.put(c, 1);
            }
        }

        int j = 0; 
        int countS = 0;
        int min = Integer.MAX_VALUE;
        String result  = "";
        for(int i = 0;  i < source.length(); i++){
            // find the match
            while(j < source.length() && countS < countT){
                char c = source.charAt(j);
                if(map.containsKey(c)){
                   if( map.get(c) > 0) countS++;
                    map.put(c, map.get(c) - 1);
                }
                j++;
            }
            // calculate the result
            if(countS >= countT){
                if(j - i < min){
                    result = source.substring(i, j);
                    min = j - i;
                }  
            }
            // move lower point
            char cc = source.charAt(i);
            if(map.containsKey(cc)){
                if(map.get(cc) >= 0){
                    countS--; 
                }
                map.put(cc, map.get(cc) + 1);
            }
        }
        return result;
    }
}
