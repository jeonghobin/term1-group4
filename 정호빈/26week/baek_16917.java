import java.util.*;
import java.io.*;


public class Main {

	public static void main(String[] args) throws IOException {
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		int X = Integer.parseInt(st.nextToken());
		int Y = Integer.parseInt(st.nextToken());
		int total=0;
		if(A+B>C*2) {
			int min = Math.min(X, Y);
			total += C*2*min;
			if(min == X) {
				if(B>C*2) {
					total+=(Y-min)*C*2;
				}else {
					total+=(Y-min)*B;
				}
			}else {
				if(A>C*2) {
					total+=(X-min)*C*2;
				}else {
					total+=(X-min)*A;
				}
			}
		}else {
			total+=A*X+B*Y;
		}
		System.out.println(total);
		
	}

}
