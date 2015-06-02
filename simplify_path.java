public class Solution {
    /**
     * @param path the original path
     * @return the simplified path
     */
    public String simplifyPath(String path) {
        if(path.length()==0) return "";
        String [] dirs = path.split("/");
        Deque<String> s = new LinkedList<String>();
        for(String cur : dirs){
            if(cur.equals("")) continue; // mistake: split generates empty strings ""
            else if(cur.equals(".")) continue;
            else if(cur.equals("..")){
                if(s.isEmpty()) return "/";
                else s.removeFirst(); // <==> stack pop
            }else{
                s.addFirst(cur); // <==> stack push
            }
        }
        if(s.isEmpty()) return "/"; // mistake: coner case "/"
        String res ="";
        while(!s.isEmpty()){
            res += "/"+s.pollLast();
        }
        return res;
    }
}
