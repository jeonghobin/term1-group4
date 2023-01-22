//처음엔 그냥 상하좌우 다 구현했다가 방향벡터 direction 1, -1로 코드 조금 줄였습니당
package ppt;

import java.util.Scanner;
import java.util.StringTokenizer;

public class pro11 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int[] direction= {1,-1};
		int T=sc.nextInt();
		for(int t=1;t<=T;t++) {
			int n=sc.nextInt();
			sc.nextLine();
			char [][]map=new char[n][n];
			for(int i=0;i<n;i++) {
				StringTokenizer st = new StringTokenizer(sc.nextLine()," ");
				for(int j=0;j<n;j++) {
					char a=st.nextToken().charAt(0);
					map[i][j]=a;
				}
			}
			int sum=0;
			for(int i=0;i<n;i++) {
				for(int j=0;j<n;j++) {
					if(map[i][j]=='A') {
						for(int k=1;j+k<n;k++) {
							char a=map[i][j+k];
							if(a=='S') {
								sum++;
							}
							else {
								break;
							}
						}
					}
					else if(map[i][j]=='B') {
						for(int d=0;d<=1;d++) {
							for(int k=1;true;k++) {
								if(j+k*direction[d]>=n||j+k*direction[d]<0) {
									break;
								}
								else {
									char a=map[i][j+k*direction[d]];
									if(a=='S') {
										sum++;
									}
									else {
										break;
									}
								}
							}
						}
					}
					else if(map[i][j]=='C') {
						for(int d=0;d<=1;d++) {
							for(int k=1;true;k++) {
								if(j+k*direction[d]>=n||j+k*direction[d]<0) {
									break;
								}
								else {
									char a=map[i][j+k*direction[d]];
									if(a=='S') {
										sum++;
									}
									else {
										break;
									}
								}
							}
						}
						for(int d=0;d<=1;d++) {
							for(int k=1;true;k++) {
								if(i+k*direction[d]>=n||i+k*direction[d]<0) {
									break;
								}
								else {
									char a=map[i+k*direction[d]][j];
									if(a=='S') {
										sum++;
									}
									else {
										break;
									}
								}
							}
						}
					}
				}
			}
			System.out.println("#"+t+" "+sum);
		}
	}
}

