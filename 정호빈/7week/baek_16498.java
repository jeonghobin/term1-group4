import java.util.*;
import java.io.*;

public class Main {
	
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st ;
		st = new StringTokenizer(br.readLine());
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		int[] arr1 = new int[A];
		int[] arr2 = new int[B];
		int[] arr3 = new int[C];
		int minans=Integer.MAX_VALUE;
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<A;i++) {
			arr1[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<B;i++) {
			arr2[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<C;i++) {
			arr3[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr1);
		Arrays.sort(arr2);
		Arrays.sort(arr3);
		for(int i=0;i<A;i++) {
			for(int j=0;j<B;j++) {
				int max = Math.max(arr1[i], arr2[j]);
				int min = Math.min(arr1[i], arr2[j]);
				int s=0;
				int e=C-1;
				int flag=1;
				while(s<=e) {
					int mid=(s+e)/2;
					if(max<arr3[mid]) {
						e=mid-1;
					}else if(min>arr3[mid]) {
						s=mid+1;
					}else {
						max = Math.max(max, arr3[mid]);
						min = Math.min(min, arr3[mid]);
						int a = max-min;
						minans = Math.min(minans, a);
						flag=0;
						break;
					}
					int maxT = Math.max(max, arr3[mid]);
					int minT = Math.min(min, arr3[mid]);
					int a = maxT-minT;
					minans = Math.min(minans, a);
					
					
				}
			}
		}
		System.out.println(minans);
		
		
	}

	
}
