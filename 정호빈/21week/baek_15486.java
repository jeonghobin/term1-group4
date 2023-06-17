import java.io.*;
import java.util.*;



public class Main {
	
	static int N;
	static int[][] arr;
	static int[] d;
 	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		arr = new int[N][2];
		d = new int[N];
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
		}
		Arrays.fill(d, -1);
		for(int i=N-1;i>=0;i--) {
			recur(i);
		}
		System.out.println(d[0]);
		
	}
	private static int recur(int cur) {
		// TODO Auto-generated method stub
		if(cur>N)return -1000000;
		if(cur==N)return 0;
		if(d[cur]!=-1)return d[cur];
		
		d[cur] = Math.max(recur(cur+1), recur(cur+arr[cur][0])+arr[cur][1]);
		
		return d[cur];
	}

	
 	
 	

}
