public class Solution {
    /**
     * @param numbers: Give an array numbers of n integer
     * @param target : An integer
     * @return : return the sum of the three integers, the sum closest target.
     */
    public int threeSumClosest(int[] numbers ,int target) {
        int n = numbers.length;
        // assume n >= 3
        Arrays.sort(numbers); // mistake Collections.sort(numbers);
        int min_diff = Integer.MAX_VALUE;
        int closest = target;
        for(int i=0; i < n; i++){
            int front = i+1;
            int back = n-1;
            while(front<back){
                int sum = numbers[i]+numbers[front]+numbers[back];
                if(sum==target) return target;
                else if(sum<target){
                    front++;
                }else{
                    back--;
                }
                int diff = Math.abs(sum-target);
                if(diff<min_diff){
                    min_diff = diff;
                    closest = sum;
                }
            }
        }
        return closest;
    }
}

