import java.io.*;
import java.util.*;

// 백준 2490 윷놀이
// 간단 구현 문제 0 1 의 개수로 도 개 걸 윷 모 판단


public class Main {
  
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		for(int i=0;i<3;i++) {
			int cnt = 0;
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<4;j++) {
				int a = Integer.parseInt(st.nextToken());
				if(a==1) cnt++;
			}
			if(cnt==0) {
				System.out.println("D");
			}else if(cnt==1) {
				System.out.println("C");
			}else if(cnt==2) {
				System.out.println("B");
			}else if(cnt==3) {
				System.out.println("A");
			}else if(cnt==4) {
				System.out.println("E");
			}
		}
		
		
	}

}
