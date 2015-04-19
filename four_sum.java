public class Solution {
    /**
     * @param numbers : Give an array numbersbers of n integer
     * @param target : you need to find four elements that's sum of target
     * @return : Find all unique quadruplets in the array which gives the sum of
     *           zero.
     */
    public ArrayList<ArrayList<Integer>> fourSum(int[] numbers, int target) {     
        int n = numbers.length;
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        if(n<4) return res;
        Arrays.sort(numbers);
        for(int i=0; i<=n-4; i++){
            int a = numbers[i];
            for(int j=i+1; j<=n-3; j++){
                int b = numbers[j];
                int front = j+1;
                int back = n-1;
                while(front < back){
                    int c = numbers[front];
                    int d = numbers[back];
                    int sum = a+b+c+d;
                    if(sum==target){
                        ArrayList<Integer> sol = new ArrayList<Integer>(Arrays.asList(a,b,c,d));
                        res.add(sol);
                        front++;
                        back--;
                        while(front<back && numbers[front]==numbers[front-1]) front++;
                        while(front<back && numbers[back]==numbers[back+1]) back--;
                    }else if(sum<target){
                        front ++;
                    }else{
                        back--;
                    }
                }
                while(j<=n-3 && numbers[j]==numbers[j+1]) j++;
            }
            while(i<=n-4 && numbers[i]==numbers[i+1]) i++;
        }
        return res;
    }
}

