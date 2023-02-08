package backalgo;
import java.io.*;
import java.util.*;

public class Baek11660 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n=Integer.parseInt(st.nextToken());
		int m=Integer.parseInt(st.nextToken());
		
		int[][] map = new int[n+1][n+1];
		
		for(int i=1;i<=n;i++) {
			st=new StringTokenizer(br.readLine());
			int sum=0;
			for(int j=1;j<=n;j++) {
				sum+=Integer.parseInt(st.nextToken());
				map[i][j]=sum;
			}
		}
		for(int i=0;i<m;i++) {
			int sum=0;
			st=new StringTokenizer(br.readLine());
			int x1=Integer.parseInt(st.nextToken());
			int y1=Integer.parseInt(st.nextToken());
			int x2=Integer.parseInt(st.nextToken());
			int y2=Integer.parseInt(st.nextToken());
			
			for(int j=x1;j<=x2;j++) {
				sum+=map[j][y2]-map[j][y1-1];
			}
			bw.write(sum+"\n");
		}
		bw.close();
	}	
}

