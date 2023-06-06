import java.io.*;
import java.util.*;



public class Main {
	
	
	
 	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		st = new StringTokenizer(br.readLine());
		int cnt=1,rs=0;
		for(int i=0;i<N;i++) {
			int a = Integer.parseInt(st.nextToken());
			if(a==1) {
				rs+=cnt;
				cnt++;
			}else {
				cnt=1;
			}
		}
		System.out.println(rs);
		
	}

 		

}
