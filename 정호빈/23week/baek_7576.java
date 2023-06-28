import java.io.*;
import java.util.*;




public class Main {
	
	static int[] dx = {0,1,0,-1};
	static int[] dy = {1,0,-1,0};
	static int n,m;
	static int[][] map;
	
	
  	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		map = new int[n][m];
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<m;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());			
			}
		}
		Queue<int[]> que = new LinkedList<>();
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				if(map[i][j]==1)que.add(new int[] {i,j});			
			}
		}
		int cnt=0;
		while(!que.isEmpty()) {
			int size = que.size();
			for(int i=0;i<size;i++) {
				int[] a = que.poll();
				for(int j=0;j<4;j++) {
					int nx = a[0]+dx[j];
					int ny = a[1]+dy[j];
					if(nx>=0&&nx<n&&ny>=0&&ny<m&&map[nx][ny]==0) {
						que.add(new int[] {nx,ny});
						map[nx][ny] = 1;
					}
				}
			}
			cnt++;
		}
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				if(map[i][j]==0) {
					System.out.println(-1);
					return;
				}
			}
		}
		System.out.println(cnt-1);
	}



 	

}
