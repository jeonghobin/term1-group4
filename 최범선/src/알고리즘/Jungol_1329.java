package 알고리즘;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Jungol_1329 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        if (N < 1 || N > 100 || N%2 == 0){
            System.out.println("INPUT ERROR!");
        }else{
            for (int i = 0; i < N/2 + 1; i++) {
                for (int j = 0; j < i; j++) {
                    System.out.print(" ");
                }
                for (int j = 0; j < 2*i+1; j++) {
                    System.out.print("*");
                }
                System.out.println();
            }
            for (int i = N/2+1; i < N; i++) {
                for (int j = i + 1; j < N; j++) {
                    System.out.print(" ");
                }
                for (int j = 0; j < 2 * (N-1-i) + 1; j++) {
                    System.out.print("*");
                }
                System.out.println();
            }
        }



    }
}
