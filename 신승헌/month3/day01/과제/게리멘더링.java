//package month3.day01.과제;
//
// 말도 안되는 코드였다
//import java.io.*;
//import java.util.*;
//
//public class 게리멘더링 {
//	static boolean[] v;
//	static int[] people;
//	static int N;
//	static int parents[];
//	static int answer;
//
//	public static void main(String[] args) throws Exception {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringTokenizer st;
//
//		// 첫 번쨰 줄
//		st = new StringTokenizer(br.readLine());
//		N = Integer.parseInt(st.nextToken());
//		answer = Integer.MAX_VALUE;
//
//		v = new boolean[N + 1]; // 방문 여부 확인
//		people = new int[N + 1]; // 도시별 인구수
//		parents = new int[N + 1]; // 서로소
//		for (int i = 1; i < parents.length; i++) {
//			parents[i] = i;
//		}
//
//		// 두 번쨰 줄
//		st = new StringTokenizer(br.readLine());
//		for (int i = 1; i < people.length; i++) {
//			people[i] = Integer.parseInt(st.nextToken());
//		}
//
//		// 나머지 줄
//		for (int from = 1; from < parents.length; from++) {
//			st = new StringTokenizer(br.readLine());
//			int connectSize = Integer.parseInt(st.nextToken()); // 인접 도시 개수
//			for (int j = 0; j < connectSize; j++) {
//				int to = Integer.parseInt(st.nextToken());
//				union(from, to);
//			}
//		}
//
//		recursive(1);
//		if (answer == Integer.MAX_VALUE) {
//			System.out.println(-1);
//		} else {
//			System.out.println(answer);
//		}
//		System.out.println(Arrays.toString(people));
//
//	}
//
//	private static void union(int from, int to) {
//		int ps = find(from);
//		int pe = find(to);
//		if (ps != pe) {
//			parents[ps] = pe;
//		}
//
//	}
//
//	private static int find(int s) {
//		if (parents[s] == s) {
//			return s;
//		}
//		return parents[s] = find(parents[s]);
//
//	}
//
//	private static void recursive(int count) {
//		// basis part
//		if (count == v.length) {
//			ArrayList<Integer> groupA = new ArrayList<>();
//			ArrayList<Integer> groupB = new ArrayList<>();
//			int peopleA = 0;
//			int peopleB = 0;
//			for (int i = 1; i < v.length; i++) {
//				if (v[i] == true) {
//					groupA.add(i);
//				} else {
//					groupB.add(i);
//				}
//			}
//
//			// 하나도 선택되지 않았다면
//			if (groupA.size() == 0 || groupB.size() == 0)
//				return;
//
//			peopleA += people[groupA.get(0)];
//			for (int i = 0; i < groupA.size() - 1; i++) {
//				if (find(groupA.get(i)) != find(groupA.get(i + 1)))
//					return;
//				peopleA += people[groupA.get(i + 1)];
//			}
//
//			peopleB += people[groupB.get(0)];
//			for (int i = 0; i < groupB.size() - 1; i++) {
//				if (find(groupB.get(i)) != find(groupB.get(i + 1)))
//					return;
//				peopleB += people[groupB.get(i + 1)];
//			}
//
//			answer = Math.min(answer, Math.abs(peopleA - peopleB));
//			if (Math.abs(peopleA - peopleB) == 1) {
//				for (int i = 0; i < groupA.size(); i++) {
//					System.out.print(groupA.get(i) + " ");
//				}
//				System.out.println();
////				System.out.println(peopleA +" " + peopleB);
//			}
//			
//
//			return;
//		}
//
//		// inductive part
//		v[count] = true;
//		recursive(count + 1);
//		v[count] = false;
//		recursive(count + 1);
//	}
//}
