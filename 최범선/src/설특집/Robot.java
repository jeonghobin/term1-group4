package 설특집;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Robot {
    /*
    A : 우 , B : 좌우 C : 상하좌우
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int tc = Integer.parseInt(br.readLine().trim());

        int[] dx = {0,0,-1,1};
        int[] dy = {1,-1,0,0};

        for (int t = 1; t < tc + 1; t++) {
            int N = Integer.parseInt(br.readLine().trim());
            int[][] data = new int[N][N];

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine().trim());
                for (int j = 0; j < N; j++) {
                    String temp = st.nextToken();
                    if (temp.equals("S")) data[i][j] = 0;
                    else if (temp.equals("W")) data[i][j] = -1;
                    else if (temp.equals("A")) data[i][j] = 1;
                    else if (temp.equals("B")) data[i][j] = 2;
                    else if (temp.equals("C")) data[i][j] = 3;
                }
            }
            int count = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (data[i][j] == 1){
                        int x = i+dx[0], y = j +dy[0];
                        while (y < N && data[x][y] == 0){
                            count++;
                            y += dy[0];
                        }
                    }else if(data[i][j] == 2){
                        for (int k = 0; k < 2; k++) {
                            int x = i + dx[k], y = j + dy[k];
                            while (y >=0 && y < N && data[x][y] == 0){
                                count++;
                                y += dy[k];
                            }
                        }
                    }else if(data[i][j] == 3){
                        for (int k = 0; k < 4; k++) {
                            int x = i + dx[k], y = j + dy[k];
                            while ( x >= 0 && x < N && y >= 0 && y < N && data[x][y] == 0){
                                count++;
                                x += dx[k];
                                y += dy[k];
                            }
                        }
                    }
                }
            }
            System.out.println("#" + t + " " + count);
        }
    }
}
