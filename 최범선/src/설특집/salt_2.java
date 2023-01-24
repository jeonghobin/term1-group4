package 설특집;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class salt_2 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int tc = Integer.parseInt(br.readLine());
        for (int t = 1; t < tc + 1; t++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());
            int[][] data = new int[N][N];
            int d[] = {3,5,6};
            int rsl = K;
            int cnt = 0;
            //(상:1, 하:2, 좌:3, 우:4)
            for (int i = 1; i < K+1; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                int dd = Integer.parseInt(st.nextToken());
                if (data[x][y] != 0){
                    rsl--;
                }
                else{
                    for (int j = 0; j < 3; j++) {
                        if (dd == 1){
                            if (x - d[j] >= 0){
                                if (data[x-d[j]][y] != 0){
                                    rsl--;
                                    break;
                                }
                                if (j == 2){data[x-d[j]][y] = 1;}
                            }else{
                                rsl--;
                                break;
                            }
                        }else if(dd == 2){
                            if(x + d[j] < N){
                                if (data[x+d[j]][y] != 0){
                                    rsl--;
                                    break;
                                }
                                if (j == 2){data[x+d[j]][y] = 1;}
                            }else{
                                rsl--;
                                break;
                            }
                        }else if(dd == 3){
                            if(y - d[j] >= 0){
                                if (data[x][y-d[j]] != 0){
                                    rsl--;
                                    break;
                                }
                                if (j == 2){data[x][y-d[j]] = 1;}
                            }else{
                                rsl--;
                                break;
                            }
                        }else if(dd == 4){
                            if(y + d[j] < N){
                                if (data[x][y+d[j]] != 0){
                                    rsl--;
                                    break;
                                }
                                if (j == 2){data[x][y+d[j]] = 1;}
                            }else{
                                rsl--;
                                break;
                            }
                        }
                    }
                }
            }
            System.out.println("#" + t + " " + rsl);
        }
    }
}
