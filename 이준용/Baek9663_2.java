package day0221;

import java.io.*;
import java.util.*;

public class Baek9663_2 {
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	
	static int N; 
	static int[] col;
	static int answer;

	public static void main(String[] args) throws IOException {
		N=Integer.parseInt(br.readLine());
		col=new int[N+1];
		
		setQueen(1);
		
		System.out.println(answer);
	}
	private static void setQueen(int rowNo) { //rowNo : 놓으려고 하는 퀸의 행 번호
		
		if(!isAvailable(rowNo-1)) return;
		
		if(rowNo>N) {
			answer+=1;
			return;
		}
		
		for(int c=1;c<=N;c++) {
			col[rowNo] = c;
			//다음 거 들어가기 전 검사후 진행할 수도 있음.
			setQueen(rowNo+1);
		}
		
	}
	private static boolean isAvailable(int rowNo) {
		for(int k=1;k<rowNo;k++) { // k : 비교대상 queen의 행. 이전에 먼저 담긴 queen 들과 비교.
			if(col[k]==col[rowNo] || //열 겹치는지 체크
					Math.abs(col[k]-col[rowNo])==rowNo-k) return false; // 대각선 겹치는지 체크
		}
		return true;
	}
}
