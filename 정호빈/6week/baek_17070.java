import java.util.*;
import java.io.*;
public class Main {
    static int[] dx = {0,1,1};
    static int[] dy = {1,1,0};
	static int[][] dir = {{0,1},{0,1,2},{1,2}};
 	static int N,M,ans=0;
 	static int[][]map;
 	static ArrayList<int[]> list = new ArrayList<>();
 	
	public static void main(String[] args) throws Exception {
        // TODO Auto-generated method stub
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st ;
        st =new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        map=new int[N][N];
        for(int i=0;i<N;i++) {
        	st = new StringTokenizer(br.readLine());
        	for(int j=0;j<N;j++) {
        		map[i][j]= Integer.parseInt(st.nextToken());
        	}
        }
        
        
        dfs(0,1,0);
       
        System.out.println(ans);

        
    }

	private static void dfs(int x, int y,int d) {
		if(x==N-1&&y==N-1) {
			ans++;
			return;
		}
		for(int i=0;i<dir[d].length;i++) {
			int dnum = dir[d][i];
			int nx = x+dx[dnum];
			int ny = y+dy[dnum];
			if(nx>=0&&nx<N&&ny>=0&&ny<N&&map[nx][ny]!=1) {
				if(dnum==1&&(map[nx-1][ny]==1||map[nx][ny-1]==1))continue;
				dfs(nx,ny,dnum);
			}
		}
		
		
		
	}
	
	

	
	

}
