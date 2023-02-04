import java.util.*;
import java.io.*;


public class Main {
	
	static int cnt=Integer.MAX_VALUE;
	static int[] paper = {0,5,5,5,5,5};
	static int[][] board = new int[10][10];
	
 	static boolean totalcheck() {
 		for(int i=0;i<10;i++) {
 			for(int j=0;j<10;j++) {
 				if(board[i][j]==1)return false;
 			}
 		}
 		return true;
 	}
 	
 	static boolean totalcheck2(int a,int b, int pn) {
 		for(int i=a;i<a+pn;i++) {
 			for(int j=b;j<b+pn;j++) {
 				if(j>=10||i>=10||board[i][j]==0) return false;
 			}
 		}
 		return true;
 	}
 	
 	
	static void check(int rscnt,int a,int b) {
		if(a>=9&&b>9) {
			cnt = rscnt<cnt? rscnt:cnt;
			return;
		}
		if (cnt <= rscnt) {
            return;
        }
		if(b>9) {
			check(rscnt,a+1,0);
			return;
		}
		
		if(board[a][b]==1) {
			for(int i=5;i>=1;i--) {
				if(paper[i]>0&&totalcheck2(a,b,i)) {
					paper[i]--;
					for(int k=a;k<a+i;k++) {
						for(int j=b;j<b+i;j++) {
							board[k][j] =0;
						}
					}
					check(rscnt+1,a,b+1);
					for(int k=a;k<a+i;k++) {
						for(int j=b;j<b+i;j++) {
							board[k][j] =1;
						}
					}
					paper[i]++;
				}
			}
		}
		else {
			check(rscnt,a,b+1);
			return;
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		for(int i=0;i<10;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<10;j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		if(totalcheck()) {
			System.out.println(0);
			return;
		}
		
		check(0,0,0);
		
		
		if(cnt==Integer.MAX_VALUE)
			System.out.println(-1);
		else
			System.out.println(cnt);
					
	}

}
