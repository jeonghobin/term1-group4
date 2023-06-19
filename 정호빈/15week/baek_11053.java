import java.io.*;
import java.util.*;

public class Main {
	
	static int N;
	static int[] arr;
	static int[][] d;
	
	
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		arr = new int[N+1];
		d = new int[N+1][2];
		st = new StringTokenizer(br.readLine());
		for(int i=1;i<=N;i++) {
			arr[i]=Integer.parseInt(st.nextToken());
			d[i][0] = 1;
		}
		for(int i=1;i<=N;i++) {
			for(int j=i-1;j>=0;j--) {
				if(arr[i]<=arr[j])continue;
				if(d[i][0]<=d[j][0]+1) {
					d[i][0]=d[j][0]+1;
				}
			}
		}
		int max = 0;
		for(int i=0;i<=N;i++) {
			if(max<d[i][0]) {
				max = d[i][0];
				
			}
		}
		System.out.println(max);
		
		
		
	}

	
	
	

	
	
	
	

}
