import java.io.*;
import java.util.*;

public class Main {
	
	static int[] dx = {0,1,0,-1};
	static int[] dy = {1,0,-1,0};
	static int max=-1;
	static int N,M;
	static char[][] map;
	static boolean[][] v;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new char[N][M];
		for(int i=0;i<N;i++) {
			String str = br.readLine();
			map[i] = str.toCharArray();
		}
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(map[i][j]=='W')continue;
				v = new boolean[N][M];
				bfs(i,j);
			}
		}
		System.out.println(max-1);
		
	}
	private static void bfs(int i, int j) {
		// TODO Auto-generated method stub
		Queue<int[]> que = new LinkedList<>();
		que.add(new int[] {i,j});
		v[i][j] = true;
		int cnt=0;
		while(!que.isEmpty()) {
			int size = que.size();
			for(int k=0;k<size;k++) {
				int[] a = que.poll();
				for(int d=0;d<4;d++) {
					int nx=a[0]+dx[d];
					int ny=a[1]+dy[d];
					if(nx>=0&&nx<N&&ny>=0&&ny<M&&!v[nx][ny]&&map[nx][ny]=='L') {
						que.add(new int[] {nx,ny});
						v[nx][ny]=true;
					}
				}
			}
			cnt++;
		}
		max = Math.max(max, cnt);
	}
	
	
	

	
	

}
