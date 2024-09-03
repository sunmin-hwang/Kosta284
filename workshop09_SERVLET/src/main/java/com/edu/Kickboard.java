package com.edu;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Kickboard {

		static int M;
		static int N;
		static int[][] map;
		static boolean[][] visited;

		public static int execute(File path) throws IOException {
			//구현 하세요
			BufferedReader br = new BufferedReader(new FileReader(path));
			StringTokenizer st = new StringTokenizer(br.readLine());
			int h = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			
			map = new int[h][w];
			visited = new boolean[h][w];
			
			for(int i = 0; i < h; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < w; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			br.close();
			return 0;
		}
		
		public static void dfs() {
			
		}
		
		public static void main(String[] args) throws IOException {
			System.out.println(execute(new File("input.txt")));
		}

}
