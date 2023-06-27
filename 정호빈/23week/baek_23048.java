import java.io.*;
import java.util.*;




public class Main {
	
	
  	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N+1];
		int cnt=2;
		arr[1] = 1;
		for(int i=2;i<=N;i++) {
			if(arr[i]==0) {
				for(int j=i;j<=N;j+=i) {
					arr[j] = cnt;
				}
				cnt++;
			}
		}
		bw.write((cnt-1)+"\n");
		for(int i=1;i<=N;i++) {
			bw.write(arr[i]+" ");
		}
		bw.flush();
		bw.close();
	}


	
	
	

 	

}
