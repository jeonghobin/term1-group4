package day0221;

import java.io.*;
import java.util.*;

public class Baek3109_2 {
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	
	static int R;
	static int C;
	static char[][]map;
	
	static int[]dr= {-1,0,1};
	
	public static void main(String[] args) throws IOException {
		st=new StringTokenizer(br.readLine());
		R=Integer.parseInt(st.nextToken());
		C=Integer.parseInt(st.nextToken());
		map=new char[R][C];
		for(int i=0;i<R;i++) {
			String word=br.readLine();
			for(int j=0;j<C;j++) {
				map[i][j]=word.charAt(j);
			}
		}
		
		for(int i=0;i<R;i++) {
			map[i][0]='x';
			recursive(i,0);
			check=false;
			if(map[R-1][C-1]=='X') break;
			
		}
		bw.write(cnt+"");
		bw.close();
	}

	static boolean check;
	static int cnt;
	
	private static void recursive(int r, int c) {
		if(check==true) return;
	
		if(c==C-1) {
			cnt++;
			check=true;
			return;
		}
		for(int d=0;d<3;d++) {
			int nr=r+dr[d];
			int nc=c+1;
			if(nr>=0&&nr<R&&nc<C&&map[nr][nc]=='.') {
				map[nr][nc]='x';
				recursive(nr,nc);
				if(check==true) return;
			}
		}
	}
}
