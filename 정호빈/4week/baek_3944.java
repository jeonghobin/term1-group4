import java.io.*;
import java.util.*;

//백준 3944 나머지계산
//직접 그 수를 a진법에서 10진법으로 바꾸고 나머지를 구하면 시간초과가 난다.
//따라서 한번에 구해줘야하는데 나머지를 구할 땐 a-1을 mod해주기 때문에 이걸 이용한다.

public class Main {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st ;
		int N = Integer.parseInt(br.readLine());
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			String str = st.nextToken();
			long temp=0;
			for(int j=0;j<str.length();j++) {
				temp+=((str.charAt(j)-'0')%(a-1));
			}
			System.out.println(temp%(a-1));
		}
		
	}

}
