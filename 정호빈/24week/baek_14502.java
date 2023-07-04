import java.io.*;
import java.util.*;




public class Main {
	static int[] dx = {0,1,0,-1};
	static int[] dy = {1,0,-1,0};
	static int N,M,max;
	static int[][] map;
	static List<int[]> zero = new LinkedList<>();
	static int[][] out;
	static Queue<int[]> que = new LinkedList<>();
  	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j]==0) {
					zero.add(new int[] {i,j});
				}
			}
		}
		out = new int[3][2];
		recur(0,0);
		System.out.println(max);
		
	}
	private static void recur(int cnt, int start) {
		// TODO Auto-generated method stub
		if(cnt==3) {
			//맵에 벽을 세우고 카피할 맵을 만들어서 bfs를 돌린다.
			int[][] tmpmap = new int[N][M];
			cpmap(tmpmap);
			for(int i=0;i<3;i++) {
				tmpmap[out[i][0]][out[i][1]]=1;
			}
			while(!que.isEmpty()) {
				int size = que.size();
				for(int i=0;i<size;i++) {
					int[] a = que.poll();
					for(int j=0;j<4;j++) {
						int nx = a[0]+dx[j];
						int ny = a[1]+dy[j];
						if(nx>=0&&nx<N&&ny>=0&&ny<M&&tmpmap[nx][ny]==0) {
							que.offer(new int[] {nx,ny});
							tmpmap[nx][ny] = 2;
						}
					}
				}
			}
			int rscnt=0;
			for(int i=0;i<N;i++) {
				for(int j=0;j<M;j++) {
					if(tmpmap[i][j]==0)rscnt++;
				}
			}
			max = Math.max(max, rscnt);
			
			return;
		}
		
		for(int i=start;i<zero.size();i++) {
			out[cnt][0] = zero.get(i)[0];
			out[cnt][1] = zero.get(i)[1];
			recur(cnt+1,i+1);
		}
		
	}
	private static void cpmap(int[][] tmpmap) {
		// TODO Auto-generated method stub
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				tmpmap[i][j] = map[i][j];
				if(tmpmap[i][j]==2)que.offer(new int[] {i,j});
			}
		}
	}


 	

}
