package LSJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//로봇 이동거리
public class problem_11 {

	static int cnt = 0;

	// A 우,B 좌우,C 상하좌우
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int i = 1; i <= T; i++) {
			int N = Integer.parseInt(br.readLine());
			cnt = 0;

			String[][] list = new String[N][N];
			for (int j = 0; j < N; j++) {
				StringTokenizer str = new StringTokenizer(br.readLine());
				for (int k = 0; k < N; k++) {
					list[j][k] = str.nextToken();
				}
			}

			for (int j = 0; j < N; j++) {
				for (int k = 0; k < N; k++) {
					switch (list[j][k]) {
					case "A":
						right(j,k,list);
						break;
					case "B":
						left(j,k,list);
						right(j,k,list);
						break;
					case "C":
						left(j,k,list);
						right(j,k,list);
						up(j,k,list);
						down(j,k,list);
						break;
					default:
						break;
					}
				}
			}

			System.out.println("#" + i + " " + cnt);

		}

	}
	
	public static void left(int l, int r, String[][] arr) {
		for (int i = 1; i < arr.length; i++) {
			if (0 <= r - i)
				if (arr[l][r - i].equals("S"))
					cnt++;
				else
					break;
		}
	}
	
	public static void right(int l, int r, String[][] arr) {
		for (int i = 1; i < arr.length; i++) {
			if (r + i < arr.length)
				if (arr[l][r + i].equals("S"))
					cnt++;
				else
					break;
		}
	}

	public static void up(int l, int r, String[][] arr) {
		for (int i = 1; i < arr.length; i++) {
			if (0 <= l - i)
				if (arr[l - i][r].equals("S"))
					cnt++;
				else
					break;
		}
	}

	public static void down(int l, int r, String[][] arr) {
		for (int i = 1; i < arr.length; i++) {
			if (l + i < arr.length)
				if (arr[l+i][r].equals("S"))
					cnt++;
				else
					break;
		}
	}

}
