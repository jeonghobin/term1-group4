package day0304;

import java.io.*;
import java.util.*;

public class Baek16236 {
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;

	static int N;
	static int[][]map;
	static boolean[][]v;
	static int[]dr= {-1,0,0,1};
	static int[]dc= {0,-1,1,0};
	
	static int fishcnt;
	static ArrayList<Integer>fishlist=new ArrayList<>();
	
	static class Point implements Comparable<Point>{
		int r,c,s,cnt,nowfish,total;

		public Point(int r, int c, int s, int cnt, int fish, int total) {
			super();
			this.r = r;
			this.c = c;
			this.s = s;
			this.cnt = cnt;
			this.nowfish = fish;
			this.total = total;
		}

		@Override
		public int compareTo(Point o) {
			// TODO Auto-generated method stub
			return (this.r==o.r)?Integer.compare(this.c, o.c):Integer.compare(this.r, o.r);
		}
	}
	
	public static void main(String[] args) throws IOException {
		N=Integer.parseInt(br.readLine());
		map=new int[N][N];
		v=new boolean[N][N];
		for(int i=0;i<N;i++) {
			st=new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
				if(map[i][j]>0&&map[i][j]!=9) {
					fishcnt++;
					fishlist.add(map[i][j]);
				}
			}
		}
		fishlist.sort(Comparator.naturalOrder());
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(map[i][j]==9) {
					bfs(i,j);
					break;
				}
			}
		}
		System.out.println(lastcheck);
	}
	static int lastcheck;

	private static void bfs(int r, int c) {
		Queue<Point>q=new LinkedList<>();
		PriorityQueue<Point>q2=new PriorityQueue<>();
		v[r][c]=true;
		q.offer(new Point(r, c, 2, 0, 0, 0));
		while(!q.isEmpty()) {
			int size=q.size();
			for(int si=0;si<size;si++) {
				Point p=q.poll();
				for(int d=0;d<4;d++) {
					int nr=p.r+dr[d];
					int nc=p.c+dc[d];
					if(nr>=0&&nr<N&&nc>=0&&nc<N&&v[nr][nc]==false) {
						if(map[nr][nc]==0||map[nr][nc]==9) {
							v[nr][nc]=true;
							q.add(new Point(nr, nc, p.s, p.cnt+1, p.nowfish, p.total));
						}
						else {
							if(map[nr][nc]<p.s) {
								v[nr][nc]=true;
								if(p.nowfish+1==p.s) {
									q2.offer(new Point(nr, nc, p.s+1, p.cnt+1, 0, p.total+1));
								}
								else {
									q2.offer(new Point(nr, nc, p.s, p.cnt+1, p.nowfish+1, p.total+1));
								}
							}
							else if(map[nr][nc]==p.s) {
								v[nr][nc]=true;
								q.add(new Point(nr, nc, p.s, p.cnt+1, p.nowfish, p.total));
							}
						}
					}
				}
			}
			if(q2.size()!=0) {	
				Point np=q2.poll();
				v=new boolean[N][N];
				v[np.r][np.c]=true;
				q.clear();
				q2.clear();
				q.add(np);
				
				lastcheck=np.cnt;
				fishlist.remove(fishlist.indexOf(map[np.r][np.c]));
				map[np.r][np.c]=0;
			}
		}
	}
}
