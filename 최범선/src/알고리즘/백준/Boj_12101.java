package 알고리즘.백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Boj_12101 {
    static int N;
    static long K, cnt;
    static boolean flag;
    static String rsl;
    static ArrayList<String> list;

    public static void dfs(int idx, String temp){

        if(idx > N) return;
        if(idx == N){
            list.add(new String(temp.substring(0, temp.length() - 1)));
//            System.out.println(temp.substring(0, temp.length() - 1));
//            cnt++;
//            if (cnt == K){
//                flag = true;
//                for (int i = 0; i < temp.length()-1; i++) {
//                    rsl += temp.charAt(i);
//                }
//            }
            return;
        }
        for (int i = 1; i < N; i++) {
            dfs(idx + i, temp + i + "+");
        }

    }
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Long.parseLong(st.nextToken());

        list = new ArrayList<>();

        flag = false;
        rsl = "";
        dfs(0,"");
        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (o1.length() == o2.length()){
                    int min = Math.min(o1.length(), o2.length());
                    for (int i = min - 1; i > -1; i--) {
                        return o1.charAt(i) - o2.charAt(i);
                    }
                }
                return o2.length() - o1.length();
            }
        });

        for (String s : list) {
            System.out.println(s);
        }


//        System.out.println(flag ? rsl : - 1);
    }
}
