package baek;

import java.util.*;
import java.io.*;

public class Main {
	static int R,C,max=0;
	static char[][] map;
	static int[] dx = {0,1,0,-1};
	static int[] dy = {1,0,-1,0};
	static boolean[] Avisited = new boolean[26];
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st ;
		st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][C];
		for(int i=0;i<R;i++) {
			String str = br.readLine();
			map[i] = str.toCharArray();
		}
		
		dfs(0,0,1);
		System.out.println(max);
		
	}

	private static void dfs(int x, int y,int cnt) {
		Avisited[map[x][y]-'A']=true;
		
		for(int i=0;i<4;i++) {
			int nx = x+dx[i];
			int ny = y+dy[i];
			if(nx>=0&&nx<R&&ny>=0&&ny<C&&!Avisited[map[nx][ny]-'A']) {
				dfs(nx,ny,cnt+1);
			}
		}
		max = Math.max(max, cnt);
		
		Avisited[map[x][y]-'A']=false;
	}




	
	
}
