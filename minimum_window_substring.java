public class Solution {
    /**
     * @param source: A string
     * @param target: A string
     * @return: A string denote the minimum window
     *          Return "" if there is no such a string
     */
    public String minWindow(String source, String target) {
        int n = source.length();
        if(n==0) return "";
        int target_dict [] = new int[256];
        int source_dict [] = new int[256];
        int m = target.length();
        for(int i=0; i<m; i++){
            int char_idx = (int) target.charAt(i);
            target_dict[char_idx]++;
        }
        int i = 0;
        int start_of_min_window= -1;
        int end_of_min_window = n;
        int start = 0;
        int min_len = n+1;
        int count = 0;
        while(i<n){
            int char_idx = (int) source.charAt(i);
            if(target_dict[char_idx] >0){
                source_dict[char_idx]++;
                if(source_dict[char_idx] <= target_dict[char_idx]) { // mistake : don't use < 
                    count++;
                }
                while(count==m){
                    // pass by if start does point to a char that does belong to target string
                    char s = source.charAt(start);
                    if(target_dict[(int)s]==0){
                        start++;
                    }else{
                        if(source_dict[(int)s]>target_dict[(int)s]){
                            start++;
                            source_dict[(int)s]--;
                        }else{
                            if(min_len>= i-start+1){
                                min_len = i-start+1;
                                start_of_min_window = start;
                                end_of_min_window = i+1;
                            }
                            break;// mistake donot put break in if body
                        }
                    }
                }
            }
            i++;
        }
        if(start_of_min_window<0) return "";
        return source.substring(start_of_min_window, end_of_min_window);
    }
}

