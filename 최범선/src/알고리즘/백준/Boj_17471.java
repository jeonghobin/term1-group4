package 알고리즘.백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Boj_17471 {
    static int N, min, cnt, ccnt;
    static int[] people;
    static boolean[] v;
    static boolean flag;
    static ArrayList<Integer>[] list;

    public static void recursive(int idx){

        if(idx > N){
            int index = -1, cnt = 0;
            int a = 0, b = 0;
            for (int i = 1; i < N + 1; i++) {
                if(!v[i]){
                    index = i;
                    cnt++;
                }else{
                    a = i;
                    b++;
                }
            }
            if(check(0,index, cnt) && check(1, a, b)){
//                ccnt++;
                flag = true;
                int cnt1 = 0, cnt2 = 0;
                for (int i = 1; i < N + 1; i++) {
                    if (v[i]) cnt1 += people[i];
                    else cnt2 += people[i];
                }
//                System.out.println(Arrays.toString(v));
                min = Math.min(min, Math.abs(cnt1 - cnt2));
//                System.out.println(cnt1 + " " + cnt2 + " " + min);
            }
            return;
        }

        v[idx] = true;
        recursive(idx + 1);
        v[idx] = false;
        recursive(idx + 1);
    }

    public static boolean check(int d, int idx, int cnt){
        if(idx == -1 || cnt == N) return false;
        boolean[] vv = new boolean[N + 1];
        if(d == 0) vv = Arrays.copyOf(v, v.length);
        else{
            for (int i = 1; i < N + 1; i++) {
                if(!v[i]) vv[i] = true;
            }
        }
        Queue<Integer> q = new LinkedList<>();
        q.add(idx);
        vv[idx] = true;
        int count = 1;
        while (!q.isEmpty()){
            int t = q.poll();
            for (int i = 0; i < list[t].size(); i++) {
                if(!vv[list[t].get(i)]) {
                    vv[list[t].get(i)] = true;
                    q.add(list[t].get(i));
                    count++;
                }
            }
        }
        return cnt == count;
    }


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        people = new int[N + 1];
        for (int i = 1; i < N + 1; i++) people[i] = Integer.parseInt(st.nextToken());

        list = new ArrayList[N + 1];
        for (int i = 0; i < N + 1; i++) list[i] = new ArrayList<>();

        for (int i = 1; i < N + 1; i++) {
            st = new StringTokenizer(br.readLine());
            String a = st.nextToken();
            while (st.hasMoreTokens()){
                list[i].add(Integer.parseInt(st.nextToken()));
            }
        }
        min = Integer.MAX_VALUE;
        flag = false;
        v = new boolean[N + 1];
        recursive(1);

        System.out.println(flag ? min : -1);
//        System.out.println(ccnt);
    }
}


//DFS로 첫부분 나누면 반례가 있다 ~,~

//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.*;
//
//public class Boj_17471 {
//    static int N, min, ccnt;
//    static int[] people;
//    static boolean[] v;
//    static boolean flag;
//    static ArrayList<Integer>[] list;
//
//    public static void dfs(int idx){
//        int index = -1, cnt = 0;
//        for (int i = 1; i < N + 1; i++) {
//            if(!v[i]){
//                index = i;
//                cnt++;
//            }
//        }
//        if(check(index, cnt)) {
//            ccnt++;
//            flag = true;
//            int cnt1 = 0, cnt2 = 0;
//            for (int i = 1; i < N + 1; i++) {
//                if(v[i]) cnt1 += people[i];
//                else cnt2 += people[i];
//            }
//            System.out.println(cnt1 + " " +cnt2);
//            min = Math.min(min, Math.abs(cnt1 - cnt2));
//        }
//
//        for (int i = 0; i < list[idx].size(); i++) {
//            int t = list[idx].get(i);
//            if(!v[t]) {
//                v[t] = true;
//                dfs(t);
//                v[t] = false;
//            }
//        }
//    }
//    public static boolean check(int idx, int cnt){
//        if(idx == -1) return false;
//        boolean[] vv = Arrays.copyOf(v, v.length);
//        Queue<Integer> q = new LinkedList<>();
//        q.add(idx);
//        vv[idx] = true;
//        int count = 1;
//        while (!q.isEmpty()){
//            int t = q.poll();
//            for (int i = 0; i < list[t].size(); i++) {
//                if(!vv[list[t].get(i)]) {
//                    vv[list[t].get(i)] = true;
//                    q.add(list[t].get(i));
//                    count++;
//                }
//            }
//        }
//        return cnt == count;
//    }
//
//
//    public static void main(String[] args) throws IOException {
//
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());
//
//        N = Integer.parseInt(st.nextToken());
//        st = new StringTokenizer(br.readLine());
//        people = new int[N + 1];
//        for (int i = 1; i < N + 1; i++) people[i] = Integer.parseInt(st.nextToken());
//
//        list = new ArrayList[N + 1];
//        for (int i = 0; i < N + 1; i++) list[i] = new ArrayList<>();
//
//        for (int i = 1; i < N + 1; i++) {
//            st = new StringTokenizer(br.readLine());
//            String a = st.nextToken();
//            while (st.hasMoreTokens()){
//                list[i].add(Integer.parseInt(st.nextToken()));
//            }
//        }
//        min = Integer.MAX_VALUE;
//        flag = false;
//        v = new boolean[N + 1];
//        for (int i = 1; i < N + 1; i++) {
//            v[i] = true;
//            dfs(i);
//            v[i] = false;
//        }
//
//        System.out.println(ccnt);
//        System.out.println(flag ? min : -1);
//
//    }
//}
