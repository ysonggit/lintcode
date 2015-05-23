public class Solution {
    /**
     * @param s input string
     * @return the longest palindromic substring
     * Manacher Algorithm
     * http://articles.leetcode.com/2011/11/longest-palindromic-substring-part-ii.html
     */
    // given string abcd returns ^|a|b|c|d|$
    public String preProcess(String s){
        int n = s.length();
        char res [] = new char[2*n+1+2];
        res[0] = '^';
        res[2*n+2] = '$'; 
        for(int i=1; i<2*n+2; i++){
            int j = i/2-1;
            res[i] = (i%2==1) ? '|' : s.charAt(j);
        }
        return new String(res);
    }
    public String longestPalindrome(String s) {
        if(s.length()<2) return s;
        String t = preProcess(s);
        int n  = t.length();
        int LPS [] = new int [n];
        // LPS[i] = m means :
        // the length of the palindrome substring centered at position i is m
        // .. [left_pos] .. j .. [center_pos] .. i .. [right_pos] ...
        int center_pos =0;
        int right_pos =0;
        // for i, the mirror position based on the center_pos j = center_pos - (i-center_pos)
        for(int i=1; i<n-1; i++){
            int j = center_pos - (i - center_pos); // compute the mirror pos of current pos i
            // key : compute LPS array
            LPS[i] = (right_pos > i) ? Math.min(right_pos-i, LPS[j]): 0;
            // expand palindromme subtring centered at pos i
            while(t.charAt(i+1+LPS[i]) == t.charAt(i-1-LPS[i])) LPS[i]++;
            // if the end pos of the expanded substring exceeds the right_pos
            // update center_pos and right_pos
            if(i+LPS[i]>right_pos){
                center_pos = i;
                right_pos = i+ LPS[i];
            }
        }
        // iterator LPS array to find the max len substring
        int max_len = 1;
        int max_substr_center = 2;
        for(int i=1; i<n-1; i++){
            if(LPS[i]>max_len){
                max_len = LPS[i];
                max_substr_center = i;
            }
        }
        int start = max_substr_center - max_len + 1;
        StringBuilder res = new StringBuilder();
        while(res.length() < max_len){
            if(t.charAt(start)!='|') { 
                res.append(t.charAt(start));
            }
            start++;
        }
        return res.toString();
    }
}

