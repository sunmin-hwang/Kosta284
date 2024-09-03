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
			M = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			
			map = new int[M][N];
			visited = new boolean[M][N];
			
			for(int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			br.close();
			return dfs(0,0,0);
		}
		
		static int dfs(int m, int n, int sum) {
			if(m==M-1&&n==N-1) {
				return ++sum;
			}
			
			int[] a = new int[] {0, 1, 0, -1};
			int[] b = new int[] {1, 0, -1, 0};
			
			for(int i = 0; i < 4; i++) {
				int m2 = m + a[i];
				int n2 = n +b[i];
				if(m2<0||m2>=M||n2<0||n2>=N) continue;
				if(!visited[m2][n2]) {
					if(map[m2][n2]<map[m][n]) {
						visited[m2][n2] = true;
						sum = dfs(m2,n2, sum);
						visited[m2][n2] = false;
					}
				}
			}
			
			return sum;
		}
		
		public static void main(String[] args) throws IOException {
			System.out.println(execute(new File("input.txt")));
		}

}
