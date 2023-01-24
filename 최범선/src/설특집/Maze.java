package 설특집;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Maze {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int tc = Integer.parseInt(br.readLine());
        for (int t = 1; t < tc + 1; t++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int cnt = Integer.parseInt(st.nextToken());

            int[][] data = new int[N+1][N+1];

            String[] temp = br.readLine().split(" ");
            for (int i = 0; i < temp.length; i += 2) {
                data[Integer.parseInt(temp[i])][Integer.parseInt(temp[i+1])] = 1;
            }
            int k = Integer.parseInt(br.readLine());
            int[][] move = new int[k][2];
            temp = br.readLine().split(" ");
            for (int i = 0; i < k; i++) {
                move[i][0] = Integer.parseInt(temp[2 * i]);
                move[i][1] = Integer.parseInt(temp[2 * i + 1]);
            }
            for (int i = 0; i < k; i++) {
                int dd = move[i][0];
                int count = move[i][1];
                for (int j = 1; j < count + 1; j++) {
                    if ( dd == 1){
                        if ( x - j < 1 || data[x - j][y] == 1){
                            x = 0;
                            y = 0;
                            break;
                        }else{
                            if (j == count){
                                x -= count;
                            }
                        }
                    }else if( dd == 2){
                        if ( y + j > N || data[x][y + j] == 1){
                            x = 0;
                            y = 0;
                            break;
                        }else{
                            if (j == count){
                                y += count;
                            }
                        }
                    }else if( dd == 3){
                        if ( x + j > N || data[x + j][y] == 1){
                            x = 0;
                            y = 0;
                            break;
                        }else{
                            if (j == count){
                            x += count;
                            }
                        }
                    }else if( dd == 4){
                        if ( y - j < 1 || data[x][y - j] == 1){
                            x = 0;
                            y = 0;
                            break;
                        }else{
                            if(j == count) {
                                y -= count;
                            }
                        }
                    }
                }
                if ( x == 0 && y == 0){break;}
            }
            System.out.println("#" + t + " " + x + " " + y);
        }
    }
}
