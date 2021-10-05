import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.IOException;

public class Main_치즈 {
    static int R,C;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine().trim());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        int[][] map = new int[R][C];
        boolean[][] v = new boolean[R][C];
        for(int i = 0; i < R; i++){
            st = new StringTokenizer(br.readLine().trim());
            for(int j = 0;j < C; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int hour = 0;
        int deleteCount = Integer.MAX_VALUE;
        int beforeCount = 0;
        while((deleteCount = DFS(0,0,map,v)) > 0){
            hour++;
            beforeCount = deleteCount;
            for(int i=0;i<v.length;i++) Arrays.fill(v[i], false);
        }
        System.out.println(hour);
        System.out.println(beforeCount);        
    }

    static int[] dr = {-1,0,1,0};
    static int[] dc = {0,1,0,-1};
    static int DFS(int r, int c, int[][] map, boolean[][] v){
        int count = 0;
        v[r][c] = true;
        if(map[r][c] == 1) {
            map[r][c] = 0;
            return 1;
        }
        
        for(int i=0;i<dr.length;i++){
            int nr = r + dr[i];
            int nc = c + dc[i];
            if(nr >= 0 && nc >= 0 && nr < map.length && nc < map[0].length && !v[nr][nc]){
                count += DFS(nr,nc,map,v);
            }
        }

        return count;
    }
}
