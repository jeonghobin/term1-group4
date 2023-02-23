package day0223;

import java.io.*;
import java.util.*;

public class Baek1260 {
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	
	static int N;
	static int M;
	static int K;
	static boolean[] v;
	static boolean[] v2;
	static LinkedList<Integer>[] list;

	public static void main(String[] args) throws IOException {
		st=new StringTokenizer(br.readLine());
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		K=Integer.parseInt(st.nextToken());
		
		v=new boolean[N+1];
		v2=new boolean[N+1];
		
		list=new LinkedList[N+1];
		
		for(int i=0; i<=N;i++) {
			list[i]=new LinkedList<Integer>();
		}
		
		for(int i=0;i<M;i++) {
			st=new StringTokenizer(br.readLine());
			int s=Integer.parseInt(st.nextToken());
			int e=Integer.parseInt(st.nextToken());
			list[s].add(e);
			list[e].add(s);
		}
		
		for(int i=0;i<N+1;i++) {
			list[i].sort(Comparator.naturalOrder());
		}
		
		dfs(K);
		System.out.println();
		bfs(K);

	}

	private static void bfs(int k) {
		Queue<Integer>q=new LinkedList<Integer>();
		v2[k]=true;
		q.add(k);
		
		while(!q.isEmpty()) {
			int a=q.poll();
			System.out.print(a+" ");
			
			Iterator<Integer> it=list[a].listIterator();
			while(it.hasNext()) {
				int b=it.next();
				if(v2[b]==false) {
					v2[b]=true;
					q.add(b);
				}
			}
		}
	}

	private static void dfs(int k) {
		v[k]=true;
		System.out.print(k+" ");
		
		Iterator<Integer> it=list[k].listIterator();
		while(it.hasNext()) {
			int a=it.next();
			if(v[a]==false) {
				dfs(a);
			}
		}
	}

}
