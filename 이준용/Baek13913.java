package day0218;

import java.io.*;
import java.util.*;

public class Baek13913 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static int N;
	static int K;
	static boolean[]v;
	static int[] dx= {1,-1};
	
	public static void main(String[] args) throws IOException {
		st=new StringTokenizer(br.readLine());
		N=Integer.parseInt(st.nextToken());
		K=Integer.parseInt(st.nextToken());
		v=new boolean[100050];
		
		
		int num=N;
		
		if(N!=K) {
			if(N>K) {
				bw.write((N-K)+"\n");
				for(int i=N;i>=K;i--) {
					bw.write(i+" ");
				}
			}
			else {
				bfs(N);
				bw.write(mincnt+"\n");
				bw.write(N+" ");
				for(int i=0; i<backlist.length();i++) {
					if(backlist.charAt(i)=='*') {
						num*=2;
						bw.write(num+" ");
					}
					else if(backlist.charAt(i)=='1') {
						num+=1;
						bw.write(num+" ");
					}
					else if(backlist.charAt(i)=='-') {
						num-=1;
						bw.write(num+" ");
					}
				}
			}
		}
		else {
			bw.write(mincnt+"\n");
			bw.write(N+"");
		}
		
		bw.close();
	}
	static class Point{
		int x,cnt;
		String back="";

		public Point(int x, int cnt, String back) {
			super();
			this.x = x;
			this.cnt = cnt;
			this.back = back;
		}
	}
	static int mincnt;
	static String backlist;

	private static void bfs(int x) {
		Queue<Point> q=new LinkedList<>();
		v[x]=true;
		q.offer(new Point(x, 0,""));
		while(!q.isEmpty()) {
			Point p=q.poll();
			for(int i=0;i<2;i++) {
				if(i==0) {
					int nx=p.x*2;
					if(nx>=0&&nx<100050&&v[nx]==false) {
						if(nx==K) {
							mincnt=p.cnt+1;
							backlist=p.back+"*";
							return;
						}
						v[nx]=true;
						q.add(new Point(nx, p.cnt+1, p.back+"*"));
					}
				}
				else {
					for(int d=0;d<2;d++) {
						int nx=p.x+dx[d];
						if(nx>=0&&nx<100050&&v[nx]==false) {
							if(nx==K) {
								mincnt=p.cnt+1;
								backlist=p.back+Integer.toString(dx[d]).charAt(0);
								return;
							}
							v[nx]=true;
							q.add(new Point(nx, p.cnt+1, p.back+Integer.toString(dx[d]).charAt(0)));
						}
					}
				}
			}
		}	
	}
}