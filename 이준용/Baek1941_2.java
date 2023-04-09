package day0405;

import java.io.*;
import java.util.*;

public class Baek1941_2 {
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;

	static char[][]map=new char[5][5];
	static int[]num=new int[25];

	public static void main(String[] args) throws IOException {
		for(int i=0;i<5;i++) {
			String word=br.readLine();
			for(int j=0;j<5;j++) {
				map[i][j]=word.charAt(j);
				num[i*5+j]=i*5+j;
			}
		}
		
		recursive(new int[7], 0, 0);
		System.out.println(ans);
	}
	
	static int ans;

	private static void recursive(int[] sel, int idx, int k) {
		if(k==7) {
			boolean[] v=new boolean[7];
			int checkcnt=1;
			v[0]=true;
			for(int i=1;i<7;i++) {
				for(int j=0;j<i;j++) {
					if(sel[i]%5==0) {
						if(sel[i]==sel[j]+5) {
							v[i]=true;
							checkcnt++;
							break;
						}
					}
					else {
						if(sel[i]==sel[j]+1||sel[i]==sel[j]+5) {
							v[i]=true;
							checkcnt++;
							break;
						}
					}
				}
			}
			
			for(int i=6;i>=0;i--) {
				for(int j=i-1;j>=0;j--) {
					if(sel[i]%5==0) {
						if(sel[i]==sel[j]+5) {
							checkcnt++;
							break;
						}
					}
					else {
						if(sel[i]==sel[j]+1||sel[i]==sel[j]+5) {
							checkcnt++;
							break;
						}
					}
				}
			}

			
			if(checkcnt==7) {
				int cnt=0;
				for(int i=0;i<7;i++) {
					int r=sel[i]/5;
					int c=sel[i]%5;
					if(map[r][c]=='S') {
						cnt++;
					}
				}
				if(cnt>=4) {
					//System.out.println(Arrays.toString(sel));
					ans++;
				}
			}
			return;
		}
		if(idx==25) return;
		
		for(int i=idx;i<num.length;i++) {
			sel[k]=num[i];
			recursive(sel, i+1, k+1);
		}
	}
	
}
