package KMP;

import java.io.*;
import java.util.*;

public class Baek1305 {
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;

	static int L;

	public static void main(String[] args) throws IOException {
		L=Integer.parseInt(br.readLine());
		
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
	
	static void KMP(String parent, String pattern) {
		int n1=parent.length();
		int n2=pattern.length();
		
		int[] table=makeTable(pattern);
		int idx=0;
		
		for(int i=0;i<n1;i++) {
			while(idx>0&&parent.charAt(i)!=pattern.charAt(idx)) {
				idx=table[idx-1];
			}
			if(parent.charAt(i)==pattern.charAt(idx)) {
				if(idx==n2-1) {
					System.out.println(i-idx+1);
					idx=table[idx];
				}
				else {
					idx++;
				}
			}
		}
	}

}
