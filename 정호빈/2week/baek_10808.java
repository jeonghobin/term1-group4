import java.util.*;
import java.io.*;


public class Main {
	
	// 단순한 문자열을 다루는 문제 
  // 26개의 알파벳을 표현할 배열을 만들어 해당 알파벳이 나오면 개수증가

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		String str = br.readLine();
 		int[] arr = new int[26];
 		for(int i=0;i<str.length();i++) {
 			arr[str.charAt(i)-'a']++;
 		}
 		for(int i=0;i<arr.length;i++) {
 			System.out.print(arr[i]+" ");
 		}
 		
		
 	}

}
