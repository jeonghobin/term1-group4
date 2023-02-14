package day0214;

import java.io.*;
import java.util.*;

public class Baek4963 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	
	static byte H;
	static byte W;
	static byte[][] map;
	static boolean[][] v;
	static byte[] dr = {-1,-1,-1,0,0,1,1,1};
	static byte[] dc = {-1,0,1,-1,1,-1,0,1};
	
	static class Point{
		byte r,c;
		public Point(byte r, byte c) {
			super();
			this.r = r;
			this.c = c;
		}
	}
	public static void main(String[] args) throws IOException {
		while(true) {
			st=new StringTokenizer(br.readLine());
			W=Byte.parseByte(st.nextToken());
			H=Byte.parseByte(st.nextToken());
			if(W==0) {
				break;
			}
			map=new byte[H][W];
			v = new boolean[H][W];
			for(byte i=0;i<H;i++) {
				st=new StringTokenizer(br.readLine());
				for(byte j=0;j<W;j++) {
					map[i][j]=Byte.parseByte(st.nextToken());
				}
			}
			
			int count=0;
			for(byte i=0;i<H;i++) {
				for(byte j=0;j<W;j++) {
					if(map[i][j]==1) {
						count++;
						bfs(i,j);
					}
				}
			}
			bw.write(count+"\n");
		}
		bw.close();

	}
	private static void bfs(byte i, byte j) {
		for(byte i1=0;i1<H;i1++) {
			for(byte j1=0;j1<W;j1++) {
				v[i1][j1]=false;
			}
		}
		
		Queue<Point> q = new LinkedList<Point>();
		
		v[i][j]=true;
		q.offer(new Point(i,j));
		while(!q.isEmpty()) {
			Point p=q.poll();
			map[p.r][p.c]=0;
			
			for(byte d=0;d<8;d++) {
				byte nr=(byte) (p.r+dr[d]);
				byte nc=(byte) (p.c+dc[d]);
				if(nr>=0&&nr<H&&nc>=0&&nc<W&&v[nr][nc]==false) {
					v[nr][nc]=true;
					if(map[nr][nc]==1) {
						//System.out.println("nr : "+nr +", nc : "+nc);
						q.add(new Point(nr,nc));
					}
				}
			}
		}
//		for(byte i1=0;i1<H;i1++) {
//			for(byte j1=0;j1<W;j1++) {
//				System.out.print(v[i1][j1]);
//			}
//			System.out.println();
//		}
//		System.out.println();
	}
}
