package 알고리즘.백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Boj_12891 {

    static Map<Character, Integer> m;
    static int count;

    public static void check(){
        boolean flag = true;
        for (Character key : m.keySet()){
            if(m.get(key) < 0){
                flag = false;
                break;
            }
        }
        if (flag) count++;
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        char[] t = {'A', 'C', 'G', 'T'};
        int S = Integer.parseInt(st.nextToken()); // 문자열 길이
        int P = Integer.parseInt(st.nextToken()); // 부분 문자열 길이

        String a = br.readLine();
        st = new StringTokenizer(br.readLine());
        m = new HashMap<>();
        for (int i = 0; i < 4; i++) {
            m.put(t[i], -Integer.parseInt(st.nextToken()));
        }
        for (int i = 0; i < P; i++) {
            m.put(a.charAt(i), m.get(a.charAt(i)) + 1);
        }
        check();

        for (int i = P; i < a.length() ; i++) {
            char before = a.charAt(i - P);
            char after = a.charAt(i);
            m.put(before, m.get(before) - 1);
            m.put(after, m.get(after) + 1);
            check();
        }
        sb.append(count);
        System.out.println(count);
    }
}



//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());
//        StringBuilder sb = new StringBuilder();
//
//        int S = Integer.parseInt(st.nextToken()); // 문자열 길이
//        int P = Integer.parseInt(st.nextToken()); // 부분 문자열 길이
//
//        String a = br.readLine();
//        int[] data = new int[4];
//        st = new StringTokenizer(br.readLine());
//        for (int i = 0; i < 4; i++) {
//            data[i] = Integer.parseInt(st.nextToken());
//        }
//        int cnt = 0;
//        for (int i = 0; i < a.length() - P + 1; i++) {
//            int[] count = new int[4];
//            String temp = a.substring(i, i + P);
//            for (int j = 0; j < temp.length(); j++) {
//                if (temp.charAt(j) == 'A'){
//                    count[0]++;
//                }else if (temp.charAt(j) == 'C'){
//                    count[1]++;
//                }else if (temp.charAt(j) == 'G'){
//                    count[2]++;
//                }else if (temp.charAt(j) == 'T'){
//                    count[3]++;
//                }
//            }
//            if (count[0] >= data[0] && count[1] >= data[1] && count[2] >= data[2] && count[3] >= data[3]) cnt ++;
//        }
//        sb.append(cnt);
//        System.out.println(sb);
//    }
//}
