import java.util.*;
import java.io.*;

public class Main {
	
	static int N,M;
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st ;
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		long[] arr = new long[N];
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		long s = 1;
		long e = arr[arr.length-1];
		while(s<=e) {
			long mid = (s+e)/2;
			long sum=0;
			for(int i=0;i<N;i++) {
				long a = arr[i]-mid;
				if(a<0) a=0;
				sum+=a;
			}
			if(sum<M) {
				e=mid-1;
			}else {
				s=mid+1;
			}
		}
		System.out.println(s-1);
		
	}
	
}
