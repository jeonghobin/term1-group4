package ppt;

import java.util.*;

public class pro22 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int[] dx = {-1,1,0,0};
		int[] dy = {0,0,-1,1};
		int[] jump = {3,5,6};
		int T=sc.nextInt();
		for(int t=1;t<=T;t++) {
			int n=sc.nextInt();
			int[][]map=new int[n][n];
			
			int s=sc.nextInt();
			int count=s;

			for(int i=1;i<=s;i++) {
				int a=sc.nextInt();
				int b=sc.nextInt();
				int c=sc.nextInt()-1;
				
				if(a+6*dx[c]>=n||a+6*dx[c]<0||b+6*dy[c]>=n||b+6*dy[c]<0) {
					count--;
					continue;
				}
				else {
					if(map[a][b]==1) {
						count--;
						continue;
					}
					else {
						for(int j=0;j<3;j++) {
							int newa=a+dx[c]*jump[j];
							int newb=b+dy[c]*jump[j];
							if(map[newa][newb]==1) {
								count--;
								break;
							}
							if(j==2) {
								map[newa][newb]=1;
							}
						}
					}
				}
			}
			System.out.println("#"+t+" "+count);
		}
	}
}