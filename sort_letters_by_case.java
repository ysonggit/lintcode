public class Solution {
    /** 
     *@param chars: The letter array you should sort by Case
     *@return: void
     * similar to partition array: corner case : all lower case or all upper case
     */
    public void sortLetters(char[] chars) {
        int n  = chars.length;
        if(n==0) return;
        int front = 0;
        int back = n-1;
        while(front<back){
            while(front<back && Character.isLowerCase(chars[front])) front++; // be careful: use < here
            while(front<back && Character.isUpperCase(chars[back])) back--;
            if(Character.isUpperCase(chars[front]) && Character.isLowerCase(chars[back])){
                char tmp = chars[front];
                chars[front] = chars[back];
                chars[back] = tmp;
            }
        }
    }
}

