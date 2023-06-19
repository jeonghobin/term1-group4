import java.io.*;
import java.util.*;



public class Main {
	
	
	
 	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int N =Integer.parseInt(br.readLine());
		int[] arr = new int[1001];
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			arr[a] = b;
		}
		int[] l = new int[1001];
		int[] r = new int[1001];
		l[0] = arr[0];
		for(int i=1;i<1001;i++) {
			l[i]=Math.max(l[i-1], arr[i]);
		}
		r[1000]=arr[1000];
		for(int i=999;i>=0;i--) {
			r[i]=Math.max(r[i+1], arr[i]);
		}
		int sum=0;
		for(int i=0;i<1001;i++) {
			sum+=Math.min(l[i], r[i]);
		}
		System.out.println(sum);
	}

 	

}
