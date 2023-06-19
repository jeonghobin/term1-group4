package FloydWarchall;

import java.io.*;
import java.util.*;

public class Baek2617 {
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;


	public static void main(String[] args) throws IOException {
		st=new StringTokenizer(br.readLine());
		int N=Integer.parseInt(st.nextToken());
		int M=Integer.parseInt(st.nextToken());
		int[][]map=new int[N][N];
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(i!=j) {
					map[i][j]=100000;
				}
			}
		}
		for(int i=0;i<M;i++) {
			st=new StringTokenizer(br.readLine());
			int s=Integer.parseInt(st.nextToken())-1;
			int e=Integer.parseInt(st.nextToken())-1;
			if(s==e) continue;
			map[s][e]=1;
		}
		for(int k=0;k<N;k++) {
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					map[i][j]=Math.min(map[i][j], map[i][k]+map[k][j]);
				}
			}
		}
		
//		for(int i=0;i<N;i++) {
//			for(int j=0;j<N;j++) {
//				System.out.print(map[i][j]+"\t");
//			}
//			System.out.println();
//		}
		
		int cnt=0;
		for(int i=0;i<N;i++) {
			int subcnt=0;
			int subcnt2=0;
			for(int j=0;j<N;j++) {
				if(map[i][j]>0&&map[i][j]!=100000) {
					subcnt++;
				}
				if(map[j][i]>0&&map[j][i]!=100000) {
					subcnt2++;
				}
			}
			if(subcnt>=(N+1)/2||subcnt2>=(N+1)/2) {
				cnt++;
			}
		}
		
		bw.write(cnt+"");
		bw.close();	
	}
}
