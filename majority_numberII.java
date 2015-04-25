public class Solution {
    /**
     * @param nums: A list of integers
     * @return: The majority number that occurs more than 1/3
     * special case (k=3) of majority number III 
     */
    class Candidate{
        int val;
        int count;
        Candidate(){
            val = 0;
            count = 0;
        }
    }
    public int majorityNumber(ArrayList<Integer> nums) {
        int n = nums.size();
        if(n==0) return 0;
        if(n==1) return nums.get(0);
        Candidate c1 = new Candidate();
        Candidate c2 = new Candidate();
        for(Integer i : nums){
            // if current number i is either c1 or c2, update its count
            if(c1.val==i) c1.count++;
            else if(c2.val==i) c2.count++;
            else{
                // i is neither c1 nor c2, then check if one of them is available to hold it
                if(c1.count==0) {
                    c1.val =i;
                    c1.count = 1;
                }else if(c2.count ==0){
                    c2.val = i;
                    c2.count = 1;
                }else{
                    // c1 and c2 are filled by other numbers
                    // decrease their counts by 1
                    c1.count--;
                    c2.count--;
                }
            }
        }
        // recheck two candidates, and update their counts over original array
        int count = 0;
        for(Integer i : nums){
            if(i == c1.val) count++;
        }
        return (count>n/3)  ? c1.val : c2.val;
    }
}


