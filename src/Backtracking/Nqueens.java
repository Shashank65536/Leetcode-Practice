package Backtracking;

import java.util.ArrayList;
import java.util.List;

class Nqueens {
    List<List<String>> res;
    public List<List<String>> solveNQueens(int n) {

        this.res = new ArrayList<>();
        boolean board[][] = new boolean [n][n];
        backtrack(board,0);
        return res;

    }

    private void backtrack(boolean [][]board, int r){

        if(r == board.length){
            List<String>li = new ArrayList<>();
            for(int i =0;i<board.length;i++){
                StringBuilder sb = new StringBuilder();
                for(int j = 0; j< board[0].length;j++){
                    if(board[i][j]){
                        sb.append("Q");
                    }else{
                        sb.append(".");
                    }
                }
                li.add(sb.toString());
            }
            res.add(li);
        }

        for(int c = 0;c<board[0].length; c++){

            if(isSafe(board, r,  c)){
                board[r][c] = true;
                backtrack(board,r+1);
                board[r][c] = false;
            }

        }

    }

    private boolean isSafe(boolean[][] board,int r, int c){

        //checking column
        for(int i = 0;i<r;i++){
            if(board[i][c]){
                return false;
            }
        }

        // checking diagonal left
        int tx = r;
        int ty = c;
        while(tx >= 0 && ty >=0){
            if(board[tx][ty]){
                return false;
            }

            tx--;
            ty--;
        }

        // checking diagonal right
        tx = r; ty = c;
        while(tx >= 0 && ty<board[0].length){
            if(board[tx][ty]){
                return false;
            }
            tx--;
            ty++;
        }
        return true;

    }
}