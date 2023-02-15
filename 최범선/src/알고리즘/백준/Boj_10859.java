package 알고리즘.백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj_10859 {

    public static boolean isPrime(long N){
        if (N == 1) return false;
        for (long i = 2; i * i <  N + 1; i++) {
            if (N % i == 0) return false;
        }
        return true;
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Long N = Long.parseLong(br.readLine());
        long temp = N;
        while (temp > 0) {
            long t = temp % 10;
            if(t == 3 || t == 4 || t == 7){
                System.out.println("no");
                return;
            }
            temp /= 10;
        }
        if(isPrime(N)){
            long R = 0;
            while (N > 0){
                long t = N % 10;
                if (t == 6) R = R * 10 + 9;
                else if (t == 9) R = R * 10 + 6;
                else R = R * 10 + N % 10;
                N /= 10;
            }
            if (isPrime(R)) System.out.println("yes");
            else System.out.println("no");
        }else System.out.println("no");
    }
}