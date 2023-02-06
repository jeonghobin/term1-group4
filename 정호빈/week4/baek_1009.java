import java.io.*;
import java.util.*;

//백준 1009 분산처리
//생각해봐야 하는 문제 아무생각없이 풀면 한번 틀릴 수 있음
//규칙찾기


public class Main {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			double a = Double.parseDouble(st.nextToken());
			double b = Double.parseDouble(st.nextToken());
			long temp = 1;
			for(int j=0;j<b;j++) {
				temp*=a;
				temp%=10;
			}
			
			if(temp ==0) {
				System.out.println(10);
			}
			else {
				System.out.println(temp);
			}
		}
		
		
	}

}
