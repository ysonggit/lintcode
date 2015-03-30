public class Solution {
    /**
     * @param numbers : Give an array numbers of n integer
     * @return : Find all unique triplets in the array which gives the sum of zero.
     */
    public ArrayList<ArrayList<Integer>> threeSum(int[] numbers) {
        ArrayList<ArrayList<Integer>  >  res = new ArrayList<ArrayList<Integer> >();
        int n = numbers.length;
        if(n<3) return res;
        Arrays.sort(numbers);
        int i=0; 
        for(; i<n; i++){
            if(i==0 || numbers[i]> numbers[i-1]){
                int target = -numbers[i];
                int front = i+1; 
                int back = n-1;
                while(front < back){
                    if(numbers[front]+numbers[back] == target){
                        res.add(new ArrayList<Integer>(Arrays.asList(-target, numbers[front], numbers[back])));
                        front++;
                        back--;
                        while(front<back && numbers[front] == numbers[front-1]) front++;
                        while(front<back && numbers[back] == numbers[back+1]) back--;
                    }else if(numbers[front]+numbers[back]<target){
                        front++;
                    }else{
                        back--;
                    }
                }
            }
        }
        return res;
    }
}
