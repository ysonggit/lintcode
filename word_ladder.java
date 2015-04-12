public class Solution {
    /**
      * @param start, a string
      * @param end, a string
      * @param dict, a set of string
      * @return an integer
      * Level order /BFS 
      */
    public int ladderLength(String start, String end, Set<String> dict) {
        Queue<String> Q = new LinkedList<String>();
        Q.add(start);
        HashSet<String> visited = new HashSet<String>();
        visited.add(start);
        int len = 1;
        int curr_level = 1;
        int next_level = 0;
        while(!Q.isEmpty()){
            StringBuilder word = new StringBuilder(Q.peek());
            Q.remove();
            curr_level--;
            for(int i=0; i<word.length(); i++){
                char origin = word.charAt(i);
                for(char c='a'; c<='z'; c++){
                    word.setCharAt(i, c);
                    if(!visited.contains(word.toString())){
                        if(word.toString().equals(end)) return len+1;
                        if(dict.contains(word.toString())){
                            next_level++;
                            Q.add(word.toString());
                            visited.add(word.toString());
                        }
                    }
                    word.setCharAt(i, origin);
                }
            }
            if(curr_level==0){
                curr_level = next_level;
                next_level = 0;
                len++;
            }
        }
        return 0;
    }
}

