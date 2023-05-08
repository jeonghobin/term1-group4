import java.util.*;
import java.io.*;

public class Main {

	
	static int N,Bnum,Cnum;
	static List<int[]> listB = new ArrayList<>();
	static List<int[]> listE = new ArrayList<>();
	static char[][] map;
	static int[] dx = {0,1,0,-1,0};
	static int[] dy = {1,0,-1,0,0};
	static boolean[][][] v;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		map = new char[N][N];
		// 가로와 세로의 방문처리를 다르게 해준다.
		v = new boolean[2][N][N];
		// 입력 받기
		for(int i=0;i<N;i++) {
			String str = br.readLine();
			map[i] = str.toCharArray();
		}
		// 중간값을 찾기위해 값을 리스트에 담는다 여기서 순서대로 탐색하므로
		// 가로든 세로든 2번째로 들어간 값이 중간값이 된다.
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(map[i][j]=='B')listB.add(new int[] {i,j});
				if(map[i][j]=='E')listE.add(new int[] {i,j});
			}
		}
		//0 가로 , 1 세로
		int[] a = listB.get(1);
		int[] b = listB.get(0);
		if(a[0]==b[0])Bnum=0;
		if(a[1]==b[1])Bnum=1;
		//0가로 , 1세로
		a = listE.get(1);
		b = listE.get(0);
		if(a[0]==b[0])Cnum=0;
		if(a[1]==b[1])Cnum=1;
		
		Queue<int[]> que = new LinkedList<>();
		a = listB.get(1);
		// C의 중간값과 가로인지 세로인지를 배열에 저장
		int[] Cend= {listE.get(1)[0],listE.get(1)[1],Cnum};
		que.add(new int[] {a[0],a[1],Bnum,0});
		v[Bnum][a[0]][a[1]]=true;
		while(!que.isEmpty()) {
			a = que.poll();
			// 목적지의 형태와 좌표값이 같다면 현재까지의 카운트를 출력하고 메인함수를 종료한다.
			if(a[0]==Cend[0]&&a[1]==Cend[1]&&a[2]==Cend[2]) {
				System.out.println(a[3]);
				return;
			}
			for(int i=0;i<5;i++) {
				// 회전을 고려한다. 회전하고 다시 회전하지 않도록 하기위해
				// 방문처리를 해준다. 팔방에 1이 없는지 체크한다.
				// 돌렸을 때 값이 밖으로 나가는 것도 체크한다.
				if(i==4&&check(a[0],a[1],a[2])) {
					if(a[2]==0&&!v[1][a[0]][a[1]]) {
						que.add(new int[] {a[0],a[1],1,a[3]+1});
						v[1][a[0]][a[1]]=true;
					}else if(a[2]==1&&!v[0][a[0]][a[1]]) {
						que.add(new int[] {a[0],a[1],0,a[3]+1});
						v[0][a[0]][a[1]]=true;
					}
					continue;
				}
				// 상하좌우의 동작을 구현한다.
				// 이때 움직이고 가로인지 세로인지 판단하여 1을 만나는지 밖으로 나가게 되는지 체크한다.
				int nx = a[0]+dx[i];
				int ny = a[1]+dy[i];
				if(nx>=0&&nx<N&&ny>=0&&ny<N&&!v[a[2]][nx][ny]&&map[nx][ny]!='1') {
					//가로일때 양옆이 1에 만나는지 밖으로 나가는지 체크
					if(a[2]==0) {
						int flag=1;
						for(int j=0;j<4;j+=2) {
							int nr = nx+dx[j];
							int nc = ny+dy[j];
							if(nr<0||nr>=N||nc<0||nc>=N||map[nr][nc]=='1') {
								flag=0;
								break;
							}
						}
						if(flag==1) {
							que.add(new int[] {nx,ny,a[2],a[3]+1});
							v[a[2]][nx][ny]=true;
						}
					}
					// 세로 일때 상하가 1에 만나는지 밖으로 나가는지 체크
					else if(a[2]==1) {
						int flag=1;
						for(int j=1;j<4;j+=2) {
							int nr = nx+dx[j];
							int nc = ny+dy[j];
							if(nr<0||nr>=N||nc<0||nc>=N||map[nr][nc]=='1') {
								flag=0;
								break;
							}
						}
						if(flag==1) {
							que.add(new int[] {nx,ny,a[2],a[3]+1});
							v[a[2]][nx][ny]=true;
						}
					}
				}
				
			}
		}
		//종료되지 않았다면 목적지에 도착하지 못한것이므로 0을 출력한다.
		System.out.println(0);
		
	}
	
	// 회전이 가능한지 체크하는 함수
	private static boolean check(int x, int y,int num) {
		if(num==0) {
			for(int i=1;i<4;i+=2) {
				int nx = x+dx[i];
				int ny = y+dy[i];
				if(nx<0||nx>=N||ny<0||ny>=N)return false;
			}
		}else if(num==1) {
			for(int i=0;i<4;i+=2) {
				int nx = x+dx[i];
				int ny = y+dy[i];
				if(nx<0||nx>=N||ny<0||ny>=N)return false;
			}
		}
		int[] dr = {0,1,1,1,0,-1,-1,-1};
		int[] dc = {1,1,0,-1,-1,-1,0,1};
		for(int i=0;i<8;i++) {
			int nx = x+dr[i];
			int ny = y+dc[i];
			if(nx>=0&&nx<N&&ny>=0&&ny<N) {
				if(map[nx][ny]=='1')return false;
			}
		}
		return true;
	}

}
