import java.io.*;
import java.util.*;




public class Main {
	
	static int[][] d;
	
  	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		d = new int[1001][10];
		d[1][0]=1;
		d[1][1]=1;
		d[1][2]=1;
		d[1][3]=1;
		d[1][4]=1;
		d[1][5]=1;
		d[1][6]=1;
		d[1][7]=1;
		d[1][8]=1;
		d[1][9]=1;
		for(int i=2;i<1001;i++) {
			for(int j=0;j<10;j++) {
				for(int k=j;k>=0;k--) {
					d[i][j] +=d[i-1][k]; 
				}
                d[i][j]%=10007;
			}
		}
		int N = Integer.parseInt(br.readLine());
		int sum=0;
		for(int i=0;i<10;i++) {
			sum+=d[N][i];
		}
		System.out.println(sum%10007);
		
	}

 	

}
