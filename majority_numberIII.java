public class Solution {
    /**
     * @param nums: A list of integers
     * @param k: As described
     * @return: The majority number
     * 1. Create a temporary array of size (k-1) to store elements and their counts
     * (The output elements are going to be among these k-1 elements) This step takes O(k) time.
     * 2. Traverse through the input array and update temp[] 
     * (add/remove an element or increase/decrease count) for every traversed element. 
     * The array temp[] stores potential (k-1) candidates at every step. This step takes O(nk) time
     * 3.Iterate through final (k-1) potential candidates (stored in temp[]). 
     * or every element, check if it actually has count more than n/k. This step takes O(nk) time
     */
    class EleCount{
        int ele;
        int count;
        EleCount(){
            ele = 0;
            count = 0;
        }
    }
    public int majorityNumber(ArrayList<Integer> nums, int k) {
        int n = nums.size();
        if(n==0) return 0;
        ArrayList<EleCount> candidates = new ArrayList<EleCount>();
        // initialize !
        for(int i=0; i<k-1; i++){
            candidates.add(new EleCount());
        }
        for(Integer i: nums){
            // if current element i is already in the candidates set, the update count 
            boolean is_candidate = false;
            for(EleCount ec : candidates){
                if(ec.ele == i){
                    is_candidate = true;
                    ec.count++;
                    break;
                }
            }
            if(!is_candidate){
                // if current element is not in the set, check if the set is full
                boolean all_filled = true;
                for(EleCount ec : candidates){
                    if(ec.count==0){
                        all_filled = false;
                        ec.ele = i;
                        ec.count = 1;
                        break; // important!
                    }
                }
                // if the set is fully filled, then decrease every one's count by 1
                if(all_filled){
                    for(EleCount ec: candidates){
                        ec.count--;
                    }
                }
            }
        }
        // check the count of each candidate in the set, over the original array
        for(EleCount ec : candidates){
            int cand = ec.ele;
            int count = 0;
            for(Integer i : nums){
                if(cand==i){
                    count++;
                }
            }
            if(count > n/k) return cand;
        }
        return nums.get(0);
    }
}


