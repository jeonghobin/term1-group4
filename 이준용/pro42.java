package ppt;

import java.util.Scanner;

public class pro42 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int[] dx= {-1,0,1,0};
		int[] dy= {0,1,0,-1};	
		int T=sc.nextInt();
		for(int t=1;t<=T;t++) {
			boolean check=true;
			int n=sc.nextInt();
			int [][]map = new int[n][n];		//맵
			
			int px=sc.nextInt()-1;
			int py=sc.nextInt()-1;
			
			int jn=sc.nextInt();
			for(int i=0;i<jn;i++) {
				map[sc.nextInt()-1][sc.nextInt()-1]=1; //점퍼는 1
			}
			int movecount=sc.nextInt();
			int [][]move=new int[movecount][2];	//이동 방향, 거리
			for(int i=0;i<movecount;i++) {
				move[i][0]=sc.nextInt()-1;		//방향
				move[i][1]=sc.nextInt();		//거리
			}

			for(int i=0;i<movecount;i++) {
				int nx=px+move[i][1]*dx[move[i][0]];
				int ny=py+move[i][1]*dy[move[i][0]];
				if(nx>=n||nx<0||ny>=n||ny<0) {
					px=0;
					py=0;
					break;
				}
				else {
					for(int j=1;j<=move[i][1];j++) {
						nx=px+j*dx[move[i][0]];
						ny=py+j*dy[move[i][0]];
						if(map[nx][ny]==1) {
							px=0;
							py=0;
							check=false;
							break;
						}
					}
					if(check==false) {
						break;
					}
					px=nx;
					py=ny;
					if(i==movecount-1) {
						px++;
						py++;
					}
				}
			}
			System.out.println("#"+t+" "+px+" "+py);
		}
	}
}
