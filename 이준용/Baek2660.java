package FloydWarchall;

import java.io.*;
import java.util.*;

public class Baek2660 {
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;


	public static void main(String[] args) throws IOException {
		int N=Integer.parseInt(br.readLine());
		int[][] map=new int[N][N];
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(i!=j)map[i][j]=100000;
			}
		}
		
		while(true) {
			st=new StringTokenizer(br.readLine());
			int s=Integer.parseInt(st.nextToken())-1;
			int e=Integer.parseInt(st.nextToken())-1;
			if(s==-2&&e==-2) break;
			map[s][e]=1;
			map[e][s]=1;
		}
		
		for(int k=0;k<N;k++) {
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					map[i][j]=Math.min(map[i][j], map[i][k]+map[k][j]);
				}
			}
		}
		
		int min=Integer.MAX_VALUE;
		int cnt=1;
		for(int i=0;i<N;i++) {
			Arrays.sort(map[i]);
			if(min>map[i][N-1]) {
				min=map[i][N-1];
				cnt=1;
			}
			else if(min==map[i][N-1]){
				cnt++;
			}
		}
		
		bw.write(min+" "+cnt+"\n");
		for(int i=0;i<N;i++) {
			if(map[i][N-1]==min)bw.write(i+1+" ");
		}
		bw.close();
	}
}
