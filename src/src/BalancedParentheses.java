import java.util.Scanner;
import java.util.Stack;

public class BalancedParentheses {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.next();
        char[] res = new char[line.length()];
        int openP = 0;
        int closeP = 0;

        for (int i = 0; i < line.length(); i++) {
        // the moment the number of closing parentheses become larger than opening parentheses our set becomes unbalanced
            if (closeP > openP)
                break;
            if (line.charAt(i) == '('){
                res[i] = '(';
                openP++;
            }else{
                res[i] = ')';
                closeP++;
            }
        }
        // there is another way our set becomes unbalanced
        // when the number of opening parentheses at the end of line is not equal to closing ones
        // so we try and delete "(" and ")" until number of closing and opening parentheses becomes equal
        for (int j = openP + closeP -1; closeP!=openP; j--){
            if (res[j] == '('){
                res[j] = '\0';
                openP--;
            }else{
                res[j] = '\0';
                closeP--;
            }
        }
        for (int j = 0; j < openP + closeP; j++){
            System.out.print(res[j]);
        }
    }
}
