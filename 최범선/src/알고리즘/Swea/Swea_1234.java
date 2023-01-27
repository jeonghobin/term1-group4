package 알고리즘.Swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Swea_1234 {
    static String a;
    static String rsl;
    public static void recursive(String temp){
        int state = 1;
        for (int i = 0; i < temp.length() - 1; i++) {
            if (Character.toString(temp.charAt(i)).equals(Character.toString(temp.charAt(i+1)))){
                state = 0;
                if (i + 2 <= temp.length() - 1){
                    temp = temp.substring(0,i) + temp.substring(i+2);
                }else{
                    temp = temp.substring(0,i);
                }
                break;
            }
        }
        if(state == 1) {
            rsl = temp;
            return;
        }
        recursive(temp);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        for (int t = 1; t < 11; t++) {
            rsl = "";
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            a = st.nextToken();
            recursive(a);
            System.out.println("#" + t + " " + rsl);
        }
    }
}
