package 알고리즘.백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_1100 {
    static char data[][];
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        data = new char[8][8];

        for (int i = 0; i < 8; i++) {
            String a = br.readLine();
            for (int j = 0; j < 8; j++) {
                data[i][j] = a.charAt(j);
            }
        }
        int cnt = 0;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if(i % 2 == 0){
                    if (j % 2 == 0 && data[i][j] == 'F')cnt++;
                }else{
                    if (j % 2 == 1 && data[i][j] == 'F')cnt++;
                }
            }
        }
        System.out.println(cnt);
    }
    static void print(){
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                System.out.print(data[i][j]);
            }
            System.out.println();
        }
    }
}
