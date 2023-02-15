package day0215;

import java.io.*;
import java.util.*;

public class Swea7699 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	
	static int n;
	static int m;
	
	public static void main(String[] args) throws IOException {
		int T=Integer.parseInt(br.readLine());
		for(int t=1;t<=T;t++) {
			st=new StringTokenizer(br.readLine());
			n=Integer.parseInt(st.nextToken());
			m=Integer.parseInt(st.nextToken());
			char[][] map=new char[n][m];
			for(int i=0;i<n;i++) {
				String word=br.readLine();
				for(int j=0;j<m;j++) {
					map[i][j]=word.charAt(j);
				}
			}
			
			array.add(map[0][0]);
			dfs(0,0,map,1);
			bw.write("#"+t+" "+cnt+"\n");
			array.clear();
			cnt=1;
		}
		bw.close();

	}
	
	static int[] dr= {1,-1,0,0};
	static int[] dc= {0,0,1,-1};
	static int cnt=1;
	static ArrayList<Character> array=new ArrayList<Character>();
	
	
	public static void dfs(int x, int y, char[][] map, int depth) {
		cnt=Math.max(cnt, depth);
	      for (int i = 0; i < 4; i++) {
	          int nx = x + dr[i];
	          int ny = y + dc[i];
	          if (nx >= 0 && ny >= 0 && nx < n && ny < m) {
	              if (!array.contains(map[nx][ny])) {
	            	  array.add(map[nx][ny]);

	                  dfs(nx, ny, map, depth + 1);
	                  array.remove(array.indexOf(map[nx][ny]));
	              }
	          }
	      }
	      return;
	  }
}
