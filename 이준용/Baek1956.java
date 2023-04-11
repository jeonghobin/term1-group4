package FloydWarchall;

import java.io.*;
import java.util.*;

public class Baek1956 {
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	
	static int V,E;
	static int[][]map;


	public static void main(String[] args) throws IOException {
		st=new StringTokenizer(br.readLine());
		V=Integer.parseInt(st.nextToken());
		E=Integer.parseInt(st.nextToken());
		map=new int[V][V];
		for(int i=0;i<V;i++) {
			for(int j=0;j<V;j++) {
				if(i==j) map[i][j]=0;
				else map[i][j]=10000000;
			}
		}
		
		for(int i=0;i<E;i++) {
			st=new StringTokenizer(br.readLine());
			int s=Integer.parseInt(st.nextToken())-1;
			int e=Integer.parseInt(st.nextToken())-1;
			int w=Integer.parseInt(st.nextToken());
			map[s][e]=w;
		}
		
		for(int k=0;k<V;k++) {
			for(int i=0;i<V;i++) {
				for(int j=0;j<V;j++) {
					map[i][j]=Math.min(map[i][j], map[i][k]+map[k][j]);
				}
			}
		}
		
		int ans=Integer.MAX_VALUE;
		for(int i=0;i<V;i++) {
			for(int j=0;j<V;j++) {
				if(map[i][j]>0&&map[i][j]<=V*10000&&map[j][i]>0&&map[j][i]<=V*10000) {
					ans=Math.min(ans, map[i][j]+map[j][i]);
				}
			}
		}
		
		if(ans==Integer.MAX_VALUE)ans=-1;
		bw.write(ans+"");
		bw.close();
	}
}
