package day0406;

import java.io.*;
import java.util.*;

public class Baek16918 {
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	
	static int R,C,N;
	static char[][]map;
	static boolean[][]v;
	
	static int[]dr= {1,-1,0,0};
	static int[]dc= {0,0,1,-1};
	
	static class Point{
		int r,c,time;
		char type;
		public Point(int r, int c, int time, char type) {
			super();
			this.r = r;
			this.c = c;
			this.time = time;
			this.type = type;
		}
	}

	public static void main(String[] args) throws IOException {
		st=new StringTokenizer(br.readLine());
		R=Integer.parseInt(st.nextToken());
		C=Integer.parseInt(st.nextToken());
		N=Integer.parseInt(st.nextToken());
		map=new char[R][C];
		for(int i=0;i<R;i++) {
			String word=br.readLine();
			for(int j=0;j<C;j++) {
				map[i][j]=word.charAt(j);
			}
		}
		
		for(int t=0;t<N;t++) {
			if(t%2==0) {
				bfs(t);
				//ÆøÅº ¼³Ä¡
			}
			else if(t%2==1) {
				//ÅÍÁü
			}
		}
		
	}

	private static void bfs(int t) {
		Queue<Point>q=new LinkedList<>();
		for(int i=0;i<R;i++) {
			for(int j=0;j<C;j++) {
				if(map[i][j]=='O') {
					q.add(new Point(i, j, t, 'O'));
				}
			}
		}
		
	}

}
