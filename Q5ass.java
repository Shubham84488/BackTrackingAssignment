import java.util.ArrayList;
import java.util.List;

// First store all the combinations of Nqueens in an Answer list and then just take the size of list and that is answer

public class Q5ass {

    public static void solution(char board[][],List<List<String>> ans,int n,int row){
        if(row==n){
            ans.add(toString(board));
            return;
        }
        for(int i=0;i<n;i++){
            if(board[row][i]=='.'){
                if(isValid(board,row,i)){
                    board[row][i] = 'Q';
                    solution(board, ans, n, row+1);
                    board[row][i] = '.'; 
                }
            }
        }
    }

    public static boolean isValid(char board[][],int row,int col){
        for(int i=0;i<board.length;i++){
            if(board[i][col]=='Q'){
                return false;
            }
        }

        // Check the upper-left diagonal
        for (int i = row, j = col; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }

        // Check the upper-right diagonal
        for (int i = row, j = col; i >= 0 && j < board.length; i--, j++) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }
        return true;
    }

    public static List<String> toString(char[][] st){
        List<String> l1 = new ArrayList<>();
        for(int i=0;i<st.length;i++){
            String s = new String(st[i]);
            l1.add(s);
        }
        return l1;
    }

    public static List<List<String>> NQueens(char[][] s,int n){
        List<List<String>> ans= new ArrayList<>();
        solution(s,ans,n,0);
        return ans;
    }

    public static void main(String[] args) {
        int n=5;
        char[][] s=new char[n][n];
        for (int i=0;i<n;i++) {
            for(int j=0;j<n;j++){
                s[i][j]='.';
            }
        }
        List<List<String>> res=NQueens(s,n);
        System.out.println(res);
        System.out.println(res.size());
    }
}
