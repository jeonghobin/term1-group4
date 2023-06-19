import java.io.*;
import java.util.*;

public class Main {
	
	static int N,flag,cnt;
	static List<Integer>[] g ;
	static boolean[] v,v2;
	
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		N=Integer.parseInt(br.readLine());
		g = new LinkedList[N+1];
		v = new boolean[N+1];
		for(int i=1;i<=N;i++) {
			g[i] = new LinkedList<>();
		}
		
		for(int i=1;i<=N;i++) {
			int a = Integer.parseInt(br.readLine());
			g[i].add(a);
		}
		for(int i=1;i<=N;i++) {
			flag=0;
			v2 = new boolean[N+1];
			dfs(i,i);
			if(flag==1) {
				v[i]=true;
				cnt++;
			}
		}
		System.out.println(cnt);
		for(int i=1;i<=N;i++) {
			if(v[i])System.out.println(i);
		}
	}

	
	
	private static void dfs(int i,int num) {
		
		v2[i] = true;
		for(int j:g[i]) {
			if(j==num)flag=1;
			if(v2[j])continue;
			dfs(j,num);
		}
		
	}


	

	
	
	

	
	
	
	

}
