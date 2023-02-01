import java.util.*;
import java.io.*;

// 일일 정수론 문제
// 백준 27172 수 나누기 게임
// 같은수 받는경우 없음, 모든사람과 게임, P1이 P2에게 나누어 떨어지면 P1은 -1, P2는 1
// 서로 아무것도아니면 무승부 0

public class Main {
	
		
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		int[] rs = new int[1000001];
		int[] cnt = new int[1000001];
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			cnt[arr[i]] =1;
		}
		for(int i=0;i<N;i++) {
			for(int j=1;j*j<=arr[i];j++) {
				if(arr[i]%j==0) {
					if(cnt[j]==1) {
						rs[arr[i]]--;
						rs[j]++;
					}
					if(cnt[arr[i]/j]==1&&j*j!=arr[i]) {
						rs[arr[i]]--;
						rs[arr[i]/j]++;
					}
				}
			}
		}
		for(int i=0;i<N;i++) {
			System.out.print(rs[arr[i]]+" ");
		}
		
		
 	}

}
