package KMP;

import java.io.*;
import java.util.*;

public class Baek1701 {
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;

	static int max;

	public static void main(String[] args) throws IOException {
		String parent=br.readLine();
		int n=parent.length();
		
		int ans=0;
		for(int i=0;i<n-1;i++) {
			parent.indexOf(parent.substring(i,n));
			int[] table=makeTable(parent.substring(i,n));
			Arrays.sort(table);
			ans=Math.max(ans, table[table.length-1]);
		}
		
		System.out.println(ans);
	}
	
	static int[] makeTable(String pattern) {
		int n=pattern.length();
		int[] table=new int[n];
		
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
}
