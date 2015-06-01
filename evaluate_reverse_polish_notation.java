public class Solution {
    /**
     * @param tokens The Reverse Polish Notation
     * @return the value
     * question: 5 - ? // fortunately, no such test case
     */
    public boolean isOperator(String c){
        if(c.equals("+") || c.equals("-") || c.equals("*") || c.equals("/")) return true;
        return false;
    }
    
    public int compute(int op1, int op2, String op){
        if(op.equals("+")) return op1+op2;
        if(op.equals("-")) return op1-op2;
        if(op.equals("*")) return op1*op2;
        return op1/op2;
    }
    
    public int evalRPN(String[] tokens) {
        int n = tokens.length;
        if(n==0) return 0;
        if(n==1) return Integer.valueOf(tokens[0]);
        Stack<Integer> s = new Stack<Integer>();
        for(int i=0; i<n; i++){
            String cur = tokens[i];
            if(!isOperator(cur)){
                s.push(Integer.valueOf(cur));
            }else{
                // pop two operands and compute the result
                // push the result to stack
                if(s.size()<2) return -1;
                int operand2 = s.pop();
                int operand1 = s.pop();
                s.push(compute(operand1, operand2, cur));
            }
        }
        int res = s.pop();
        return res;
    }
}

