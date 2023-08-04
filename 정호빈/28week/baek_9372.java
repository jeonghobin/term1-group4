import java.util.*;
import java.io.*;


public class Main {

	static List<Integer>[] g;
	static int N,M,cnt;
	static boolean[] v;
	
	public static void main(String[] args) throws IOException {
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());
		for(int t=0;t<T;t++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			g = new ArrayList[N+1];
			v = new boolean[N+1];
			
			cnt=0;
			for(int i=1;i<=N;i++) {
				g[i] = new ArrayList<Integer>();
			}
			for(int i=0;i<M;i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				g[a].add(b);
				g[b].add(a);
			}
			dfs(1);
			
			System.out.println(cnt);
		}
		
		
		
	}

	private static void dfs(int i) {
		v[i]=true;
		for(int nxt : g[i]) {
			if(v[nxt])continue;
			dfs(nxt);
			cnt++;
		}
		
	}

}
