import java.io.*;
import java.util.*;

public class Main {
	
	static int N;
	static List<int[]> v = new ArrayList<int[]>();
	static List<Integer>[] g;
	private static boolean[] visited;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		g = new ArrayList[101];
		for(int i=0;i<101;i++) {
			g[i] = new ArrayList<Integer>();
		}
		for(int i=0;i<N;i++){
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			if(a==1) {
				int size = v.size();
				for(int j=0;j<size;j++) {
					int[] temp = v.get(j);
					if((temp[0]<b&&temp[1]>b)||(temp[0]<c&&temp[1]>c)) {
						g[size].add(j);
					}
					if((temp[0]>b&&temp[0]<c)||(temp[1]>b&&temp[1]<c)) {
						g[j].add(size);
					}
				}
				v.add(new int[] {b,c});
			}
			else if(a==2) {
				visited = new boolean[101];
				dfs(b-1);
				if(visited[c-1])System.out.println(1);
				else System.out.println(0);
			}
		}
		
	}
	private static void dfs(int b) {
		// TODO Auto-generated method stub
		visited[b] = true;
		for(int i: g[b]) {
			if(visited[i])continue;
			dfs(i);
		}
	}
	
	

	

}
