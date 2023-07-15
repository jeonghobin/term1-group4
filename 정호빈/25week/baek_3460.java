import java.io.*;
import java.util.*;




public class Main {
	
  	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		for(int i=0;i<N;i++) {
			int a = Integer.parseInt(br.readLine());
			int j=0;
			while(a>0) {
				int num = a%2;
				a/=2;
				if(num==1) {
					bw.write(j+" ");
				}
				j++;
			}
			bw.write("\n");
		}
		bw.flush();
		bw.close();
	}
	


 	

}
