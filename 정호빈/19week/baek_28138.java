import java.io.*;
import java.util.*;



public class Main {
	
	
	
	static long N,M,R;
	
 	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		N = Long.parseLong(st.nextToken());
		R = Long.parseLong(st.nextToken());
		long num = N-R;
		M=0; 
		for(long i=1;i*i<=num;i++) {
			if(num%i==0) {
				if(num/i==i&&i>R) {
					M+=i;
				}else {
					if(i>R)
						M+=i;
					if(num/i>R)
						M+=num/i;
				}
			}
		}
		System.out.println(M);
		
	}

	

	
	

}
