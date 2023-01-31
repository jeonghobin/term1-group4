package com.ssafy.study.LSJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;

//로봇 이동거리
public class problem_11_1 {

   // 상하좌우
   static int[] dr = { -1, 1, 0, 0 };
   static int[] dc = { 0, 0, -1, 1 };

   public static void main(String[] args) throws IOException {

      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

      int T = Integer.parseInt(br.readLine());
      for (int tc = 1; tc < T + 1; tc++) {
         int N = Integer.parseInt(br.readLine());

         String[][] board = new String[N][N];
         ArrayList<Robot> robots = new ArrayList<Robot>();

         for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            
            for (int j = 0; j < N; j++) {
               String type = st.nextToken();
               board[i][j] = type;
               if (type.equals("A") || type.equals("B") || type.equals("C")) {
                  Robot robot = new Robot(type, i, j);
                  robots.add(robot);
               }

            }

         }

         for (Robot robot : robots) {
            Move(robot, N, board);
         }
         
         int total = 0;
         
         for (Robot robot : robots) {
            total += robot.getMoveCount();
         }
         
         System.out.println("#"+ tc + " "+ total);
      }

   }

   static void Move(Robot robot, int N, String[][] board) {
      String type = robot.getType();
      int r = robot.getR();
      int c = robot.getC();

      if (type.equals("A")) {

         while (true) {
            if (c + 1 < N && board[r][c + 1].equals("S")) {
               c += 1;
               robot.countUp();
            } else {
               break;
            }
         }

      } else if (type.equals("B")) {
         
         for(int d = 2 ; d < 4 ; d++) {
            
            r = robot.getR();
            c = robot.getC();
            
            while (true) {
               int dx = r + dr[d];
               int dy = c + dc[d];
               
               if (dx < N && dy < N && dx >= 0 && dy >=0 && board[dx][dy].equals("S")) {
                  r = dx;
                  c = dy;
                  robot.countUp();
               } else {
                  break;
               }
            }
         }

      } else if (type.equals("C")) {
      
         
         for(int d = 0 ; d < 4 ; d++) {
            
            r = robot.getR();
            c = robot.getC();
            
            while (true) {
               int dx = r + dr[d];
               int dy = c + dc[d];
               
               if (dx < N && dy < N && dx >= 0 && dy >=0 && board[dx][dy].equals("S")) {
                  r = dx;
                  c = dy;
                  robot.countUp();
               } else {
                  break;
               }
            }
         }

      }

   }

}

class Robot {
   String type;
   int moveCount;
   int r;
   int c;

   public Robot(String type, int r, int c) {
      this.type = type;
      this.moveCount = 0;
      this.r = r;
      this.c = c;
   }

   public String getType() {
      return type;
   }

   public void setType(String type) {
      this.type = type;
   }

   public int getMoveCount() {
      return moveCount;
   }

   public void setMoveCount(int moveCount) {
      this.moveCount = moveCount;
   }

   public void countUp() {
      this.moveCount += 1;
   }

   public int getR() {
      return r;
   }

   public void setR(int r) {
      this.r = r;
   }

   public int getC() {
      return c;
   }

   public void setC(int c) {
      this.c = c;
   }

}