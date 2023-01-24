package ppt;

import java.util.Scanner;
import java.util.StringTokenizer;

public class pro13 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int T=sc.nextInt();
		for(int t=1;t<=T;t++) {
			int n=sc.nextInt();
			sc.nextLine();
			char [][]map=new char[n+2][n+2];
			for(int i=1;i<n+1;i++) {
				StringTokenizer st = new StringTokenizer(sc.nextLine()," ");
				for(int j=1;j<n+1;j++) {
					char a=st.nextToken().charAt(0);
					map[i][j]=a;
				}
			}
			int max=0;
			for(int i=1;i<n+1;i++) {
				for(int j=1;j<n+1;j++) {
					char a=map[i][j];
					if(a=='B') {
						int sum=0;
						boolean check=true;
						for(int x=-1;x<=1;x++) {
							for(int y=-1;y<=1;y++) {
								if(map[i+x][j+y]=='G') {
									check=false;
									break;
								}
							}
							if(check==false) {
								break;
							}
						}
						if(check==false) {
							sum=2;
						}
						else {
							for(int x=1;x<n+1;x++) {
								if(map[i][x]=='B') {
									sum++;
								}
								if(map[x][j]=='B') {
									sum++;
								}
							}
							sum--;
							max=Math.max(max, sum);
						}
					}
				}
			}
			System.out.println("#"+t+" "+max);
		}
	}
}


