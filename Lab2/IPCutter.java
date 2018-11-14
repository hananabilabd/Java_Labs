
class IPCutter{
	
	public static void main(String args[]) 
    { 
        
        String[] arrOfStr = args[0].split("\\.", 5); 
  
        for (String a : arrOfStr){
			 //System.out.println("hi");
            System.out.println(a); 
		}
    }
}