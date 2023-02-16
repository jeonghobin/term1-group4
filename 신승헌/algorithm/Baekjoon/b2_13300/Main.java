package algo.bj.b2_13300;

import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken()); // 학생 수
		int K = Integer.parseInt(st.nextToken()); // 방에 들어갈 수 있는 최대 인원 수
		
		int[] man = new int[7];
		int[] woman = new int[7];
		
		int answer = 0;
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int sex = Integer.parseInt(st.nextToken()); // 성별
			int grade = Integer.parseInt(st.nextToken()); // 학년
			
			if (sex == 0) { // 여학생인 경우
				woman[grade] += 1;
			} else {
				man[grade] += 1;
			}
		}
		
		for (int i = 0; i < woman.length; i++) {
			answer += woman[i] / K;
			if (woman[i] % K != 0) {
				answer++;
			}
			
			answer += man[i] / K;
			if (man[i] % K != 0) {
				answer++;
			}
		}
		
		System.out.println(answer);
		
	}
}
