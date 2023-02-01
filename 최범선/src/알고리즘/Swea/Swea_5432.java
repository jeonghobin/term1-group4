package 알고리즘.Swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Swea_5432 {
    static int rsl;
    public static void cut(int cnt, int add) {
        if (rsl != 0) {
            rsl += cnt;
        }else {
            rsl = cnt;
            rsl += cnt;
        }
    }


    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int tc = Integer.parseInt(br.readLine());

        for (int t = 1; t < tc + 1; t++) {
            rsl = 0;
            String a = br.readLine();
            int cnt = 0, add = 0; // cnt : 기존 막대 , add : 추가된 막대
            for (int i = 0; i < a.length(); i++) {
                if (a.charAt(i) == '(' && i+1 < a.length() && a.charAt(i+1) != ')') {
                    cnt++;
                    add++;
                }else if(a.charAt(i) == ')' && a.charAt(i-1) != '(' && cnt > 0) {
                    if (cnt > 0) cnt--;
                    if (add > 0) add--;
                }else if(a.charAt(i) == '(' && i+1 < a.length() && a.charAt(i+1) == ')'){
                    rsl += add;
                    cut(cnt, add);
                    add = 0;
                }
            }
            System.out.println("#" + t + " " + rsl);
        }

    }
}