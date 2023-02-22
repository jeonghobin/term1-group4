import java.util.*;
import java.io.*;

public class Main {
	static boolean[] visited;
	static LinkedList<Integer>[] graph;
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st ;
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int V = Integer.parseInt(st.nextToken());
		graph = new LinkedList[N];
		visited = new boolean[N];
		for(int i=0;i<N;i++) {
			graph[i] = new LinkedList<>();
		}
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken())-1;
			int b = Integer.parseInt(st.nextToken())-1;
			graph[a].add(b);
			graph[b].add(a);
		}
		for(int i=0;i<N;i++) {
			Collections.sort(graph[i]);
		}
		dfs(V-1);
		System.out.println();
		Arrays.fill(visited, false);
		bfs(V-1);
	}

	private static void bfs(int v) {
		Queue<Integer> que = new LinkedList<Integer>();
		que.offer(v);
		visited[v]=true;
		while(!que.isEmpty()) {
			int a = que.poll();
			System.out.print((a+1)+" ");
			for(int i=0;i<graph[a].size();i++) {
				if(!visited[graph[a].get(i)]) {
					que.offer(graph[a].get(i));
					visited[graph[a].get(i)]=true;
				}
			}
		}
	}

	private static void dfs(int v) {
		visited[v] = true;
		System.out.print((v+1)+" ");
		for(int i=0;i<graph[v].size();i++) {
			if(!visited[graph[v].get(i)]) {
				dfs(graph[v].get(i));
			}
		}
		
	}
	

}
