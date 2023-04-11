package day0405;

import java.io.*;
import java.util.*;

public class Baek17472 {
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;

	static int N,M;
	static int[][]map;
	static boolean[][]v;
	
	static int[]dr= {1,-1,0,0};
	static int[]dc= {0,0,1,-1,};

	public static void main(String[] args) throws IOException {
		st=new StringTokenizer(br.readLine());
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		map=new int[N][M];
		
		int num=0;
		for(int i=0;i<N;i++) {
			st=new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) {
				boolean check=false;
				int a=Integer.parseInt(st.nextToken());
				if(a==1) {
					for(int d=0;d<4;d++) {
						int nr=i+dr[d];
						int nc=j+dc[d];
						if(nr>=0&&nr<N&&nc>=0&&nc<M) {
							if(map[nr][nc]!=0) {
								map[i][j]=map[nr][nc];
								check=true;
								break;
							}
						}
					}
					if(!check) {
						num++;
						map[i][j]=num;
					}
				}
			}
		}
		
		

	}

}
