import java.io.*;
import java.util.*;



public class Main {
	
	static int[][] p;
	static int N;
	
 	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		p = new int[1000001][2];
		for(int i=1;i<1000001;i++) {
			p[i][0]=i;
			p[i][1]=1;
		}
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			String str = st.nextToken();
			if(str.equals("I")) {
				int a=Integer.parseInt(st.nextToken());
				int b=Integer.parseInt(st.nextToken());
				union(a,b);
			}else {
				int a = Integer.parseInt(st.nextToken());
				bw.write(p[find(a)][1]+"\n");
			}
		}
		bw.flush();
		bw.close();
		
	}

 	public static int find(int a) {
 		if(p[a][0]==a)return a;
 		return p[a][0] = find(p[a][0]);
 	}
	
 	public static void union(int a,int b) {
 		int pa = find(a);
 		int pb = find(b);
 		if(pa!=pb) {
 			p[pa][0]=pb;
 			p[pb][1]+=p[pa][1];
 			p[pa][1]=0;
 		}
 		
 	}


	
	

}
