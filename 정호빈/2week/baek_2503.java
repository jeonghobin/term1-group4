import java.util.*;
import java.io.*;

// 기초 완전 탐색 문제 백준 2503 숫자야구
// 모든 경우의 수를 탐색하여 해당 조건에 맞는 숫자가 정답이다.
class Main {
	
	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		int[][] a = new int[N][3];
    // 숫자 스트라이크개수 볼개수 입력받기
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			a[i][0] = Integer.parseInt(st.nextToken());
			a[i][1] = Integer.parseInt(st.nextToken());
			a[i][2] = Integer.parseInt(st.nextToken());
		}
		int rs=0,rsCnt=0;
		Loop:
		for(int i=123;i<=987;i++) {
			String str3 = String.valueOf(i);
      // 숫자는 0을 포함하지 않음
			if(str3.contains("0")) continue Loop;
			for(int j=0;j<2;j++) {
				for(int k=j+1;k<3;k++) {
          // 같은 숫자를 포함하지 않음
					if(str3.charAt(j)==str3.charAt(k)) {
						continue Loop;
					}
				}
			}
			int tsc =0;
			int tbc = 0;
			int tempa = 0;
			int temps = 0;
			int tempb = 0;
			for(int j=0;j<N;j++) {
				tempa = a[j][0];
				temps = a[j][1];
				tempb = a[j][2];
				tsc =0;
				tbc = 0;
				int value = i;
				String str1 = String.valueOf(tempa);
				String str2 = String.valueOf(value);
        // 우선 같은 숫자가 있으면 볼의 개수를 올림
				for(int k=0;k<str1.length();k++) {
					if(str2.indexOf(str1.charAt(k))>-1){
						tbc++;
					}
				}
        // 같은 숫자가 위치까지 같으면 볼의 개수는 내리고 스트라이크로 올려 대체
				while(value>0) {
					if(value%10==tempa%10) {
						tbc--;
						tsc++;
					}
					value/=10;
					tempa/=10;
				}
        
				if(tsc==temps&&tbc==tempb) {
					rs++;
				}
			}
      // 모든 조건이 충족하면 개수를 하나 
			if(rs==N) {
				rsCnt++;
			}
			rs=0;
		}
		System.out.println(rsCnt);
		
	}
}
