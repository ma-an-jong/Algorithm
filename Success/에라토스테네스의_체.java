package D0928;

public class 에라토스테네스의_체 {
	public static void main(String args[]) {
		
		boolean visited[] = new boolean[10000];
		
		visited[0] = true;
		visited[1] = true;
		
		
		for(int i = 1 ; i < Math.sqrt(visited.length);i++) {
			if(!visited[i]) {
				int pnt = i*i;
				
				for(int j = pnt ; j < visited.length;j = j + i) {
					if(!visited[j])
						visited[j] = true;
				}
				
			}
		}
		
		
		for(int i = 0 ; i < visited.length;i++) {
			if(!visited[i]) System.out.printf("%5d",i);
		}
		
		
		
	}

}
