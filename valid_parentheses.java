public class Solution {
    /**
     * @param s A string
     * @return whether the string is a valid parentheses
     */
    public boolean isValidParentheses(String s) {
        if(s.length()==0) return true;
        Stack<Character> left = new Stack<Character>();
        char leftparens [] = {'(', '[', '{'};
        char rightparens[] = {')', ']', '}'};
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            if(c=='('|| c=='['|| c=='{'){
                left.push(c);
            }else{
                if(left.empty()) return false;
                for(int j=0; j<3; j++){
                    if(c==rightparens[j] && left.peek()!=leftparens[j]) return false;
                    if(c==rightparens[j] && left.peek()==leftparens[j]) left.pop();
                }
            }
        }
        return left.empty();
    }
}

