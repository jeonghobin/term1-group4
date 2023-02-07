package 알고리즘.Swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Swea_1218 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int t = 1; t < 11; t++) {
            StringBuilder sb = new StringBuilder();
            sb.append("#").append(t).append(" ");
            int N = Integer.parseInt(br.readLine());
            String a = br.readLine();
            boolean flag = true;
            int[] data = new int[4];
            for (int i = 0; i < a.length(); i++) {
                if (a.charAt(i) == '(') {
                    data[0]++;
                } else if (a.charAt(i) == '[') {
                    data[1]++;
                } else if (a.charAt(i) == '{') {
                    data[2]++;
                } else if (a.charAt(i) == '<') {
                    data[3]++;
                } else if (a.charAt(i) == ')') {
                    data[0]--;
                    if (data[0] < 0) {
                        flag = false;
                        break;
                    }
                } else if (a.charAt(i) == ']') {
                    data[1]--;
                    if (data[1] < 0) {
                        flag = false;
                        break;
                    }
                } else if (a.charAt(i) == '}') {
                    data[2]--;
                    if (data[2] < 0) {
                        flag = false;
                        break;
                    }
                } else if (a.charAt(i) == '>') {
                    data[3]--;
                    if (data[3] < 0) {
                        flag = false;
                        break;
                    }
                }
            }
            if(flag) sb.append(1);
            else sb.append(0);
            System.out.println(sb);
        }
    }
}
