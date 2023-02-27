package day0227;

import java.io.*;
import java.util.*;

public class Baek11724 {
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	
	static int N,M;
	static ArrayList<Integer>[] array;
	static boolean[] v;

	public static void main(String[] args) throws IOException {
		st=new StringTokenizer(br.readLine());
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		array=new ArrayList[N+1];
		v=new boolean[N+1];
		for(int i=0;i<N+1;i++) {
			array[i]=new ArrayList<>();
		}
		for(int i=0;i<M;i++) {
			st=new StringTokenizer(br.readLine());
			int start=Integer.parseInt(st.nextToken());
			int end=Integer.parseInt(st.nextToken());
			array[start].add(end);
			array[end].add(start);
		}
		for(int i=1;i<N+1;i++) {
			if(v[i]==false) {
				dfs(i);
				cnt++;
			}
		}
		
		System.out.println(cnt);
	}
	
	static int cnt;

	private static void dfs(int k) {
		v[k]=true;
		
		for(int i=0;i<array[k].size();i++) {
			if(v[array[k].get(i)]==false) {
				v[array[k].get(i)]=true;
				dfs(array[k].get(i));
			}
		}
	}
}
