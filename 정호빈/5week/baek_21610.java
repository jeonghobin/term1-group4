import java.util.*;
import java.io.*;
public class Main {
	
	static int[] dx= {0,0,-1,-1,-1,0,1,1,1};
	static int[] dy= {0,-1,-1,0,1,1,1,0,-1};
	static int[] dx2 = {-1,-1,1,1};
	static int[] dy2 = {-1,1,1,-1};
	static int[][]map;
	static boolean[][] exist;
	static LinkedList<int[]> cloud = new LinkedList<int[]>();
	static int N,M;
	
	
	public static void get_cloud() {
		cloud.clear();
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(exist[i][j]==true) {
					cloud.add(new int[] {i,j});
				}
			}
		}
	}
	
	public static void get_exist() {
		for(int i=0;i<N;i++) {
			Arrays.fill(exist[i], false);
		}
		for(int[] i:cloud) {
			exist[i[0]][i[1]]=true;
		}
	}
	
	public static void move(int d,int s) {
		for(int i=0;i<cloud.size();i++) {
			int nx = (cloud.get(i)[0]+(s*dx[d])+(100000*N))%N;
			int ny = (cloud.get(i)[1]+(s*dy[d])+(100000*N))%N;
			if(nx>=0&&nx<N&&ny>=0&&ny<N) {
				cloud.set(i, new int[] {nx,ny});
			}
		}
		get_exist();
	}
	
	public static void rain() {
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(exist[i][j]==true) {
					map[i][j]+=1;
				}
			}
		}
	}
	
	public static void Wcopy() {
		for(int[] i :cloud) {
			int cnt=0;
			for(int j=0;j<4;j++) {
				int nx = i[0]+dx2[j];
				int ny = i[1]+dy2[j];
				if(nx>=0&&nx<N&&ny>=0&&ny<N&&map[nx][ny]!=0) {
					cnt++;
				}
			}
			map[i[0]][i[1]] +=cnt;
		}
	}
	
	
	public static void crecloud() {
		cloud.clear();
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(!exist[i][j]&&map[i][j]>=2) {
					map[i][j]-=2;
					cloud.add(new int[] {i,j});
				}
			}
		}
		get_exist();
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st ;
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		exist = new boolean[N][N];
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		exist[N-1][0] = true;exist[N-1][1] = true;exist[N-2][0] = true;exist[N-2][1] = true;
		get_cloud();
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int d = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			move(d,s);
			rain();
			Wcopy();
			crecloud();
			
		}
		int cnt=0;
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				cnt+=map[i][j];
			}
		}
		System.out.println(cnt);
	}
	
}
