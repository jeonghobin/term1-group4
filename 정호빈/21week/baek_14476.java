import java.io.*;
import java.util.*;



public class Main {
	
	
	
 	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N+2];
		st = new StringTokenizer(br.readLine());
		for(int i=1;i<=N;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int[] lgcd = new int[N+2];
		for(int i=1;i<=N;i++) {
			lgcd[i] = gcd(arr[i],lgcd[i-1]);
		}
		int[] rgcd = new int[N+2];
		for(int i=N;i>=1;i--) {
			rgcd[i] = gcd(arr[i],rgcd[i+1]);
		}
		int maxGCD=-1;
		int maxIndex=-1;
		for(int i=1;i<=N;i++) {
			int igcd=gcd(lgcd[i-1],rgcd[i+1]);
			if(arr[i]%igcd!=0) {
				maxGCD=Math.max(maxGCD, igcd);
				maxIndex=i;
			}
		}
		if(maxGCD==-1) {
			System.out.println(-1);
		}else {
			System.out.println(maxGCD+" "+arr[maxIndex]);
		}
	}
 	
 	static int gcd(int a,int b) {
 		if(b==0)return a;
 		else return gcd(b,a%b);
 	}

 	

	

}
