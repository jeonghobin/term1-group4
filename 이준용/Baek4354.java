package KMP;

import java.io.*;
import java.util.*;

public class Baek4354 {
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		while(true) {
			String parent=br.readLine();
			if(parent.equals("."))break;
			
			int[]table=makeTable(parent);
			System.out.println(Arrays.toString(table));
			
			int a=table[parent.length()-1];
			int ans=1;
			if(a>0) {
				ans=parent.length()/(parent.length()-a);
				if((parent.length()%(parent.length()-a)!=0)) ans=1;
			}
			bw.write(ans+"\n");
		}
		bw.close();
	}
	
	public static int[] makeTable(String pattern) {
		int n=pattern.length();
		int[] table=new int[n];
		
		int idx=0;
		for(int i=1;i<n;i++) {
			while(idx>0&&pattern.charAt(i)!=pattern.charAt(i)) {
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
