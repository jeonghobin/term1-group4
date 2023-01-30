import java.util.*;
import java.io.*;

// 적어도 대부분의 배수
// 적어도 3개의 숫자로 나누어지면 그 수를 출력한다.
// 모든 곱의 수를 보는 경우도 있을 것이다.
// 하지만 제일 작은 3수의 곱까지만 보면 적어도 3개의 숫자로 나누어지는 수를 찾을 수있다.
// 다른 수학적인 방법으로 가장 작은 수 3개의 최소 공배수를 찾으면 된다.
class Main {
	
	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int[] arr = new int[5];
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<5;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		int max = arr[0] *arr[1] *arr[2];
		for(int i=1;i<=max;i++) {
			int cnt=0;
			for(int j=0;j<5;j++) {
				if(i%arr[j]==0) cnt++;
			}
			if(cnt>=3) {
				System.out.println(i);
				break;
			}
		}
		
		
		
	}
		

}
