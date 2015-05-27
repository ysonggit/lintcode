public class Solution {
    /**
     * @param s A string
     * @return Whether the string is a valid palindrome
     */
    public boolean isPalindrome(String s) {
        s = s.trim();
        int n = s.length();
        if(n<2) return true;
        int front = 0, back = n-1; 
        while(front<back){
            if(front<back && !Character.isLetterOrDigit(s.charAt(front))) front++; // using isLetter is not enough
            if(front<back && !Character.isLetterOrDigit(s.charAt(back))) back--;
            if(Character.toLowerCase(s.charAt(front)) != Character.toLowerCase(s.charAt(back))) return false;
            front++;
            back--;
        }
        return true;
    }
}
