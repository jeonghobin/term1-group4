package com.ssafy.study.beakjoon.beak_2477;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//참외밭
//넓이 구하는 법 -> 가장 큰 가로*세로 - 작은 가로*세로
//1.가장 긴 가로와 세로의 길이를 구한다.
//반시계 방향
//2.가장 긴 가로 옆!!에 위치한 두 세로의 길이 차이가 작은 사각형의 세로가 된다.
//3.가장 긴 세로 옆!!에 위치한 두 가로의 길이 차이가 작은 사각형의 가로가 된다.
class Direction {
	int dir;
	int len;

	public Direction(int dir, int len) {
		this.dir = dir;
		this.len = len;
	}
}

public class Main {
	public static int maxX = Integer.MIN_VALUE;
	public static int maxY = Integer.MIN_VALUE;
	public static int minX = Integer.MAX_VALUE;
	public static int minY = Integer.MAX_VALUE;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());// 참외 개수
		Direction[] dc = new Direction[6];// 6각형
		for (int i = 0; i < 6; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			dc[i] = new Direction(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}

		int idX = 0;
		int idY = 0;
		
		for (int i = 0; i < dc.length; i++) {
			int d = dc[i].dir;
			if (d == 1 || d == 2) {
				if(maxX<dc[i].len) {
					maxX = Math.max(maxX, dc[i].len);
					idX = i;
				}
			}else {
				maxY = Math.max(maxY, dc[i].len);
				if(maxY<dc[i].len) {
					maxY = Math.max(maxY, dc[i].len);
					idY = i;
				}
				
			}
		}

//		//제일 큰 세로변의 인덱스 앞 뒤를 제일 큰 가로변으로 뺀 것중에 0이 아니면 잘린 가로변
		int fX = idX+1>dc.length-1?0:idX+1;
		int dX = idX-1<0?dc.length-1:idX-1;
		int fY= idY+1>dc.length-1?0:idY+1;
		int dY = idY-1<0?dc.length-1:idY-1;
//		System.out.println(fX+", "+dX+", "+fY+", "+dY+", ");
		minY = maxY-dc[fY].len==0? dc[dX].len : maxX-dc[dY].len ;
		minX = maxX-dc[fX].len==0? dc[dY].len : maxY-dc[fX].len ;

//		System.out.println(maxX+", "+maxY+", "+minX+", "+minY+", ");
		int wide = (maxX * maxY) - (minX * minY);
		System.out.println(wide*N);
		
	}
	
}
