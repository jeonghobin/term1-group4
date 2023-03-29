package com.ssafy.study.beakjoon.로봇청소기_4991;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * 먼지들을 모두 청소 하는데 최소 거리 구하기
 * BFS로 거리를 구하고 DFS로 탐색! -> 모든 거리를 순열을 이용해서 나열, 모든 순서 최소 거리 찾기
 */

public class Main {
    static int h, w, min;
    static int botr, botc;
    static char[][] map;
    static int[] dr = { 0, 0, -1, 1 };
    static int[] dc = { -1, 1, 0, 0 };

    static class Point {
        int r, c, cnt;

        public Point(int r, int c, int cnt) {
            super();
            this.r = r;
            this.c = c;
            this.cnt = cnt;
        }

        @Override
        public String toString() {
            return "Point [r=" + r + ", c=" + c + ", cnt=" + cnt + "]";
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());
            
            if(w==0 && h==0) break;
            
            min = Integer.MAX_VALUE;

            map = new char[h][w];
            ArrayList<Point> list = new ArrayList<>();

            for (int i = 0; i < h; i++) {
                String str = br.readLine();
                for (int j = 0; j < w; j++) {
                    map[i][j] = (char) str.charAt(j);
                    if (map[i][j] == 'o') {
                        botr = i;
                        botc = j;
                    }
                    if (map[i][j] == '*') {
                        list.add(new Point(i, j, 0));
                    }
                }
            }

            recursive(list, new Point[list.size()], 0, new boolean[list.size()]);

            System.out.println(min);
        }
    
    }

    private static void recursive(ArrayList<Point> list2, Point[] sel, int sIdx, boolean[] v) {
        if (sIdx == sel.length) {
//            System.out.println(Arrays.toString(sel));
            BFS(sel);
            return;
        }

        for (int i = 0; i < list2.size(); i++) {
            if (!v[i]) {
                v[i] = true;
                sel[sIdx] = list2.get(i);
                recursive(list2, sel, sIdx + 1, v);
                v[i] = false;
            }
        }
    }

    private static void checkBFS(Point[] sel) {
        Queue<Point> Q = new LinkedList<>();
        boolean[][] v = new boolean[h][w];
        Q.offer(new Point(botr, botc, 0));
        v[botr][botc] = true;

        // map copy
        char[][] copymap = new char[h][w];
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                copymap[i][j] = map[i][j];
            }
        }

        int minDir = 0;
        for (int k = 0; k < sel.length; k++) {
            while (!Q.isEmpty()) {
                Point p = Q.poll();

                minDir = p.cnt;

                if (p.r == sel[k].r && p.c == sel[k].c) {
                    copymap[p.r][p.c] = '.';
                    Q.clear();
                    v = new boolean[h][w];
                    v[sel[k].r][sel[k].c] = true;
                    Q.add(new Point(sel[k].r, sel[k].c, p.cnt));
                    break;
                }

                for (int i = 0; i < 4; i++) {
                    int nr = p.r + dr[i];
                    int nc = p.c + dc[i];

                    if (nr >= 0 && nc >= 0 && nr < h && nc < w && !v[nr][nc]) {
                        v[nr][nc] = true;

                        if (copymap[nr][nc] == 'x')
                            continue;

                        Q.offer(new Point(nr, nc, p.cnt + 1));

                    }
                }
            }
        }

        // 남아 있는게 있는지 확인
        boolean isEmpty = true;
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                if (copymap[i][j] == '*')
                    isEmpty = false;
            }
        }

        if (isEmpty)
            min = Math.min(min, minDir);
        else
            min = -1;
    }
    
    private static void BFS(Point[] sel) {
        Queue<Point> Q = new LinkedList<>();
        boolean[][] v = new boolean[h][w];
        Q.offer(new Point(botr, botc, 0));
        v[botr][botc] = true;

        // map copy
        char[][] copymap = new char[h][w];
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                copymap[i][j] = map[i][j];
            }
        }

        int minDir = 0;
        for (int k = 0; k < sel.length; k++) {
            while (!Q.isEmpty()) {
                Point p = Q.poll();

                minDir = p.cnt;

                if (p.r == sel[k].r && p.c == sel[k].c) {
                    copymap[p.r][p.c] = '.';
                    Q.clear();
                    v = new boolean[h][w];
                    v[sel[k].r][sel[k].c] = true;
                    Q.add(new Point(sel[k].r, sel[k].c, p.cnt));
                    break;
                }

                for (int i = 0; i < 4; i++) {
                    int nr = p.r + dr[i];
                    int nc = p.c + dc[i];

                    if (nr >= 0 && nc >= 0 && nr < h && nc < w && !v[nr][nc]) {
                        v[nr][nc] = true;

                        if (copymap[nr][nc] == 'x')
                            continue;

                        Q.offer(new Point(nr, nc, p.cnt + 1));

                    }
                }
            }
        }

        // 남아 있는게 있는지 확인
        boolean isEmpty = true;
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                if (copymap[i][j] == '*')
                    isEmpty = false;
            }
        }

        if (isEmpty)
            min = Math.min(min, minDir);
        else
            min = -1;
    }

    private static boolean clear(char[][] map) {
        boolean isboolean = true;
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                if (map[i][j] == '*')
                    isboolean = false;
            }
        }
        return isboolean;
    }

    private static void print(char[][] map) {
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                System.out.print(map[i][j]);
            }
            System.out.println();
        }
    }

}