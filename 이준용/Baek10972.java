package day0216;

import java.io.*;
import java.util.*;

public class Baek10972 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	
	static int n;
	static int[] map;
	public static void main(String[] args) throws IOException {
		n=Integer.parseInt(br.readLine());
		map=new int[n];
		st=new StringTokenizer(br.readLine());
		for(int i=0;i<n;i++) {
			map[i]=Integer.parseInt(st.nextToken());
		}
		
		nextpermutiaion();
		bw.close();
	}
	private static void nextpermutiaion() throws IOException {
		int idx=n-1;
		while(idx>0&&map[idx]<map[idx-1]) {
			idx--;
		}
		if(idx==0) {
			bw.write("-1");
			return;
		}
		
		int bigidx=n-1;
		while(bigidx>idx&&map[bigidx]<map[idx-1]) {
			bigidx--;
		}
		
		int temp=map[idx-1];
		map[idx-1]=map[bigidx];
		map[bigidx]=temp;
		
		Arrays.sort(map,idx,n);
		
		for(int i=0;i<map.length;i++) {
			bw.write(map[i]+" ");
		}	
	}
}
