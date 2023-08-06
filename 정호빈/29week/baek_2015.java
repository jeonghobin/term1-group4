import java.util.*;
import java.io.*;


public class Main {
	
		
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		long K = Integer.parseInt(st.nextToken());
		long[] prefix = new long[N+1];
		
		st = new StringTokenizer(br.readLine());
		long cnt=0;
		Map<Long, Long> map = new HashMap<>();
		for(int i=1;i<=N;i++) {
			int a = Integer.parseInt(st.nextToken());
			prefix[i] = prefix[i-1] + a;
			if(prefix[i]==K)cnt++;
			cnt += map.getOrDefault(prefix[i], 0L);
			map.put(prefix[i]+K, map.getOrDefault(prefix[i]+K,0L)+1L);
		}
		// K = prefix[a>=i]-prefix[i]
		// 
		System.out.println(cnt);
		//int[] rs =new int[N*(N+1)/2+1];
 		
		
 	}

}
