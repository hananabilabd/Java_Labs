public class Pattern2 {
	
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
			printSpace(space);
			printStar(star);
			System.out.println();
			star+=2;
		    space-=1;
			
		}
  
        
        
    } 
} 