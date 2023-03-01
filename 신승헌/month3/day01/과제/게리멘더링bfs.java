//package month3.day01.과제;
//
//import java.io.*;
//import java.util.*;
//
//public class 게리멘더링bfs {
//	static int N; // 도시 개수
//	static int[] people; // 각 도시의 사람 수
//	static int[][] map; // 연결 정보 저장
//	static boolean[] v;
//
//	static int answer; // 정답
//
//	public static void main(String[] args) throws Exception {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringTokenizer st;
//
//		// 첫 번쨰 줄
//		st = new StringTokenizer(br.readLine());
//		N = Integer.parseInt(st.nextToken());
//		answer = Integer.MAX_VALUE;
//		map = new int[N + 1][N + 1];
//		v = new boolean[N + 1];
//
//		// 두 번쨰 줄
//		st = new StringTokenizer(br.readLine());
//		people = new int[N + 1];
//		for (int i = 1; i < people.length; i++) {
//			people[i] = Integer.parseInt(st.nextToken());
//		}
//
//		// 나머지 줄
//		for (int x = 1; x < map.length; x++) {
//			st = new StringTokenizer(br.readLine());
//			int connectSize = Integer.parseInt(st.nextToken());
//			for (int _i = 0; _i < connectSize; _i++) {
//				int y = Integer.parseInt(st.nextToken());
//				map[x][y] = 1;
//			}
//		}
//
//		recursive(1);
//		if (answer == Integer.MAX_VALUE) {
//			System.out.println(-1);
//		} else {
//
//			System.out.println(answer);
//		}
//
//	}
//
//	private static void recursive(int count) {
//		if (count == v.length) {
//			ArrayList<Integer> groupA = new ArrayList<>();
//			ArrayList<Integer> groupB = new ArrayList<>();
//
//			for (int i = 1; i < v.length; i++) {
//				if (v[i] == false) {
//					groupA.add(i);
//				} else {
//					groupB.add(i);
//				}
//			}
//
//			if (groupA.size() == 0 || groupB.size() == 0)
//				return;
//
//			boolean checkA;
//			boolean checkB;
//			if (groupA.size() == 1) {
//				checkA = true;
//			} else {
//				checkA = bfs(groupA);				
//			}
//			if (groupA.size() == 1) {
//				checkB = true;
//			} else {
//				checkB = bfs(groupB);				
//			}
//
//			if (checkA == false || checkB == false)
//				return;
//			int sumA = 0;
//			int sumB = 0;
//
//			for (int i = 0; i < groupA.size(); i++) {
//				sumA += people[groupA.get(i)];
//			}
//
//			for (int i = 0; i < groupB.size(); i++) {
//				sumB += people[groupB.get(i)];
//			}
//
//			answer = Math.min(answer, Math.abs(sumA - sumB));
//
//			return;
//		}
//
//		v[count] = true;
//		recursive(count + 1);
//		v[count] = false;
//		recursive(count + 1);
//	}
//
//	private static boolean bfs(ArrayList<Integer> group) {
//		Queue<Integer> q = new LinkedList<>();
//
//		for (int i = 0; i < group.size(); i++) {
//			q.offer(group.get(i));
//		}
//
//		while (!q.isEmpty()) {
//			int count = 0;
//			Integer p = q.poll();
//
//			for (int i = 0; i < group.size(); i++) {
//				if (map[p][group.get(i)] == 1) {
//					count++;
//				}
//
//				if (i == group.size() - 1 && count == 0) {
//					return false;
//				}
//			}
//		}
//		return true;
//
//	}
//}
