import java.util.*;
import java.io.*;

// 별 찍기 문제 전체적인 패턴을 파악하여 별을 찍음
public class Main {
	
	public static char[][] star;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		int M = 4*N-3;
    // 길이는 1, 5, 9, ... 이므로 4*N-3의 길이의 배열을 선언
		star = new char[M][M];
		for(int i=0;i<M;i++) {
			Arrays.fill(star[i], ' ');
		}
		pointstar(0,M);
		for(int i=0;i<M;i++) {
			for(int j=0;j<M;j++) {
				System.out.print(star[i][j]);
			}
			System.out.println();
		}
 	}
	
	public static void pointstar(int s,int lng) {
		if(lng<=s) return;
		for(int i=s;i<lng;i++) {
			star[s][i]='*'; //맨 윗 줄을 채움
			star[lng-1][i]='*'; // 맨 아랫줄을 채움
			star[i][s]='*'; // 왼쪽을 채움
			star[i][lng-1]='*'; // 오른쪽을 채움
		}
		pointstar(s+2,lng-2); // 다음으로 안쪽에 있는 사각형을 채우기위해 재귀호출
	}

}
