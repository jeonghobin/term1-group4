import java.io.*;
import java.util.*;



public class Main {
	
	
	
 	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		int[] A = new int[N+1];
		int[] B = new int[N+1];
		long[] preA = new long[N+1];
		long[] preB = new long[N+1];
		st = new StringTokenizer(br.readLine());
		for(int i=1;i<=N;i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		for(int i=1;i<=N;i++) {
			B[i] = Integer.parseInt(st.nextToken());
		}
		TreeMap<Long,Long> map = new TreeMap<>();
		map.put(0L,1L);
		long sum=0;
		for(int i=1;i<=N;i++) {
			preA[i] = preA[i-1]+A[i];
			preB[i] = preB[i-1]+B[i];
			sum+=map.getOrDefault(preA[i]-preB[i],0L);
			map.put(preA[i]-preB[i], 1+map.getOrDefault(preA[i]-preB[i], 0L));
		}
		System.out.println(sum);
		
	}
 	
 	

 	


	
	

}
