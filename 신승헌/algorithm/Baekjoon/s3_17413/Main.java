package homework.Baekjoon.s3_17413;

import java.io.*;
import java.util.*;

// w3-txt
// 시간 초과!!!!!!!!!!!!!!

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] stringArray = br.readLine().split(""); 
		
		int reverseStart = 0;
		int reverseEnd = 0;
		boolean isTag = false;
		
		String answer = "";

		for (int i = 0; i < stringArray.length; i++) {
			
			// 태그 여부 판단
			if (stringArray[i].equals("<")) {
				if (reverseStart != reverseEnd) {
					for (int j = reverseEnd; j >= reverseStart; j--) {
						answer += stringArray[j];
					}
				}
				isTag = true;
				answer += stringArray[i];
				continue;
			}
			if (stringArray[i].equals(">")) {
				reverseStart = i + 1;
				reverseEnd = reverseStart;
				isTag = false;
				answer += stringArray[i];
				continue;
			} else if (isTag == true) {
				answer += stringArray[i];
				continue;
			}
			
			// 태그가 아닌 경우
			if (stringArray[i].equals(" ") || i == stringArray.length - 1) {
				if (i == stringArray.length - 1) {
					reverseEnd = i;
				}
				for (int j = reverseEnd; j >= reverseStart; j--) {
					answer += stringArray[j];
				}
				answer += " ";
				reverseStart = i + 1;
				reverseEnd = i + 1;
			} else {
				reverseEnd = i;
			}
			
			
		}
		System.out.println(answer);
		
	}
}
