import java.io.*;
import java.util.*;

public class JEL_21278 {
	static Building buildings[];
	 
	public static class Building {
		List<Integer> adjacentNums = new ArrayList<>();
	}
	 
	public static class Chicken {
		int count;
		int minNumChicken;
		int maxNumChicken;
		
		@Override
		public String toString() {
			return minNumChicken + " " + maxNumChicken + " " + (count * 2);
		}
	} 
	
	public static int BFS(int building1, int building2) {
		int length = buildings.length;
		boolean check[] = new boolean[length];
		Queue<Building> q = new LinkedList<>();
		
		int depth = 1; 
		int count = 0;
		 
		q.add(buildings[building1]);
		q.add(buildings[building2]);
		check[building1] = true;
		check[building2] = true; 
		
		int countInLevel = 2; 
		int countAdjacent = 0;
		 
		while(!q.isEmpty()) {
			Building building = q.poll(); 
			--countInLevel; 
			
			for(int adjacentNum : building.adjacentNums) {
				
				if(!check[adjacentNum]) {
					q.add(buildings[adjacentNum]);
					check[adjacentNum] = true;
					count += depth;
					++countAdjacent;
				}
			}
			 
			if(countInLevel == 0) {
				countInLevel = countAdjacent;
				countAdjacent = 0;
				++depth;
			}
		} 
		return count;
	}
	
	// 치킨집을 찾아 출력 
	public static void findChicken() {
		Chicken chicken = null;
		int minCount = Integer.MAX_VALUE;
		 
		for (int i = 1; i < buildings.length; i++) {
			for (int j = i + 1; j < buildings.length; j++) { 
				int count = BFS(i,j);
				
				if(count < minCount) { 
					minCount = count; 
					chicken = new Chicken();
					chicken.count = count;
					chicken.minNumChicken = i;
					chicken.maxNumChicken = j;
					}
				}
			} 
		System.out.println(chicken);
	}

	public static void main(String[] args) {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		
		try { 
			String nums = br.readLine().trim();
			StringTokenizer stk = new StringTokenizer(nums);
			
			int n = Integer.parseInt(stk.nextToken());
			int m = Integer.parseInt(stk.nextToken());
			
			buildings = new Building[n + 1];
			
			for (int i = 1; i < buildings.length; i++) 
				buildings[i] = new Building();
			
			
			for (int i = 1; i <= m; i++) {
				nums = br.readLine().trim();
				stk = new StringTokenizer(nums);
				
				int a = Integer.parseInt(stk.nextToken());
				int b = Integer.parseInt(stk.nextToken());
				
				buildings[a].adjacentNums.add(b);
				buildings[b].adjacentNums.add(a);
			}  
			findChicken();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
