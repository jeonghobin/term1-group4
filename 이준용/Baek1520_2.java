package day0227;

import java.io.*;
import java.util.*;

public class Baek1520_2 {
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	
	static int N;
	static int M;
	static int[][][]map;
	static boolean[][]v;
	static int[]dr= {1,-1,0,0};
	static int[]dc= {0,0,1,-1};

	public static void main(String[] args) throws IOException {
		st=new StringTokenizer(br.readLine());
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		map=new int[2][N][M];
		v=new boolean[N][M];
		for(int i=0;i<N;i++) {
			st=new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) {
				map[0][i][j]=Integer.parseInt(st.nextToken());
			}
		}
		
		dfs(0,0);

		bw.write(cnt+"");
		
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				System.out.print(map[1][i][j]);
			}
			System.out.println();
		}
		bw.close();
	}
	
	static int cnt;
	 

	private static void dfs(int r, int c) {
		
		if(r==N-1&&c==M-1) {
			cnt++;
			
			return;
			
		}
		for(int d=0;d<4;d++) {
			int nr=r+dr[d];
			int nc=c+dc[d];
			if(nr>=0&&nr<N&&nc>=0&&nc<M&&v[nr][nc]==false&&map[0][r][c]>map[0][nr][nc]) {
				if(map[1][nr][nc]!=0) {
					cnt+=map[1][nr][nc];
					return;
				}
				
				v[nr][nc]=true;
				dfs(nr, nc);
				v[nr][nc]=false;
			}
		}
	}
}
