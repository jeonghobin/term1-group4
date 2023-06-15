import java.io.*;
import java.util.*;



public class Main {
	
	
	
 	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int[] arr = new int[N];
		for(int i=0;i<N;i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		int[] v = new int[d+1];
		int s=0,e=0,max=1,cnt=0;
		for(int i=0;i<k;i++) {
			v[arr[e]]++;
			if(v[arr[e]]==1) {
				cnt++;
			}
			e++;
		}
		while(s<N) {
			v[arr[s]]--;
			if(v[arr[s]]==0) {
				cnt--;
			}
			s++;
			
			v[arr[e%N]]++;
			if(v[arr[e%N]]==1) {
				cnt++;
			}
			e++;
			
			if(v[c]==0) {
				max = Math.max(max, cnt+1);
			}else {
				max = Math.max(max, cnt);
			}
		}
		System.out.println(max);
		
	}
 	
 	
	

}
