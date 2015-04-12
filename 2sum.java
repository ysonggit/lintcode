public class Solution {
    /*
     * @param numbers : An array of Integer
     * @param target : target = numbers[index1] + numbers[index2]
     * @return : [index1 + 1, index2 + 1] (index1 < index2)
     */
    public int[] twoSum(int[] numbers, int target) {
        HashMap<Integer, Integer> hash = new HashMap<Integer, Integer>();
        for(int i=0; i<numbers.length; i++){
            int num = target - numbers[i];
            if(hash.containsKey(num)){
                return new int[]{hash.get(num)+1, i+1};
            }else{
                hash.put(numbers[i], i);
            }
        }
        return new int[]{};
    }
}
