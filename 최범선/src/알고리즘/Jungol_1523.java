package 알고리즘;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Jungol_1523 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        if (N < 1 || N > 100 || M < 1 || M > 3){
            System.out.println("INPUT ERROR!");
        }else{
        if (M == 1){
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < i + 1; j++) {
                    System.out.print("*");
                }
                System.out.println();
            }
        }else if(M == 2){
            for (int i = 0; i < N; i++) {
                for (int j = N-i-1; j > -1; j--) {
                    System.out.print("*");
                }
                System.out.println();
            }
        }else{
            for (int i = 0; i < N; i++) {
                for (int j = i; j < N - 1; j++) {
                    System.out.print(" ");
                }
                for (int j = 0; j < 2*i + 1; j++) {
                    System.out.print("*");
                }
                System.out.println();
            }
        }
        }
    }
}
