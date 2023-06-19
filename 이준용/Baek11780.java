package FloydWarchall;

import java.io.*;
import java.util.*;

public class Baek11780 {
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;


	public static void main(String[] args) throws IOException {
		int N=Integer.parseInt(br.readLine());
		int M=Integer.parseInt(br.readLine());
		int[][]map=new int[N][N];
		int[][]map2=new int[N][N];
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(i!=j) map[i][j]=10000000;
			}
		}
		
		for(int i=0;i<M;i++) {
			st=new StringTokenizer(br.readLine());
			int s=Integer.parseInt(st.nextToken())-1;
			int e=Integer.parseInt(st.nextToken())-1;
			int w=Integer.parseInt(st.nextToken());
			map[s][e]=w;
		}
		
		for(int k=0;k<N;k++) {
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					if(map[i][j]<map[i][k]+map[k][j]) {
						map[i][j]=map[i][k]+map[k][j];
						map2[i][j]=k;
					}
					
					
				}
			}
		}
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				System.out.print(map2[i][j]+"\t");
			}
			System.out.println();
		}
	}

}
