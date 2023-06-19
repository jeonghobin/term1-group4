package 알고리즘.백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Boj_2056 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int[] d = new int[N + 1];

        int a, b, c;
        for (int i = 1; i < N + 1; i++) {
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());

            d[i] = a;
            while (st.hasMoreTokens()){
                c = Integer.parseInt(st.nextToken());
                d[i] = Math.max(d[i], d[c] + a);
            }
        }
//        System.out.println(Arrays.toString(d));
        Arrays.sort(d);
        System.out.println(d[N]);


//        int[] time = new int[N + 1];
//        int[] count = new int[N + 1];
//        int[] d = new int[N + 1];
//        ArrayList<Integer>[] list = new ArrayList[N + 1];
//        Queue<Integer> q = new LinkedList<>();
//
//        for (int i = 0; i < N + 1; i++) {
//            list[i] = new ArrayList<>();
//        }
//        int a, b, c;
//        for (int i = 1; i < N + 1; i++) {
//            st = new StringTokenizer(br.readLine());
//            a = Integer.parseInt(st.nextToken());
//            b = Integer.parseInt(st.nextToken());
//
//            time[i] = a;
//            count[i] += b;
//            while (st.hasMoreTokens()){
//                c = Integer.parseInt(st.nextToken());
//                list[c].add(i);
//            }
//        }
//
//        for (int i = 1; i < N + 1; i++) {
//            if (count[i] == 0){
//                q.add(i);
//                count[i]--;
//                d[i] = time[i];
//            }
//        }
//
//        while (!q.isEmpty()){
//            int t = q.poll();
//            for (int i = 0; i < list[t].size(); i++) {
//                int temp = list[t].get(i);
//                if (d[temp] < d[t] + time[temp]) d[temp] = d[t] + time[temp];
//                if (--count[temp] == 0){
//                    q.add(temp);
//                }
//            }
//        }
//
////        System.out.println(Arrays.toString(d));
//        Arrays.sort(d);
//        System.out.println(d[N]);
    }
}
