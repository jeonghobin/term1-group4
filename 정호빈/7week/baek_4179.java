import java.util.*;
import java.io.*;


public class Main {

	static int N,M;
	static char[][] map;
	static int[] dx = {0,1,0,-1};
	static int[] dy = {1,0,-1,0};
	static int cnt=0;
	static int flag=1;
	
	
	public static void main(String[] args) throws Exception {
        // TODO Auto-generated method stub
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st ;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new char[N][M];
        for(int i=0;i<N;i++) {
        	String str = br.readLine();
        	map[i] = str.toCharArray();
        }
        
        bfs();
        
        if(flag==1) {
        	System.out.println(cnt);
        }else {
        	System.out.println("IMPOSSIBLE");
        }
        
    }

	private static void bfs() {
		Queue<int[]> quef = new LinkedList<>();
		Queue<int[]> quej = new LinkedList<>();
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(map[i][j]=='F') {
					quef.offer(new int[] {i,j});
				}
				if(map[i][j]=='J') {
					quej.offer(new int[] {i,j});
				}
			}
		}
		while(!quej.isEmpty()) {
			int size = quef.size();
			for(int i=0;i<size;i++) {
				int[] a = quef.poll();
				for(int j=0;j<4;j++) {
					int nx = a[0]+dx[j];
					int ny = a[1]+dy[j];
					if(nx>=0&&nx<N&&ny>=0&&ny<M&&map[nx][ny]!='#'&&map[nx][ny]!='F') {
						map[nx][ny] = 'F';
						quef.offer(new int[] {nx,ny});
					}
				}
			}
			size = quej.size();
			for(int i=0;i<size;i++) {
				int[] a = quej.poll();
				for(int j=0;j<4;j++) {
					int nx = a[0]+dx[j];
					int ny = a[1]+dy[j];
					if(nx>=0&&nx<N&&ny>=0&&ny<M) {
						if(map[nx][ny]=='.') {
							map[nx][ny] = 'J';
							quej.offer(new int[] {nx,ny});
						}
					}else {
						cnt++;
						return;
					}
				}
			}
			cnt++;
		}
		flag=0;
	}


}
