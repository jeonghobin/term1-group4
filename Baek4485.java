package baek;

import java.io.*;
import java.util.*;

public class Baek4485 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	
	static class Point implements Comparable<Point>{
		int e,w;

		public Point(int e, int w) {
			super();
			this.e = e;
			this.w = w;
		}

		@Override
		public int compareTo(Point o) {
			// TODO Auto-generated method stub
			return this.w-o.w;
		}
	}
	
	static int N;
	static int[][]map;
	static ArrayList<Point>[]array;
	static int[]dist;
	
	static int[]dr= {1,-1,0,0};
	static int[]dc= {0,0,1,-1};

	public static void main(String[] args) throws IOException {
		int cnt=1;
		while(true) {
			N=Integer.parseInt(br.readLine());
			if(N==0)break;
			map=new int[N][N];
			for(int i=0;i<N;i++) {
				st=new StringTokenizer(br.readLine());
				for(int j=0;j<N;j++) {
					map[i][j]=Integer.parseInt(st.nextToken());
				}
			}
			
			array=new ArrayList[N*N];
			for(int i=0;i<N*N;i++) {
				array[i]=new ArrayList();
			}
			
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					for(int d=0;d<4;d++) {
						int nr=i+dr[d];
						int nc=j+dc[d];
						if(nr>=0&&nr<N&&nc>=0&&nc<N) {
							array[i*N+j].add(new Point(nr*N+nc, map[nr][nc]));
						}
					}
				}
			}
			
			dist=new int[N*N];
			Arrays.fill(dist, Integer.MAX_VALUE);
			
			PriorityQueue<Point>q=new PriorityQueue<>();
			dist[0]=map[0][0];
			q.add(new Point(0, map[0][0]));
			while(!q.isEmpty()) {
				Point p=q.poll();
				if(dist[p.e]<p.w) continue;
				
				for(Point np:array[p.e]) {
					int nw=dist[p.e]+np.w;
					if(nw<dist[np.e]) {
						dist[np.e]=nw;
						q.add(new Point(np.e, nw));
					}
				}
			}
			bw.write("Problem "+cnt+++": "+dist[N*N-1]+"\n");
		}
		
		bw.close();
	}
}
