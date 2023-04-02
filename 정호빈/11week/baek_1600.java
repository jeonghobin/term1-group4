import java.util.*;
import java.io.*;


public class Main {
	
	static int N,M,K;
	static int[][] arr;
	static int[] dx = {0,1,0,-1};
	static int[] dy = {1,0,-1,0};
	static int[] dx1= {-2,-1,1,2,2,1,-1,-2};
	static int[] dy1 ={1,2,2,1,-1,-2,-2,-1};
	static boolean[][][] v;
	static int ans=-1;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		K = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		M=Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		arr = new int[N][M];
		v = new boolean[N][M][K+1];
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		bfs(0,0);
		System.out.println(ans);
		
	}
	private static void bfs(int x, int y) {
		// TODO Auto-generated method stub
		Queue<int[]> que = new LinkedList<int[]>();
		que.offer(new int[] {x,y,K,0});
		for(int i=0;i<=K;i++) {
			v[x][y][i] = true;
		}
		while(!que.isEmpty()) {
			int[] a = que.poll();
			if(a[0]==N-1&&a[1]==M-1) {
				ans= a[3];
				return;
			}
			if(a[2]>0) {
				for(int i=0;i<8;i++) {
					int nx= a[0]+dx1[i];
					int ny= a[1]+dy1[i];
					if(nx>=0&&nx<N&&ny>=0&&ny<M&&!v[nx][ny][a[2]-1]&&arr[nx][ny]!=1) {
						que.offer(new int[] {nx,ny,a[2]-1,a[3]+1});
						v[nx][ny][a[2]-1] = true;
					}
				}
			}
			for(int i=0;i<4;i++) {
				int nx=a[0]+dx[i];
				int ny=a[1]+dy[i];
				if(nx>=0&&nx<N&&ny>=0&&ny<M&&!v[nx][ny][a[2]]&&arr[nx][ny]!=1) {
					que.offer(new int[] {nx,ny,a[2],a[3]+1});
					v[nx][ny][a[2]] = true;
				}
			}
		}
		
	}


	
	
	
	


	
	
	
	
	
	
	
	
	
}
