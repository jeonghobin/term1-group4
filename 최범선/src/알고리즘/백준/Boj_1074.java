package 알고리즘.백준;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_1074 {

    static int N, r, c, cnt, n;
    static boolean flag;


    public static void divide(int x, int y, int size) {

        if(!flag) return;

        if (!(x <= r && r < x + size && c >= y && c < y + size)) {
            cnt += size * size;
            return;
        }
        if (size < 2) {
            flag = false;
            cnt++;
        }else {
            int r = size / 2;
            divide(x , y , r);
            divide(x , y + r , r);
            divide(x + r , y, r);
            divide(x + r , y + r , r);
        }

    }


    public static int pow(int x, int n) {
        if(n == 1) return x;
        int y = pow(x, n/2);
        return n % 2 == 0 ? y * y : y * y * x;
    }

    public static void main(String[] args) throws Exception {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        n = pow(2, N);

        flag = true;
        divide(0, 0, n);
        System.out.println(cnt - 1);

    }
}