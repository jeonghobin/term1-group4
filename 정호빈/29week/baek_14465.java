import java.util.*;
import java.io.*;



public class Main {

	
	
	public static void main(String[] args) throws IOException {
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		boolean[] v = new boolean[N+1];
		for(int i=0;i<B;i++) {
			int a = Integer.parseInt(br.readLine());
			v[a] = true;
		}
		int s = 1;
		int e = K;
		int cnt=0;
		for(int i=s;i<=e;i++) {
			if(v[i])cnt++;
		}
		int min=1000000;
		while(e<=N) {
			min = Math.min(min, cnt);
			if(v[s])cnt--;
			s++;
			e++;
			if(e<=N&&v[e])cnt++;
		}
		
		System.out.println(min);
		
		
	}

	

}
