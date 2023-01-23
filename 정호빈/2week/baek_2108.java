import java.util.*;
import java.io.*;


public class Main {
	// 0 => -4000, 1 => -3999 ... 0 =>0 , 1 => 1 로 빈도수를 체크 해준다.
	static int[] number = new int[8001];
 	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		double sum = 0.0;
		for(int i=0;i<N;i++) {
			arr[i] = Integer.parseInt(br.readLine());
			sum+=arr[i];
			number[4000+arr[i]]++;
		}
    // 평균구하기
		sum/=N;
    // 정렬하면 0번째 인덱스는 최솟값, arr.length-1번째 인덱스는 최댓값
		Arrays.sort(arr);
		String str = String.format("%.0f", sum);
    // 해당 값이 -0.3333이면 변환했을 시 -0으로 나옴 따라서 -0일땐 0으로 바꾸어주는 코드를 넣어줌
		if(str.equals("-0")) sum=0;
		System.out.printf("%.0f\n", sum);
    // N이 홀수일 때 중앙값은 N/2번째 인덱스
		System.out.println(arr[N/2]);
		int maxi=0,maxcnt=0,frecnt=0;
    // 빈도수가 가장 큰 숫자를 표시하되 빈도수가 같으면 그 중 두번째 작은 값을 표시해야함
		for(int i=0;i<8001;i++) {
			if(number[i]>0) {
				if(maxcnt<number[i]) {
					maxcnt=number[i];
					maxi=i;
					frecnt=1;
				}
				else if(maxcnt==number[i]) {
					if(frecnt<2) {
						maxi=i;
						frecnt=2;
					}
				}
			}
    }
    //이전에 해주었던 +4000을 다시 빼줌.
		System.out.println(maxi-4000);
		System.out.println(arr[arr.length-1]-arr[0]);
 	}
	
	
	
}
