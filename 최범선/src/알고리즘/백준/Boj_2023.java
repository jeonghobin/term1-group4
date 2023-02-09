package 알고리즘.백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj_2023 {
    static int N;
    static StringBuilder sb;
    public static void recursive(int val, int cnt){

        if(!check(val)) return;
        if (cnt == N){
            sb.append(val).append("\n");
            return;
        }
        for (int i = 1; i < 10; i++) {
            if (i == 2 || i == 4 || i == 6 || i == 8) continue;
            recursive(val * 10 + i, cnt + 1);
        }
    }
    public static boolean check(int n){
        if (n==2) return true;
        for (int i = 2; i < (int)Math.sqrt(n) + 1; i++) {
            if (n % i == 0){
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());

        int[] data = {2,3,5,7};
        for (int i = 0; i < 4; i++) {
            recursive(data[i], 1);
        }
        System.out.println(sb);

    }
}


//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringBuilder sb = new StringBuilder();
//        byte N = (byte) Integer.parseInt(br.readLine());
//        br.close();
//        int max = (int)Math.pow(10, N);
//
//        boolean[] data = new boolean[max];
//        data[1] = true;
//        for (int i = 3; i < (int)Math.sqrt(max) + 1; i+=2) {
//            for (int j = i + i; j < max; j += i) {
//                if(data[j]) continue;
//                data[j] = true;
//            }
//        }
//        for (int i = max/10; i < max; i++) {
//            if(!data[i]){
//                int temp = i;
//                boolean flag = true;
//                temp /= 10;
//                while (temp > 0){
//                    if(data[temp]){
//                        flag = false;
//                        break;
//                    }
//                    temp /= 10;
//                }
//                if(flag) sb.append(i).append("\n");
//            }
//        }
//        System.out.println(sb);
//    }
//}
