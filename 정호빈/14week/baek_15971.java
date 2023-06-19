import java.io.*;
import java.util.*;

public class Main {
	
	static int N,R1,R2,maxc,sum=0;
	static List<Integer> list = new ArrayList<>();
	static List<int[]>[] g;
	static boolean[] v;
	private static int flag;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		N=Integer.parseInt(st.nextToken());
		R1 = Integer.parseInt(st.nextToken());
		R2 = Integer.parseInt(st.nextToken());
		if(R1==R2||N==1) {
			System.out.println(0);
			return;
		}
		g=new LinkedList[N+1];
		v = new boolean[N+1];
		for(int i=1;i<=N;i++) {
			g[i] = new LinkedList<>();
		}
		for(int i=0;i<N-1;i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			g[a].add(new int[] {b,c});
			g[b].add(new int[] {a,c});
		}
		sum=Integer.MAX_VALUE;
		dfs(R1,0);
		System.out.println(sum-maxc);
	}
	private static void dfs(int i,int sum1) {
		// TODO Auto-generated method stub
		if(flag==1)return;
		if(i==R2) {
			sum=Math.min(sum, sum1);
			Collections.sort(list);
			maxc = list.get(list.size()-1);
			flag=1;
			return;
		}
		v[i] = true;
		for(int[] j :g[i]) {
			if(v[j[0]])continue;
			list.add(j[1]);
			dfs(j[0],sum1+j[1]);
			list.remove(list.size()-1);
		}
	}
	

	
}
