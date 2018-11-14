public class Pattern1 {
	
	static void printStar(int limit){
		for(int i =0;i<limit;i++){
		System.out.print("*");
		}
	}
	static void printSpace(int limit){
		for(int i =0;i<limit;i++){
		System.out.print(" ");
		}
	}
    public static void main(String args[]) 
    { 
        int size = Integer.parseInt(args[0]);
		int space;
		int star =1;
		space = size -1;
		for (int i=0;i<size;i++){
			printStar(star);
			printSpace(space);
			
			System.out.println();
			star+=1;
		    space-=1;
			
		}
  
        
        
    } 
} 