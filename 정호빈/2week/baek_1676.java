import java.util.*;
import java.io.*;

// 팩토리얼 0의 개수
// 뒷자리에 0이 나오려면 어떤수가 포함되어있어야 하나
// 10이 포함되어있어야 뒷자리에 0이 나올수 있다.
// 10 은 2와 5 로 소인수 분해가 가능하며 팩토리얼에서 해당 소수가 몇번 등장하는지 구할 수 있다.
// 10을 예로 10 8 6 4 2 - 2^1 5개, 8 4 - 2^2 2개 , 8 - 2^3 1개
// N/2+N/2^2+N/2^3+..... 의 개수만큼 존재
public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		int temp = N;
		int sum2=0,sum5=0;
    // N에서 2의 소수가 몇번 등장하는지
		while(temp>1) {
			sum2+= temp/2;
			temp/=2;
		}
		temp=N;
    // N에서 5의 소수가 몇번 등장하는지
		while(temp>1) {
			sum5+=temp/5;
			temp/=5;
		}
    // 그중 작은 수 만큼 만 10이 만들어 질 것이다.
		System.out.println(Math.min(sum2, sum5));
		
	}

}
