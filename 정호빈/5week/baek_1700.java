import java.util.*;
import java.io.*;
public class Main {
	static int K,N;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st ;
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		int tempN = N;
		int cnt =0;
		Map<Integer,Integer> map = new HashMap<>();
		st = new StringTokenizer(br.readLine());
		int[] arr = new int[K];
		int[] tap = new int[N];
		for(int i=0;i<K;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		for(int i=0;i<K;i++) {
			if(N!=0) {
				//해당 배열의 인덱스를 넣음
				int flag3=0;
				for(int j=0;j<tempN;j++) {
					if(tap[j]==arr[i]) {
						flag3=1;
						break;
					}
				}
				if(flag3==0) {
					tap[N-1]=arr[i];
					N--;
				}
			}
			else {
				//일단 올림
				int flag = 0;
				cnt++;
				// 탭에 꼿혀있으면 뺌
				for(int j=0;j<tempN;j++) {
					if(tap[j]==arr[i]) {
						cnt--;
						flag=1;
						break;
					}
				}
				if(flag==0) {
					int max =0,flag2=0;
					// 어떤걸 빼야할까 나중에 나오는것중에 제일 느린거
					for(int j=0;j<tempN;j++) {
						int chk = check(arr,tap[j],i);
						//안나오는게 있으면 그거 빼고 교체
						if(chk==0) {
							tap[j] = arr[i];
							flag2 = 1;
							break;
						}// 제일 나중에 나오는것 뺌
						else {
							max = Math.max(chk, max);
						}
					}
					if(flag2==0) {
						for(int j=0;j<tempN;j++) {
							if(arr[max]==tap[j]) {
								tap[j] = arr[i];
								break;
							}
						}
					}
				}
			}
		}
		System.out.println(cnt);
		
	}

	private static int check(int[] arr, int tap,int cnt) {
		for(int i=cnt+1;i<K;i++) {
			if(tap==arr[i]) {
				return i;
			}
		}
		return 0;
	}

}
