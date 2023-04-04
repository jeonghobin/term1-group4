package com.ssafy.study.beakjoon.달이차오른다가자_1194_Re;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//3차원 방문배열만으로는 통과되지 않는다. 비트마스킹 사용!!
public class Main {
 
	static int N,M,Ans=Integer.MAX_VALUE;
	static char[][] map;
	static boolean[][][] v;
	
	static char[] key = {'a', 'b', 'c', 'd', 'e', 'f'};
	static char[] door = {'A', 'B', 'C', 'D', 'E', 'F'};
	static int[] dr = {0,0,-1,1};
	static int[] dc = {-1,1,0,0};
	
	static Point current;
	
	private static class Point{
		int r,c,cnt,key;

		public Point(int r, int c, int cnt, int key) {
			super();
			this.r = r;
			this.c = c;
			this.cnt = cnt;
			this.key = key;
		}

		@Override
		public String toString() {
			return "Point [r=" + r + ", c=" + c + ", cnt=" + cnt + ", key=" + key + "]";
		}

	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new char[N][M];
		v = new boolean[N][M][7];
		
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = str.charAt(j);
				
				if(map[i][j]=='0')
					current = new Point(i, j, 0,0);
			}
		}
		
		BFS();
		System.out.println(Ans==Integer.MAX_VALUE?-1:Ans);
	}
	
	private static void print() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
					System.out.print(map[i][j]+ " ");
			}
			System.out.println();
		}
	}
   
	private static void BFS() {
		Queue<Point> Q = new LinkedList<>();
		ArrayList<Character> savekey = new ArrayList<>();
		Q.add(current); 
		v[current.r][current.c][0] = true;
		
		while (!Q.isEmpty()) {
			Point p = Q.poll(); 
			if(map[p.r][p.c]=='1') {
				Ans = Math.min(Ans, p.cnt);
				break;
			}
			
			K:for (int d = 0; d < 4; d++) {
				int nr = p.r + dr[d];
				int nc = p.c + dc[d];
				int nkey = p.key;
				
				if(nr>=0 && nc>=0 && nr<N && nc<M && !v[nr][nc][p.key] && map[nr][nc]!='#') {
					// 키를 만났을 경우 키를 습득한다
					if (map[nr][nc] >= 'a' && map[nr][nc] <= 'f') {
						//비트연산 2진수
						//ex)1>>3 -> 0001
						//ex)1<<3 -> 1000
						//ex)1000|0101 -> 1101
						nkey = nkey | (1 << (map[nr][nc] - 'a'));
					}
					// 문을 만났을 경우 키의 여부를 확인하고 그에 따라 이동한다
					if (map[nr][nc] >= 'A' && map[nr][nc] <= 'F') {
						// >0 키가 있다면 == 0 키가 없다면
						// continue 해서 이동하지 못하게 한다
						if ((nkey & (1 << (map[nr][nc] - 'a'))) == 0) {
							continue;
						}
					}
					v[nr][nc][nkey] = true;
					Q.add(new Point(nr, nc, p.cnt + 1, nkey));
					
//					if(map[nr][nc]=='.') {
//						v[nr][nc][p.key] = true;
//						Q.add(new Point(nr, nc, p.cnt+1,p.key));
//					}
//					
//					// 키를 만났을 경우 키를 습득한다    
//					for (int j = 0; j < key.length; j++) {
//						if(key[j]==map[nr][nc]) {
//							Q.clear();
//							map[nr][nc] = '.';
//							savekey.add(key[j]);
//							
//							int visit = key[j]-96;
//							Q.add(new Point(nr, nc, p.cnt+1, visit));
//							v[nr][nc][visit] = true;
//							break K;
//						}
//					}    
//			
//					// 문을 만났을 경우 키의 여부를 확인하고 그에 따라 이동한다
//					for (int j = 0; j < door.length; j++) {
//						if(door[j]==map[nr][nc]) {
//							for (int k = 0; k < savekey.size(); k++) {
//								if(savekey.get(k) == map[nr][nc]-('A'-'a')) {
//									v[nr][nc][p.key] = true;
//									map[nr][nc] = '.';
//									Q.add(new Point(nr, nc, p.cnt+1,p.key));
//									
//								}
//							}
//						}
//					}		
					
					
				}
			}
			
		}
		
	}
}