import java.io.*;
import java.util.*;



public class Main {
	
	static int T,N, node1,node2;
	static List<Integer>[] tree;
	static int[] par;
	static boolean[] ischild;
	static boolean[] v;
 	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		T = Integer.parseInt(br.readLine());
		for(int t=1;t<=T;t++) {
			N = Integer.parseInt(br.readLine());
			tree = new LinkedList[N+1];
			ischild = new boolean[N+1];
			par = new int[N+1];
			for(int i=0;i<=N;i++) {
				tree[i] = new LinkedList<>();
			}
			for(int i=0;i<N-1;i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				tree[a].add(b);
				ischild[b]=true;
			}
			st = new StringTokenizer(br.readLine());
			node1 = Integer.parseInt(st.nextToken());
			node2 = Integer.parseInt(st.nextToken());
			
			int root=0;
			for(int i=1;i<=N;i++) {
				if(!ischild[i]) {
					root=i;
					break;
				}
			}
			dfs(root);
			v = new boolean[N+1];
			
			findpar(node1);
			findpar(node2);
		}
		
		
	}
	private static void findpar(int n) {
		// TODO Auto-generated method stub
		v[n]=true;
		if(n==0)return;
		if(v[par[n]]) {
			if(par[n]==0)
				System.out.println(n);
			else
				System.out.println(par[n]);
			return;
		}
		findpar(par[n]);
	}
	private static void dfs(int n) {
		// TODO Auto-generated method stub
		for(int i: tree[n]) {
			par[i] = n;
			dfs(i);
		}
	}

 	

}
