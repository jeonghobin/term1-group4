package com.ssafy.study.beakjoon.Recursion.beak_17478;

import java.io.IOException;
import java.util.Scanner;

//재귀함수가 뭔가요?
public class Main {
	final static String str1 = "\"재귀함수가 뭔가요?\"";
	final static String str2 = "\"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.";
	final static String str3 = "마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.";
	final static String str4 = "그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.\"";
	final static String str5 = "\"재귀함수는 자기 자신을 호출하는 함수라네\"";
	final static String str6 = "라고 답변하였지.";

	public static void main(String[] args) throws NumberFormatException, IOException {

		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();

		System.out.println("어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다.");
		Recursive(N, "");
		System.out.println(str6);
	}

	public static void Recursive(int n, String space) {

		if (n == 0) {
			System.out.println(space + str1);
			System.out.println(space + str5);
			return;
		}

		System.out.println(space + str1);
		System.out.println(space + str2);
		System.out.println(space + str3);
		System.out.println(space + str4);
		space += "____";
		
		Recursive(--n, space);

		System.out.println(space + str6);

	}
}
