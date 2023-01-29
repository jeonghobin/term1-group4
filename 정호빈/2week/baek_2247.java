import java.util.*;
import java.io.*;


// 실질적 약수를 찾는 문제 6 -> (1) 2 3 (6) -> 2 3 이 실질적약수이다.
// CSOD(N) = SOD(N)+...+SOD(1)
// SOD(6) => (1) 2+3 (6) 실질적 약수를 더한값 

public class Main {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		long sum=0;
    // 결국에는 전체의 숫자에 i 로 나누어지는 숫자들을 모두 더해주면된다.
    // 30까지의 수에서 2로 나누어지는 수는 15개 따라서 2*(30/2-1) -1을 해주는 이유는 자기 자신은 빼야되기 때문에
		for(long i=2;i<=N;i++) {
			sum+=i*((long)N/i-1);
		}
		System.out.println(sum%1000000);
 		
		
 	}

}
