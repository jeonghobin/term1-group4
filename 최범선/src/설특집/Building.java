package 설특집;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Building {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int[] dx = {0, 1, 0, -1, -1, -1, 1,1};
        int[] dy = {1, 0, -1, 0, -1, 1, -1, 1};

        int tc = Integer.parseInt(br.readLine().trim());
        for (int t = 1; t < tc + 1; t++) {
            int N = Integer.parseInt(br.readLine().trim());
            String[][] data = new String[N][N];

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine().trim());
                for (int j = 0; j < N; j++) {
                    data[i][j] = st.nextToken();
                }
            }
            int max = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (data[i][j].equals("B")) {
                        int state = 1, cnt = 0;
                        for (int k = 0; k < 8; k++) {
                            int nx = i + dx[k];
                            int ny = j + dy[k];
                            if (nx >= 0 && nx < N && ny >=0 && ny < N && data[nx][ny].equals("G")) {
                                cnt = 2;
                                state = 0;
                                break;
                            }
                        }
                        if (state == 1) {
                            for (int k = 0; k < N; k++) {
                                if (data[i][k].equals("B")) cnt++;
                                if (data[k][j].equals("B")) cnt++;
                            }
                            cnt--;
                        }
                        max = Math.max(max, cnt);
                    }
                }
            }
            System.out.println("#" + t + " " + max);
        }

    }
}
