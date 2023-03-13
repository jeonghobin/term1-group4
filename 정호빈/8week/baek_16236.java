import java.io.*;
import java.util.*;

public class Main {
    
	static int N,Fcnt=0;
	static int[][] map;
	static int[] dx = {0,1,0,-1};
	static int[] dy = {1,0,-1,0};
	static ArrayList<int[]> fish = new ArrayList<>();
	static PriorityQueue<int[]> eatfish = new PriorityQueue<>(new Comparator<int[]>() {
		public int compare(int[] o1, int[] o2) {
			if(o1[2]==o2[2]) {
				if(o1[0]==o2[0]) {
					return o1[1]-o2[1];
				}
				return o1[0]-o2[0];
			}
			return o1[2]-o2[2];
		};
	});
	static int[] shark = new int[3];
	private static int Tcnt=0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        
        for(int i=0;i<N;i++) {
        	st = new StringTokenizer(br.readLine());
        	for(int j=0;j<N;j++) {
        		map[i][j] = Integer.parseInt(st.nextToken());
        		if(map[i][j]!=0&&map[i][j]!=9) {
        			fish.add(new int[] {i,j,map[i][j]});
        		}
        		if(map[i][j]==9) {
        			shark[0] = i;
        			shark[1]=j;
        			shark[2]=2;
        		}
        		
        	}
        }
        while(check()) {
        	move();
        }
        System.out.println(Tcnt);
    }

	private static boolean check() {
		for(int[] i:fish) {
			if(i[2]<shark[2])return true;
		}
		return false;
	}
	// 멘허튼 거리가 시간임
	private static void move() {
		eatfish.clear();
		for(int[] i:fish) {
			if(i[2]<shark[2]) {
				int l =bfs(i[0],i[1]);
				if(l==0) {
					continue;
				}
				eatfish.offer(new int[] {i[0],i[1],l});
			}
		}
		if(!eatfish.isEmpty()) {
			int[] efish = eatfish.poll();
			map[shark[0]][shark[1]]=0;
			map[efish[0]][efish[1]]=9;
			shark[0] = efish[0];
			shark[1] = efish[1];
			Tcnt+=efish[2];
			Fcnt++;
			if(Fcnt==shark[2]) {
				shark[2]++;
				Fcnt=0;
			}
			get_fish();
		}else {
			System.out.println(Tcnt);
			System.exit(0);
		}
		
	}

	private static int bfs(int x, int y) {
		boolean[][] visited = new boolean[N][N];
		Queue<int[]> que = new LinkedList<>();
		que.offer(new int[] {shark[0],shark[1],0});
		visited[shark[0]][shark[1]]=true;
		while(!que.isEmpty()) {
			int[] a = que.poll();
			if(a[0]==x&&a[1]==y) {
				return a[2];
			}
			for(int i=0;i<4;i++) {
				int nx = a[0]+dx[i];
				int ny = a[1]+dy[i];
				if(nx>=0&&nx<N&&ny>=0&&ny<N&&!visited[nx][ny]&&map[nx][ny]<=shark[2]) {
					que.offer(new int[] {nx,ny,a[2]+1});
					visited[nx][ny] =true;
				}
			}
		}
		return 0;
	}

	private static void get_fish() {
		fish.clear();
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(map[i][j]!=0&&map[i][j]!=9) {
					fish.add(new int[] {i,j,map[i][j]});
				}
			}
		}
	}


	
	

}
