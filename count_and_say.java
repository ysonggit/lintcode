public class Solution {
    /**
     * @param n the nth
     * @return the nth sequence
     */
    
    public String getNext(String cur){
        int n = cur.length();
        StringBuilder next = new StringBuilder();
        int i=0;
        while( i<n){
            int count = 1;
            int j = i+1;
            while(j<n && cur.charAt(j) == cur.charAt(i)){
                j++;
                count++;
            }
            next.append((char) (count+(int)'0'));
            next.append(cur.charAt(i));
            i = j;
        }
        return next.toString();
    }
    
    public String countAndSay(int n) {
        if(n==0) return "";
        String say= "1";
        if(n==1) return say;
        for(int i=2; i<=n; i++){
            say = getNext(say);
        }
        return say;
    }
}
