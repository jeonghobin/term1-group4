package 알고리즘.백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj_17413 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String a = br.readLine();
        StringBuilder sb = new StringBuilder();
        StringBuilder temp = new StringBuilder();
        int idx = 0;
        boolean flag = false;
        for (int i = 0; i < a.length(); i++) {
            temp.append(a.charAt(i));
            if (a.charAt(i) == '<') {
                if (temp.length() > 0) {
                    temp.deleteCharAt(temp.length()-1);
                    sb.append(temp.reverse());
                    temp.delete(0, temp.length());
                    temp.append(a.charAt(i));
                }
                flag = true;
            }else if(a.charAt(i) == '>') {
                sb.append(temp);
                temp.delete(0, temp.length());
                flag = false;
            }
            else if (flag == false && a.charAt(i) == ' ') {
                temp.deleteCharAt(temp.length()-1);
                sb.append(temp.reverse() + " ");
                temp.delete(0, temp.length());
            }else if(i == a.length() - 1) {
                sb.append(temp.reverse());
            }
        }
        System.out.println(sb);
    }
}
