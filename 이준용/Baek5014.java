package day0218;

import java.io.*;
import java.util.*;

public class Baek5014 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	
	static int F;
	static boolean[]v;
	static int S;
	static int G;

	static int[] dx;
	
	public static void main(String[] args) throws IOException {
		st=new StringTokenizer(br.readLine());
		F=Integer.parseInt(st.nextToken());
		S=Integer.parseInt(st.nextToken())-1;
		G=Integer.parseInt(st.nextToken())-1;
		dx=new int[] {Integer.parseInt(st.nextToken()),-Integer.parseInt(st.nextToken())};

		v=new boolean[F];
		if(S!=G) {
			method(S);
		}

		if(mincnt==-1) {
			bw.write("use the stairs");
		}
		else {
			bw.write(mincnt+"");
		}
		bw.close();
	}
	static class Point{
		int x,cnt;
		public Point(int x, int cnt) {
			super();
			this.x = x;
			this.cnt=cnt;
		}
	}
	
	static int mincnt;

	private static void method(int x) {
		Queue<Point> q=new LinkedList<>();
		v[x]=true;
		q.offer(new Point(x,0));
		while(!q.isEmpty()) {
			Point p=q.poll();
			for(int d=0;d<2;d++) {
				int nx=p.x+dx[d];
				if(nx>=0&&nx<F&&v[nx]==false) {
					if(nx==G) {
						mincnt=p.cnt+1;
						return;
					}
					v[nx]=true;
					q.add(new Point(nx, p.cnt+1));
				}
			}
		}
		mincnt=-1;
	}
}
