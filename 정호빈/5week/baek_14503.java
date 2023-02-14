import java.util.*;
import java.io.*;
public class Main {
	static int cnt=0;
	static int[] dx = {0,1,0,-1};
	static int[] dy = {-1,0,1,0};
	static int N,M;
	static boolean[][] visited;
	static int[][] arr;
	static int flag=0;
  //로봇청소기
  
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st ;
		st = new StringTokenizer(br.readLine());
		N =Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N][M];
		visited = new boolean[N][M];
		st = new StringTokenizer(br.readLine());
		int y = Integer.parseInt(st.nextToken());
		int x = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) {
				arr[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		dfs(y,x,d);
		System.out.println(cnt);
		
	}

	private static void dfs( int y, int x, int d) {
		if(arr[y][x]==1||flag==1) {
			flag=1;
			return;
		}
		if(!visited[y][x]) {
			cnt++;
		}
		
		visited[y][x] = true;
		int ddy=y,ddx=x;
		for(int i=0;i<4;i++) {
			d--;
			if(d==-1)d=3;
			ddy = y+dy[d];ddx=x+dx[d];
			if(ddy>=0&&ddy<N&&ddx>=0&&ddx<M
					&&!visited[ddy][ddx]&&arr[ddy][ddx]==0) {
				dfs(ddy,ddx,d);
				return;
			}
		}
		ddy = y-dy[d];ddx=x-dx[d];
		if(ddy>=0&&ddy<N&&ddx>=0&&ddx<M) {
			dfs(ddy,ddx,d);
		}
			
	}

	

}
