import java.io.*;
import java.util.*;




public class Main {
	
	static int N,M,K,X;
	static List<int[]>[] g;
	static int[] d;
	static boolean[] v;
	
  	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());
		g = new LinkedList[N+1];
		d = new int[N+1];
		v = new boolean[N+1];
		Arrays.fill(d, Integer.MAX_VALUE);
		for(int i=1;i<=N;i++) {
			g[i] = new LinkedList<int[]>();
		}
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			g[a].add(new int[] {b,1});
		}
		PriorityQueue<int[]> pq = new PriorityQueue<>(
				new Comparator<int[]>() {
					@Override
					public int compare(int[] o1, int[] o2) {
						// TODO Auto-generated method stub
						return o1[1]-o2[1];
					}
				});
		d[X] =0;
		pq.add(new int[] {X,0});
		while(!pq.isEmpty()) {
			int[] p = pq.poll();
			if(v[p[0]])continue;
			v[p[0]] =true;
			
			for(int[] nxt : g[p[0]]) {
				if(!v[nxt[0]]&&d[nxt[0]]>d[p[0]]+nxt[1]) {
					d[nxt[0]] = d[p[0]]+nxt[1];
					pq.add(new int[] {nxt[0],d[nxt[0]]});
				}
			}
		}
		
		int cnt=0;
		for(int i=1;i<=N;i++) {
			if(K==d[i]) {
				System.out.println(i);
				cnt++;
			}
		}
		if(cnt==0) {
			System.out.println(-1);
		}
		
		
	}

 	

}
