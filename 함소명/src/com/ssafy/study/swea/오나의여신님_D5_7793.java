package com.ssafy.study.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;
 
/*
 * 오! 나의 여신님
 * 수연이의 위치는 ‘S’, 여신의 공간은 ‘D’, 돌의 위치는 ‘X’, 악마는 ‘*’로 주어진다.
 * 안전 지역에 도달하는 최소 시간 = 최단거리 DFS
 * "악마의 손아귀" 스킬은 매 초마다 상하좌우 인접해있는 영역들을 부식시키며 확장
 * 
 * Error -> 수연이가 더이상 움직이지 못하면 종료. 악마가 먼저 퍼지고 수연이가 악마를 피해 움직여야하므로 악마가 먼저 퍼지게 한다.
 * 만약, 수연이가 악마를 만나면 게임 종료하게 했다면 수연이가 가능한 방향으로 퍼지기 때문에 그 중 악마를 하나라도 만나면 게임이 종료된다.
 * 수연이가 갈 수 있는 케이스 중 가장 짧은 거리 선택
 * 
 */
 
public class 오나의여신님_D5_7793 {
 
    static char[][] map;
    static int N;
    static int M;
    static int cnt;
    static boolean success;
    static Queue<Position> move;
    static Queue<Position> devil;
 
    static int[] dr = { 0, 1, 0, -1 };
    static int[] dc = { 1, 0, -1, 0 };
 
    static class Position {
        int r, c;
 
        public Position(int row, int col) {
            this.r = row;
            this.c = col;
        }
    }
 
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int test_case = 1; test_case <= T; test_case++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            move = new LinkedList<Position>();
            devil = new LinkedList<Position>();
            map = new char[N][M];
            success = false;
            cnt = 0;
 
            for (int i = 0; i < N; i++) {
                String str = br.readLine();
                for (int j = 0; j < M; j++) {
                    map[i][j] = str.charAt(j);
 
                    if (map[i][j] == 'S')
                        move.offer(new Position(i, j));
                    if (map[i][j] == '*')
                        devil.offer(new Position(i, j));
                }
            }
 
            BFS();
 
            if (success)
                System.out.println("#" + test_case + " " + cnt);
            else
                System.out.println("#" + test_case + " " + "GAME OVER");
 
        }
    }
 
    private static void BFS() {
 
        while (!move.isEmpty()) {
 
            // 악마부터 영역 확장
            int len = devil.size();
            for (int i = 0; i < len; i++) {
                Position d = devil.poll();
 
                for (int j = 0; j < 4; j++) {
                    int dx = d.r + dr[j];
                    int dy = d.c + dc[j];
 
                    if (dx >= 0 && dx < N && dy >= 0 && dy < M) {
                        if (map[dx][dy] == '.' || map[dx][dy] == 'S') {
                            map[dx][dy] = '*';
                            devil.offer(new Position(dx, dy));
                        }
                    }
                }
            }
 
            // 사람 움직임. 더이상 갈데가 없으면 종료, 수연이 여러명?
            int len2 = move.size();
            for (int i = 0; i < len2; i++) {
                Position p = move.poll();
 
                // 여신을 만나면 끝
                if (map[p.r][p.c] == 'D') {
                    success = true;
 
                    return;
                }
 
                for (int j = 0; j < 4; j++) {
                    int dx = p.r + dr[j];
                    int dy = p.c + dc[j];
 
                    if (dx >= 0 && dx < N && dy >= 0 && dy < M) {
                        if (map[dx][dy] == '.' || map[dx][dy] == 'D') {
                            if (map[dx][dy] != 'D')
                                map[dx][dy] = 'S';
                            move.offer(new Position(dx, dy));
                        }
                    }
                }
            }
 
            // while 문이 돈 수가 수연이가 이동한 수
            cnt++;
//          System.out.println(Arrays.deepToString(map));
        }
    }
}