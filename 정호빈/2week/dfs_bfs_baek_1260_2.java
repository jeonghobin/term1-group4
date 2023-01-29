import java.util.*;
import java.io.*;

// dfs, bfs 인접행렬로 구현
public class Main {
	
	public static void dfs(int[][] graph,boolean[] visited,int V) {
		visited[V] = true;
		System.out.print(V+" ");
		for(int i=1;i<graph[V].length;i++) {
			if(graph[V][i]==1&&!visited[i]) {
				dfs(graph,visited,i);
			}
		}
	}
	public static void bfs(int[][] graph,boolean[] visited,int V) {
		Queue<Integer> que = new LinkedList<>();
		que.offer(V);
		visited[V]=true;
		while(!que.isEmpty()) {
			int temp = que.poll();
			System.out.print(temp+" ");
			for(int i=1;i<graph[temp].length;i++) {
				if(graph[temp][i]==1&&!visited[i]) {
					visited[i]=true;
					que.offer(i);
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
		int[][] graph = new int[N+1][N+1];
		boolean[] visited =new boolean[N+1];
		for(int i=1;i<=M;i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			if(graph[a][b]!=1) {
				graph[a][b]=graph[b][a]=1;
			}
		}
		dfs(graph,visited,V);
		Arrays.fill(visited, false);
		System.out.println();
		bfs(graph,visited,V);
		
		
	}

}
