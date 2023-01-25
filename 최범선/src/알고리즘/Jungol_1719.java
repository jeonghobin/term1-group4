package 알고리즘;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Jungol_1719 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        if (N < 1 || N > 100 || M < 1 || M > 4 || (N%2) == 0){
            System.out.println("INPUT ERROR!");
        }else{
            if(M == 1){
            for (int i = 0; i < N; i++) {
                if (i <= N / 2){
                    for (int j = 0; j < i + 1; j++) {
                        System.out.print("*");
                    }
                }else{
                for (int j = 0; j < N - i; j++) {
                    System.out.print("*");
                }
                }
                System.out.println();
            }
            }else if(M == 2){
                for (int i = 0; i < N; i++) {
                    if (i <= N / 2){
                        for (int j = i + 1; j < N/2 + 1; j++) {
                            System.out.print(" ");
                        }
                        for (int j = 0; j < i + 1; j++) {
                            System.out.print("*");
                        }
                    }else{
                        for (int j = N/2; j < i; j++) {
                            System.out.print(" ");
                        }
                        for (int j = 0; j < N - i; j++) {
                            System.out.print("*");
                        }
                    }
                    System.out.println();
                }
            }else if(M == 3){
                for (int i = 0; i < N; i++) {
                    if (i <= N / 2){
                        for (int j = 0; j < N; j++) {
                            if(j >= i && j < (N - i)) {
                                System.out.print("*");
                            }else{
                                System.out.print(" ");
                            }
                        }
                    }else{
                        for (int j = 0; j < N; j++) {
                            if(j >= (N-i-1) && j < (N - (N-i-1))) {
                                System.out.print("*");
                            }else{
                                System.out.print(" ");
                            }
                        }
                        }
                    System.out.println();
                    }
                }
            else{
                for (int i = 0; i < N; i++) {
                    if( i < N/2 + 1){
                    for (int j = 0; j < i; j++) {
                        System.out.print(" ");
                    }
                    for (int j = 0; j < N/2 + 1 - i; j++) {
                        System.out.print("*");
                    }}else{
                    for (int j = 0; j < N/2; j++) {
                        System.out.print(" ");
                    }
                    for (int j = 0; j <= i-N/2; j++) {
                        System.out.print("*");
                    }
                }
                    System.out.println();
                }
            }
        }
    }
}
