public class Solution {
    /**
     * @param strs: A list of strings
     * @return: A list of strings
     */
    public List<String> anagrams(String[] strs) {
        HashMap<String, ArrayList<String> > hash = new HashMap<String, ArrayList<String> >();
        List<String> res = new ArrayList<String>();
        for(int i=0; i<strs.length; i++){
            String s = strs[i];
            char [] s_chars = s.toCharArray();
            Arrays.sort(s_chars);
            String sorted_s = new String(s_chars);
            if(hash.containsKey(sorted_s) ){
                hash.get(sorted_s).add(s);
            }else{
                ArrayList<String> nl = new ArrayList<String>();
                nl.add(s);
                hash.put(sorted_s, nl);
            }
        }
        for(ArrayList<String> l : hash.values()){
            if(l.size()>1) res.addAll(l);
        }
        return res;
    }
}
