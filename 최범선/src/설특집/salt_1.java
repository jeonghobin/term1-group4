package 설특집;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class salt_1 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int[] d = {3, 5, 6};
        int tc = Integer.parseInt(br.readLine());

        for (int t = 1; t < tc + 1; t++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());
            StringBuilder sb = new StringBuilder();
            sb.append("#").append(t).append(" ");
            int[][] data = new int[N][N];
            int rsl = 0;
            for (int i = 1; i < K + 1; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                int dd = Integer.parseInt(st.nextToken());
                if (data[x][y] != 0) {
                    rsl = i;
                    sb.append(rsl);
                    break;
                }
                for (int j = 0; j < 3; j++) {
                    if (dd == 1) {
                        if (x + d[j] < N) {
                            if (data[x + d[j]][y] != 0) {
                                rsl = i;
                                sb.append(rsl);
                                break;
                            }
                            data[x + d[j]][y] = 1;
                        }
                    } else if (dd == 2) {
                        if (y + d[j] < N) {
                            if (data[x][y + d[j]] != 0) {
                                rsl = i;
                                sb.append(rsl);
                                break;
                            }
                            data[x][y + d[j]] = 1;
                        }
                    }
                }
            }
            if(rsl == 0){sb.append(rsl);}
            System.out.println(sb);
        }
    }
}

//        for (int t = 1; t < tc + 1; t++) {
//            st = new StringTokenizer(br.readLine());
//            int N = Integer.parseInt(st.nextToken());
//            int K = Integer.parseInt(st.nextToken());
//            int[][] data = new int[N][N];
//            int[][] dd = new int[N][3];
//            int rsl = 0;
//            for (int i = 0; i < K; i++) {
//                st = new StringTokenizer(br.readLine());
//                dd[i][0] = Integer.parseInt(st.nextToken());
//                dd[i][1] = Integer.parseInt(st.nextToken());
//                dd[i][2] = Integer.parseInt(st.nextToken());
//
//                if (data[dd[i][0]][dd[i][1]] != 0 && rsl == 0){rsl = (i+1);}
//                data[dd[i][0]][dd[i][1]] = 1;
//            }
//            if (rsl <= 0){
//            for (int i = 0; i < K; i++) {
//                if (dd[i][2] == 1){
//                    for (int j = 0; j < 3; j++) {
//                        if (dd[i][0] + d[j] < N){
//                            if (data[dd[i][0] + d[j]][dd[i][1]] != 0){
//                                rsl = (i+1);
//                                break;
//                            }
//                            data[dd[i][0] + d[j]][dd[i][1]] = 1 ;
//                        }
//                    }
//
//                }else if (dd[i][2] == 2){
//                    for (int j = 0; j < 3; j++) {
//                        if (dd[i][1] + d[j] < N){
//                            if (data[dd[i][0]][dd[i][1] + d[j]] != 0){
//                                rsl = (i+1);
//                                break;
//                            }
//                            data[dd[i][0]][dd[i][1] + d[j]] = 1;
//                        }
//                    }
//                }
//                if (rsl > 0){break;}
//            }
//        }
//            System.out.println("#" + t + " " + rsl);
//        }
//    }
//}
