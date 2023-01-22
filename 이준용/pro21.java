package ppt;

import java.util.*;

public class pro21 {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int[] dx = {1,0};
		int[] dy = {0,1};
		int[] jump = {3,5,6};
		int T=sc.nextInt();
		for(int t=1;t<=T;t++) {
			boolean check=false;
			int n=sc.nextInt();
			int[][]map=new int[n][n];
			int s=sc.nextInt();
			for(int i=1;i<=s;i++) {
				int a=sc.nextInt();
				int b=sc.nextInt();
				int c=sc.nextInt()-1;
				map[a][b]++;
				if(map[a][b]==2) {
					System.out.println("#"+t+" "+i);
					check=true;
					break;
				}
				else {
					for(int j=0;j<3;j++) {
						if(a+dx[c]*jump[j]<n&&b+dy[c]*jump[j]<n) {
							map[a+dx[c]*jump[j]][b+dy[c]*jump[j]]++;
							if(map[a+dx[c]*jump[j]][b+dy[c]*jump[j]]==2) {
								System.out.println("#"+t+" "+i);
								check=true;
								break;
							}
						}
						else {
							break;
						}
					}
				}
				if(check==true) {
					break;
				}
			}
			if(check==false) {
				System.out.println("#"+t+" "+0);
			}
		}
	}
}