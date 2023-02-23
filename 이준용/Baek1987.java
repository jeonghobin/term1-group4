package day0223;

import java.io.*;
import java.util.*;

public class Baek1987 {

	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	
	static int N;
	static int M;
	static char[][]map;
	static ArrayList<Character> array=new ArrayList<Character>();
	static int[]dr= {1,-1,0,0};
	static int[]dc= {0,0,1,-1};
	
	public static void main(String[] args) throws IOException {
		st=new StringTokenizer(br.readLine());
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		map=new char[N][M];
		for(int i=0;i<N;i++) {
			String word=br.readLine();
			for(int j=0;j<M;j++) {
				map[i][j]=word.charAt(j);
			}
		}
		array.add(map[0][0]);
		bfs(0,0);
		
		System.out.println(maxcnt);
	}
	static String answer;
	static int maxcnt;
	private static void bfs(int r, int c) {
		
		maxcnt=Math.max(maxcnt, array.size());
		
		for(int d=0;d<4;d++) {
			int nr=r+dr[d];
			int nc=c+dc[d];
			if(nr>=0&&nr<N&&nc>=0&&nc<M&&array.contains(map[nr][nc])==false) {
				array.add(map[nr][nc]);
				bfs(nr,nc);
				array.remove(array.indexOf(map[nr][nc]));
			}
		}
	}
}