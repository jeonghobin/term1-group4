import java.io.*;
import java.util.*;



public class Main {
	
	static int[][] A,B;
	
 	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		A = new int[a][b];
		for(int i=0;i<a;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<b;j++) {
				A[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		st = new StringTokenizer(br.readLine());
		int c = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());
		B = new int[c][d];
		for(int i=0;i<c;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<d;j++) {
				B[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i=0;i<a;i++) {
			for(int j=0;j<d;j++) {
				int sum=0;
				for(int k=0;k<b;k++) {
					sum+=A[i][k]*B[k][j];
				}
				System.out.print(sum+" ");
			}
			System.out.println();
		}
		
		
	}

	
	
	
		

	
	

}
