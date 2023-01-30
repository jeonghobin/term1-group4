import java.util.*;
import java.io.*;


public class Main {
	
	static int[] output;
	static boolean[] visited;
	static int N;
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		output = new int[N];
		visited = new boolean[N];
		perm(0,0);
		
	}
	
	public static void perm(int cnt,int depth) {
		if(cnt==N) {
			for(int i : output) {
				System.out.print((i+1)+" ");
			}
			System.out.println();
		}
		
		for(int i=0;i<N;i++) {
			if(!visited[i]) {			
				visited[i] = true;
				output[depth] = i;
				perm(cnt+1,depth+1);
				visited[i] = false;
				output[depth] = 0;
			}
		}
	}
}
