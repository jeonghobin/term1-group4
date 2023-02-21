package day0221;

import java.io.*;
import java.util.*;

public class Baek2580_2 {
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;

	static int [][] map;
	static class Point{
		int r,c;
		Point(int r, int c){
			this.r=r;
			this.c=c;
		}
	}
	static ArrayList<Point>list = new ArrayList<>();
	public static void main(String[] args) throws Exception {
		map = new int[9][9];
		
		for (int r = 0; r < 9; r++) {
			st=new StringTokenizer(br.readLine());
			for (int c = 0; c < 9; c++) {
				map[r][c]=Integer.parseInt(st.nextToken());
				if(map[r][c]==0)
					list.add(new Point(r, c));
			}
		}
		//System.out.println(list.size());
		//print(map);
		solve(0);
		
	}
	// k : 빈좌표 index 
	private static void solve(int k) {
		// basis part
		if(k==list.size()) {
			print(map);
			System.exit(0);
			return;
		}
		
		// inductive part
		int r = list.get(k).r;
		int c = list.get(k).c;
		
		for (int i = 1; i <= 9; i++) {
			// 가지치기
			if(check(r,c,i)) {
				map[r][c]=i;
				solve(k+1);
				map[r][c]=0;
			}
		}
	}
	// 중복되는 값이 없으면 true;
	// 아니면 false;
	private static boolean check(int r, int c, int d) {
		for(int i=0;i<9;i++) {
			if(map[r][i]==d||map[i][c]==d) {
				if(d!=0) return false;
			}
		}
		for(int x=(r/3)*3;x<(r/3)*3+3;x++) {
			for(int y=(c/3)*3;y<(c/3)*3+3;y++) {
				if(map[x][y]==d) {
					if(d!=0) return false;
				}
			}
		}
		return true;
	}
	
	private static void print(int[][] map) {
		for (int r = 0; r < 9; r++) {
			for (int c = 0; c < 9; c++) {
				System.out.print(map[r][c]+" ");
			}
			System.out.println();
		}
		System.out.println();
	}
}

