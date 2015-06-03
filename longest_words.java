class Solution {
    /**
     * @param dictionary: an array of strings
     * @return: an arraylist of strings
     * hashmap : key is word length, value is a list of words of this length
     * only maintains the entry with the longest word length so far
     */
    ArrayList<String> longestWords(String[] dictionary) {
        ArrayList<String> res = new ArrayList<String>();
        int n = dictionary.length;
        if(n==0) return res;
        HashMap<Integer, ArrayList<String>> map = new HashMap<Integer, ArrayList<String>>();
        for(String word : dictionary){
            int len = word.length();
            if(map.size()==0){
                map.put(len, new ArrayList<String>());
                map.get(len).add(word);
            }else{
                int saved_len = map.entrySet().iterator().next().getKey();
                if(len < saved_len) continue; 
                else if (len == saved_len){
                    map.get(len).add(word);
                }else{
                    map.clear();
                    map.put(len, new ArrayList<String>());
                    map.get(len).add(word);
                }
            }
        }
        return map.entrySet().iterator().next().getValue();
    }
};

