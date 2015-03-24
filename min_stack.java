public class Solution {
    private Stack<Integer> allnums = new Stack<Integer>();
    private Stack<Integer> mins = new Stack<Integer>();
    
    public Solution() {
        // do initialize if necessary
    }

    public void push(int number) {
        allnums.push(number);
        if(mins.empty()) {
            mins.push(number);
        }else{
            if(number <= mins.peek()) mins.push(number);
        }
    }

    public int pop() {
        if(allnums.empty() ) return -1;
        int popped = allnums.peek();
        if(mins.peek() == popped){
            mins.pop();
        }
        return allnums.pop();
    }

    public int min() {
        return mins.peek();
    }
}
