import java.io.*;
import java.util.*;



public class Main {
	
	static int N,L,R,X,max,min,cnt;
	static int[] arr;
	static boolean[] v;
 	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());
		arr = new int[N];
		v = new boolean[N];
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		recur(0);
		System.out.println(cnt);
		
	}

	private static void recur(int cur) {
		// TODO Auto-generated method stub
		if(cur==N) {
			int total=0,max=-1,min=1000000;
			for(int i=0;i<N;i++) {
				if(v[i]) {
					total+=arr[i];
					max = Math.max(max, arr[i]);
					min = Math.min(min, arr[i]);
				}
			}
			if(total>=L&&total<=R&&max-min>=X)cnt++;
			return;
		}
		v[cur]=true;
		recur(cur+1);
		v[cur]=false;
		recur(cur+1);
	}

	
	
	
}
