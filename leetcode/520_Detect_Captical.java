// 10.10
class Solution {
    public boolean detectCapitalUse(String word) {
        if (word == null || word.length() == 0) 
            return true;
        boolean first = word.charAt(0) - 'a' < 0;
        for (int i = 1; i < word.length(); i++) {
            if (word.charAt(i) - 'a' >= 0 && (i != 1 && word.charAt(i - 1) - 'a' < 0)) 
                return false;
            if (word.charAt(i) - 'a' < 0 && (!first || word.charAt(i - 1) - 'a' >= 0)) 
                return false;
        }
        return true;
    }
}


// count method
public class Solution {
    public boolean detectCapitalUse(String word) {
        int cnt = 0;
        for(char c: word.toCharArray()) if('Z' - c >= 0) cnt++;
        return ((cnt==0 || cnt==word.length()) || (cnt==1 && 'Z' - word.charAt(0)>=0));
    }
}

// reg
public boolean detectCapitalUse(String word) {
    return word.matches("[A-Z]+|[a-z]+|[A-Z][a-z]+");
}

    return word.matches("[A-Z]*|[A-Z]?[a-z]*");
    return word.matches("[A-Z]*|.[a-z]*");
