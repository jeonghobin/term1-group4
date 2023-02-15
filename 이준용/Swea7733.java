package day0215;

import java.io.*;
import java.util.*;

public class Swea7733 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	
	static int n;
	static int[][] map;
	static boolean[][] v;
	static ArrayList<Integer> array=new ArrayList<Integer>();
	
	public static void main(String[] args) throws IOException {
		int T=Integer.parseInt(br.readLine());
		for(int t=1;t<=T;t++) {
			n=Integer.parseInt(br.readLine());
			map=new int[n][n];
			v=new boolean[n][n];
			
			for(int i=0;i<n;i++) {
				st=new StringTokenizer(br.readLine());
				for(int j=0;j<n;j++) {
					map[i][j]=Integer.parseInt(st.nextToken());
					if(!array.contains(map[i][j])) {
						array.add(map[i][j]);
					}
				}
			}
			array.add(0);
			array.sort(Comparator.naturalOrder());
			
			int maxcnt=0;
			for(int d=0;d<array.size();d++) {
				int cnt=0;
				int day=array.get(d);
				for(int i=0;i<n;i++) {
					for(int j=0;j<n;j++) {
						if(map[i][j]<=day) {
							map[i][j]=0;
						}
						v[i][j]=false;
					}
				}
				for(int i=0;i<n;i++) {
					for(int j=0;j<n;j++) {
						if(map[i][j]>day&&v[i][j]==false) {
							cnt++;
							bfs(i,j);
						}
					}
				}
				maxcnt=Math.max(maxcnt, cnt);
			}
			
			bw.write("#"+t+" "+maxcnt+"\n");
		}
		bw.close();
	}
	static class Point{
		int r,c;

		public Point(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
	}
	
	static int[] dr= {1,-1,0,0};
	static int[] dc= {0,0,1,-1};

	
	private static void bfs(int i, int j) {
		Queue<Point> q =new LinkedList();
		
		v[i][j]=true;
		q.offer(new Point(i,j));
		
		while(!q.isEmpty()) {
			Point p=q.poll();
			
			for(int d=0;d<4;d++) {
				int nr=p.r+dr[d];
				int nc=p.c+dc[d];
				
				if(nr>=0&&nr<n&&nc>=0&&nc<n&&v[nr][nc]==false&&map[nr][nc]>0) {
					v[nr][nc]=true;
					q.add(new Point(nr,nc));
				}
			}
		}
	}
}
