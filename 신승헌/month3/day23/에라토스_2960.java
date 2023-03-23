import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		
		
		boolean[] prime = new boolean[N+1];
		prime[0] = true;
		prime[1] = true;
		int cnt = 0;
		for (int i = 2; i <= N; i++) {
			if (prime[i] == false) {
				cnt++;
				if (cnt == L) {
					System.out.println(i);
					return;
				}
				prime[i] = true;
				for (int j = i + i; j <= N; j = j + i) {
					if (prime[j] == false) {						
						cnt++;
					}
					if (cnt == L) {
						System.out.println(j);
						return;
					}
					
					prime[j] = true;
				}
			}
		}
		
		
		
	}
}
