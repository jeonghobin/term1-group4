package baek;

import java.util.*;
public class Snailnum {

	public static void main(String args[]) throws Exception
	{
		int[] dx= {0,1,0,-1};
		int[] dy= {1,0,-1,0};
		Scanner sc=new Scanner(System.in);
		int T=sc.nextInt();
		for(int t=0;t<T;t++) {
			int n=sc.nextInt();
			int[][] map=new int[n][n];
			
			int count=1;
			int a=0;
			int b=0;

			for(int i=0;i<2*map.length-1;i++) {		//꺽는 수
				for(int j=0;j<n;j++) {
					a+=1*dx[i%4];
					b+=1*dy[i%4];
					if(count==1) {
						a=0;
						b=0;
					}
					map[a][b]=count;
					count++;
					if(count==map.length*map.length-1) {
						break;
					}
				}
				if(i%4==2||i%4==0) {
					n--;
				}
			}
			System.out.println("#"+(t+1));
			for(int i=0;i<map.length;i++) {
				for(int j=0;j<map.length;j++) {
					System.out.print(map[i][j]+" ");
				}
				System.out.println();
			}
		}
	}
}

