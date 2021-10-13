package DivideAndConquer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_색종이만들기 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine().trim());
        int[][] confetti = new int[N][N];
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine().trim());
            for(int j=0;j<N;j++){
                confetti[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        Divide(confetti, 0, 0, N, N);
        System.out.println(white);
        System.out.println(blue);

    }
    static int white = 0;
    static int blue = 0;
    static void Divide(int[][] confetti,int sR,int sC, int dR,int dC){
        if(checkFull(confetti, sR, sC, dR, dC)) return;
        Divide(confetti, sR, sC, (sR + dR)/2, (sC + dC)/2);
        Divide(confetti, sR, (sC + dC)/2, (sR + dR)/2, dC);
        Divide(confetti, (sR + dR)/2, sC, dR, (sC + dC)/2);
        Divide(confetti, (sR + dR)/2, (sC + dC)/2, dR, dC);
    }
    static boolean checkFull(int[][] confetti, int sR, int sC, int dR, int dC){
        int b = 0;
        int w = 0;
        for(int r = sR; r<dR; r++){
            for(int c = sC; c<dC; c++){
                if(confetti[r][c] == 1) b++;
                if(confetti[r][c] == 0) w++;
            }
        }
        if(b > 0 && w > 0) return false;
        if(b > 0) blue ++;
        else white ++;

        return true;
    }
}
