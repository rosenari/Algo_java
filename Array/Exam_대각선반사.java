package Array;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 우상향 대각선 반사
 * 우하향 대각선 반사
 */

public class Exam_대각선반사{
    public static void main(String[] args) {
        int R = 5, C = 4, cnt = 0;
        int[][] board = new int[R][C];
        for(int i=0;i<R;i++){
            for(int j=0;j<C;j++){
                board[i][j] = cnt++;
            }
        }
        print(board);
        reflect(board,R,C,1); //우상향
        print(board);
        reflect(board,R,C,-1); //우하향
        print(board);
    }

    static void reflect(int[][] board,int R, int C,int type){
        int N = R - 1 + C - 1 + 1;
        LinkedList<Integer>[] list = new LinkedList[N];
        for(int i=0;i < N ;i++){
            list[i] = new LinkedList<Integer>();
        }
        for(int i=0; i < board.length;i++){
            for(int j =0; j < board[i].length;j++){
                if(type==1) list[i + j].add(board[i][j]);
                else{
                    if(i - j >= 0) list[i - j].add(board[i][j]);
                    else list[N + i - j].add(board[i][j]);
                }
            }
        }
        for(int i=0;i<list.length;i++){
            for(int j=0;j<Math.floor(list[i].size() / 2);j++){
                int a = list[i].get(j);
                int b = list[i].get(list[i].size() - j - 1);
                int tmp = a;
                a = b;
                b = tmp;
                list[i].set(j, a);
                list[i].set(list[i].size() - j - 1, b);
            }
        }
        Queue<Integer>[] queue = list;
        for(int i=0; i < board.length;i++){
            for(int j =0; j < board[i].length;j++){
                if(type==1) board[i][j] = queue[i+j].poll();
                else{
                    if(i -j >=0) board[i][j] = queue[i-j].poll();
                    else board[i][j] = queue[N + i - j].poll();
                }
            }
        }
    }

    static void print(int[][] board){
        for(int i=0;i < board.length; i++){
            for(int j=0;j< board[i].length;j++){
                System.out.print(board[i][j]+"  ");
            }
            System.out.println();
        }
    }
}