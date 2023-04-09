package day0405;

import java.io.*;
import java.util.*;

public class Swea4014 {
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static int N,X;
	static int[][]map;
	static int[]dr= {1,0,-1,0};
	static int[]dc= {0,1,0,-1};
	public static void main(String[] args) throws IOException {
		int T=Integer.parseInt(br.readLine());
		for(int t=1;t<=T;t++) {
			st=new StringTokenizer(br.readLine());
			N=Integer.parseInt(st.nextToken());
			X=Integer.parseInt(st.nextToken());
			map=new int[N][N];
			for(int i=0;i<N;i++) {
				st=new StringTokenizer(br.readLine());
				for(int j=0;j<N;j++) {
					map[i][j]=Integer.parseInt(st.nextToken());
				}
			}
			for(int i=0;i<N;i++) {
				dfs(i,0,1,map[i][0],0);
				dfs(0,i,0,map[0][i],0);
			}
			bw.write("#"+t+" "+sum+"\n");
			sum=0;
		}
		bw.close();
	}
	static int sum;
	private static void dfs(int r, int c, int dir, int h, int cnt) {
		if(cnt==N-1) {
			sum++;
			return;
		}
		int nr=r+dr[dir];
		int nc=c+dc[dir];
		if(nr<N&&nc<N) {
			if(map[nr][nc]==h) {
				dfs(nr,nc,dir,h,cnt+1);
			}
			else if(map[nr][nc]==h+1) {		//뒤에 확인
				int nr2=nr;
				int nc2=nc;
				for(int x=0;x<X;x++) {
					nr2+=dr[dir+2];
					nc2+=dc[dir+2];
					if(nr2<0||nc2<0||map[nr2][nc2]!=h) return;
				}
				for(int x=0;x<X;x++) {
					nr2+=dr[dir+2];
					nc2+=dc[dir+2];
					if(nr2>=0&&nc2>=0&&map[nr2][nc2]>h) return;
				}
				dfs(nr,nc,dir,h+1,cnt+1);
			}
			else if(map[nr][nc]==h-1) {
				int nr2=nr;
				int nc2=nc;
				for(int x=0;x<X-1;x++) {
					nr2+=dr[dir];
					nc2+=dc[dir];
					if(nr2>=N||nc2>=N||map[nr2][nc2]!=h-1) return;
				}
				dfs(nr2,nc2,dir,h-1,cnt+X);
			}
			else if(Math.abs(map[nr][nc]-h)>=2) return;
		}
	}
}
