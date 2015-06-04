public class Solution {
    /**
     * @param string: An array of Char
     * @param length: The true length of the string
     * @return: The true length of new string
     * cc150 two passes, build result from right to left to preserve un-dealed chars
     */
    public int replaceBlank(char[] string, int length) {
        int spaces = 0;
        for(int i=0; i<length; i++){
            if(string[i]==' ') spaces++;
        }
        if(spaces==0) return length;
        int new_length = length + 2* spaces;
        int j= new_length-1;
        for(int i=length-1; i>=0; i--){
            if(string[i] != ' '){
                string[j] = string[i];
                j--;
            }else{
                string[j] = '0';
                string[j-1] = '2';
                string[j-2] = '%';
                j=j-3;
            }
        }
        return new_length;
    }
}
