package KMP;

import java.io.*;
import java.util.*;

public class KMP {
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	
	static int cnt;
	static Queue<Integer>q=new LinkedList<Integer>();

	public static void main(String[] args) throws IOException {
		String parent=br.readLine();
		String pattern=br.readLine();
		
		KMP(parent, pattern);
		
		bw.write(cnt+"\n");
		for(int out:q) bw.write(out+"\n");
		bw.close();
	}
	
	public static int[]makeTable(String pattern){
		int n=pattern.length();
		int[]table=new int[n];
		
		int idx=0;
		for(int i=1;i<n;i++) {
			while(idx>0&&pattern.charAt(i)!=pattern.charAt(idx)) {
				idx=table[idx-1];
			}
			if(pattern.charAt(i)==pattern.charAt(idx)) {
				idx++;
				table[i]=idx;
			}
		}
		return table;
	}
	
	public static void KMP(String parent, String pattern) {
		int[]table=makeTable(pattern);
		
		int n1=parent.length();
		int n2=pattern.length();
		
		int idx=0;
		for(int i=0;i<n1;i++) {
			while(idx>0&&parent.charAt(i)!=pattern.charAt(idx)) {
				idx=table[idx-1];
			}
			if(parent.charAt(i)==pattern.charAt(idx)) {
				if(idx==n2-1) {
					q.add(i-idx+1);
					cnt++;
					idx=table[idx];
				}
				else {
					idx++;
				}
			}
		}
	}
}
