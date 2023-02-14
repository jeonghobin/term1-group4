package day0214;

import java.io.*;
import java.util.*;

public class Baek2667 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	
	static int N;
	static int[][] map;
	static ArrayList<Integer> cntarray=new ArrayList<>();
	static int cnt=1;

	public static void main(String[] args) throws IOException {
		N=Integer.parseInt(br.readLine());
		map=new int[N][N];
		for(int i=0;i<N;i++) {
			String word=br.readLine();
			for(int j=0;j<N;j++) {
				map[i][j]=Character.getNumericValue(word.charAt(j));
			}
		}
		int count=0;
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(map[i][j]==1) {
					cnt=1;
					count++;
					bfs(i,j);
					cntarray.add(cnt);
				}
			}
		}
		cntarray.sort(Comparator.naturalOrder());
		bw.write(count+"\n");
		for(int i=0;i<count;i++) {
			bw.write(cntarray.get(i)+"\n");
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
		Queue<Point> q=new LinkedList<Point>();
		boolean[][] v=new boolean[N][N];
		
		v[i][j]=true;
		q.offer(new Point(i,j));
		
		while(!q.isEmpty()) {
			Point p = q.poll();
			map[p.r][p.c]=0;
			
			for(int d=0;d<4;d++) {
				int nr=p.r+dr[d];
				int nc=p.c+dc[d];
				if(nr>=0&&nr<N&&nc>=0&&nc<N&&v[nr][nc]==false&&map[nr][nc]==1) {
					cnt++;
					v[nr][nc]=true;
					q.add(new Point(nr,nc));
				}
			}
		}
	}
}
