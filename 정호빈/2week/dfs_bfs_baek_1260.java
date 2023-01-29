import java.util.*;
import java.io.*;

// dfs, bfs 인접 리스트로 구현

public class Main {
	
	static LinkedList<Integer>[] graph;
	
	public static void dfs(LinkedList<Integer>[] graph,boolean[] visited,int V) {
		visited[V] = true;
		System.out.print(V+" ");
		for(int i=0;i<graph[V].size();i++) {
			if(!visited[graph[V].get(i)])
				dfs(graph,visited,graph[V].get(i));
		}

	}
	public static void bfs(LinkedList<Integer>[] graph,boolean[] visited,int V) {
		Queue<Integer> que = new LinkedList<>();
		que.offer(V);
		visited[V]=true;
		while(!que.isEmpty()) {
			int temp = que.poll();
			System.out.print(temp+" ");
			for(int i=0;i<graph[temp].size();i++) {
				if(!visited[graph[temp].get(i)]) {
					que.offer(graph[temp].get(i));
					visited[graph[temp].get(i)]=true;
					
				}
			}

		}
	}
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int V = Integer.parseInt(st.nextToken());
		graph = new LinkedList[N+1];
		for(int i=0;i<graph.length;i++) {
			graph[i] = new LinkedList<>();
		}
		boolean[] visited =new boolean[N+1];
		for(int i=1;i<=M;i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			graph[a].add(b);
			graph[b].add(a);
			
		}
		for(int i=0;i<graph.length;i++) {
			Collections.sort(graph[i]);
		}
		dfs(graph,visited,V);
		Arrays.fill(visited, false);
		System.out.println();
		bfs(graph,visited,V);
		
		
	}

}
