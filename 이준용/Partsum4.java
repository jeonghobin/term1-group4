package baek;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Partsum4 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st= new StringTokenizer(br.readLine());
		int n=Integer.parseInt(st.nextToken());
		int m=Integer.parseInt(st.nextToken());
		
		int[] arr=new int[n+1];
		
		st=new StringTokenizer(br.readLine());
		for(int i=1;i<=n;i++) {
			arr[i]=arr[i-1]+Integer.parseInt(st.nextToken());
			
		}
		
		for(int i=0;i<m;i++) {
			int sum=0;
			st=new StringTokenizer(br.readLine());
			int start=(Integer.parseInt(st.nextToken()));
			int end=(Integer.parseInt(st.nextToken()));
			
			sum=arr[end]-arr[start-1];
			
			bw.write(sum+"\n");
		}
		bw.close();
	}
}
