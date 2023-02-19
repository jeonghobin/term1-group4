import java.util.*;
import java.io.*;


public class Main {
	static int[] dr = {0,1,0,-1,0,0};
	static int[] dc = {1,0,-1,0,0,0};
	static int[] dh = {0,0,0,0,1,-1};
	static int[][][] map;
	static int R,C,H,cnt=0,flag=1;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st ;
		st = new StringTokenizer(br.readLine());
		C = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		map = new int[H][R][C];
		for(int i=0;i<H;i++) {
			for(int j=0;j<R;j++) {
				st = new StringTokenizer(br.readLine());
				for(int k=0;k<C;k++) {
					map[i][j][k] = Integer.parseInt(st.nextToken());
					if(map[i][j][k]==0) {
						flag=0;
					}
				}
			}
		}
		if(flag==0) {
			bfs();
			if(flag==1) {
				System.out.println(cnt);
			}else {
				System.out.println(-1);
			}
		}
			
		else
			System.out.println(0);
		
	}

	private static void bfs() {
		Queue<int[]> que = new LinkedList<>();
		for(int i=0;i<H;i++) {
			for(int j=0;j<R;j++) {
				for(int k=0;k<C;k++) {
					if(map[i][j][k]==1) {
						que.offer(new int[] {i,j,k});
					}
				}
			}
		}
		
		while(!que.isEmpty()) {
			int size = que.size();
			for(int t=0;t<size;t++) {
				int[] a = que.poll();
				for(int i=0;i<6;i++) {
					int nh = a[0]+dh[i];
					int nr = a[1]+dr[i];
					int nc = a[2]+dc[i];
					if(nr>=0&&nr<R&&nc>=0&&nc<C&&nh>=0&&nh<H&&map[nh][nr][nc]==0) {
						map[nh][nr][nc]=1;
						que.offer(new int[] {nh,nr,nc});
					}
				}
			}
			cnt++;
			check();
			if(flag==1) {
				break;
			}
		}
		check();
	}

	private static void check() {
		for(int i=0;i<H;i++) {
			for(int j=0;j<R;j++) {
				for(int k=0;k<C;k++) {
					if(map[i][j][k]==0) {
						flag=0;
						return;
					}
				}
			}
		}
		flag=1;
	}




}
