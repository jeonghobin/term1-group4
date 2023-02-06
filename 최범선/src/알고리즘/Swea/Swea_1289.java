package 알고리즘.Swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import java.util.StringTokenizer;

//public class Swea_1289 {
//
//    static int cnt;
//    static String a;
//
//    public static void main(String[] args) throws Exception {
//
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st;
//        int tc = Integer.parseInt(br.readLine());
//
//        for (int t = 1; t < tc + 1; t++) {
//            StringBuilder sb = new StringBuilder();
//            sb.append("#").append(t).append(" ");
//            a = br.readLine();
//
//            recursive(0, 1);
//
//            sb.append(cnt);
//            cnt = 0;
//            System.out.println(sb);
//        }
//    }
//
//    private static void recursive(int idx , int state) {
//        if (idx >= a.length()) return;
//
//        if (a.charAt(idx) == state + '0' ) {
//            state++;
//            state %= 2;
//            cnt++;
//        }
//        recursive(idx+1, state);
//
//    }
//}



public class Swea_1289 {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int tc = Integer.parseInt(br.readLine());
        char[] data = {'1', '0'};
        for (int i = 1; i < tc + 1; i++) {
            String a = br.readLine();
            int idx = 0, cnt = 0;
            for (int j = 0; j < a.length(); j++) {
                if (a.charAt(j) == data[idx]) {
                    idx++;
                    idx %= 2;
                    cnt++;
                }
            }
            System.out.println("#" + i + " " + cnt);
        }


    }
}