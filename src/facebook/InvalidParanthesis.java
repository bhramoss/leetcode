package facebook;

import java.util.ArrayList;
import java.util.List;

public class InvalidParanthesis {

    public List<String> removeInvalidParentheses(String s) {
        
        List<String> ans = new ArrayList<String>();
        char[] paran = new char[]{'(', ')'};
        remove(ans, s, paran, 0, 0);
        return ans;
    }
    
    private void remove(List<String> ans, String s, char[] paran, int last_i, int last_j){
        
        for(int stack = 0,i = last_i; i < s.length(); ++i){
            if(s.charAt(i) == paran[0]) stack++;
            if(s.charAt(i) == paran[1]) stack--;
            if(stack >= 0) continue;
                for(int j = last_j; j <= i; ++j){
                    if((s.charAt(j) == paran[1]) && (( j == last_j ) || (s.charAt(j) != paran[1]))){
                        remove(ans, s.substring(0,j) + s.substring(j+1, s.length()), paran, i, j);
                        return;
                    }
                }
        }
        String reversed = new StringBuilder(s).reverse().toString();
        if(paran[0] == '('){
            remove(ans, reversed, new char[]{')', '('}, 0,0);
        }else{
            ans.add(reversed);
        }
    }

	
	public static void main(String[] args){
		InvalidParanthesis obj = new InvalidParanthesis();
		String paran = "()))";
		System.out.println(obj.removeInvalidParentheses(paran));
	}
}
