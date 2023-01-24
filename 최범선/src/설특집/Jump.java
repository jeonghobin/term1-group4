package 설특집;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Jump {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int tc = Integer.parseInt(br.readLine());

        for (int t = 1; t < tc+1; t++) {
            st = new StringTokenizer(br.readLine());
            int Y = Integer.parseInt(st.nextToken());
            int X = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());
            int[][] data = new int[Y+1][X+1];
            int[][] player = new int[N][3];
            int money = N * (-1000);

            for (int i = 1; i < Y + 1; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 1; j < X + 1; j++) {
                    data[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                player[i][0] = Integer.parseInt(st.nextToken());
                player[i][1] = Integer.parseInt(st.nextToken());
                player[i][2] = Integer.parseInt(st.nextToken());
            }
            String[] temp = br.readLine().split(" ");
            for (int i = 0; i < Integer.parseInt(temp[0]); i++) {
                data[Integer.parseInt(temp[2 * i + 1])][Integer.parseInt(temp[2 * i + 2])] = - 1;
            }

            for (int i = 0; i < N; i++) {
                int x = player[i][0];
                int y = player[i][1];
                int cnt = player[i][2];
                for (int j = 0; j < cnt; j++) {
                    int position = data[x][y];
                    int d = position / 10;
                    int jump = position % 10;
                    if (d==1){
                        if (y + jump >= (X+1) || data[x][y+jump] == -1){
                            break;
                        }else{y += jump;}
                    }else if(d==2){
                        if (x + jump >= (X+1) || data[x+jump][y] == -1){
                            break;
                        }else{x += jump;}
                    }else if(d==3){
                        if (y - jump < 1 || data[x][y-jump] == -1){
                            break;
                        }else{y -= jump;}
                    }else if(d==4){
                        if (x - jump < 1 || data[x-jump][y] == -1){
                            break;
                        }else{x -= jump;}
                    }
                    if (j == (cnt-1)){
                        money += data[x][y] * 100;
                    }
                }
            }
            System.out.println("#" + t + " " + money);
        }
    }
}
