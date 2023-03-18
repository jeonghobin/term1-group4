package day0314;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Baek2615 {
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	
	static int[][]map=new int[19][19];
	static boolean[][]v=new boolean[19][19];
	
	static int[]dr= {-1,-1,-1,0,1,1,1,0};
	static int[]dc= {-1,0,1,1,1,0,-1,-1};

	public static void main(String[] args) throws IOException {
		for(int i=0;i<19;i++) {
			st=new StringTokenizer(br.readLine());
			for(int j=0;j<19;j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i=0;i<19;i++) {
			for(int j=0;j<19;j++) {
				if(map[i][j]!=0) {
					for(int d=0;d<8;d++) {
						int nr=i+dr[d];
						int nc=j+dc[d];
						if(nr>=0&&nr<19&&nc>=0&&nc<19) {
							if(v[nr][nc]==true) continue;
							v[i][j]=true;
							recursive(i,j,i,j,map[i][j],d,1);
							//v[i][j]=false;
						}
					}
				}
			}
		}
	}
	
	static int win;

	private static void recursive(int sr, int sc, int r, int c, int type, int dir, int cnt) {
		if(cnt==5) {
			int nr=r+dr[dir];
			int nc=c+dc[dir];
			if((nr>=0&&nr<19&&nc>=0&&nc<19&&map[nr][nc]!=type)||(nr<0||nr>=19||nc<0||nc>=19)) {
				win=type;
				System.out.println(win);
				System.out.println((sr+1)+" "+(sc+1));
				System.exit(0);
			}
			return;
		}

		
		for(int d=0;d<8;d++) {
			int nr=r+dr[d];
			int nc=c+dc[d];
			if(nr>=0&&nr<19&&nc>=0&&nc<19&&map[nr][nc]==type&&v[nr][nc]==false) {
				//if(v[nr][nc]==true) continue;
				v[nr][nc]=true;
				if(dir==d) {
					recursive(sr,sc,nr,nc,type,d,cnt+1);
				}
				else {
					recursive(nr,nc,nr,nc,type,d,1);
				}
				//v[nr][nc]=false;
			}
		}
	}
}
