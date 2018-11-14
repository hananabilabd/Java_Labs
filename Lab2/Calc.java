
class Calc{
	
	public static void main(String[] args){
		int[] intArgs = new int[(args.length+1)/2];
		boolean numeric = true;
		//System.out.println(args.length);
		//System.out.println(intArgs.length);
		//System.out.println(charArgs.length);
		try{
		for(int i = 0,j = 0;i<intArgs.length; i++,j+=2){ 
		intArgs[i] = Integer.parseInt(args[j]);
			} 
		}
		catch (NumberFormatException e) {
            numeric = false;
        }
		 if(numeric){
            System.out.println(" valid");
	
	int sum =0,flag=0,flag_mult=0,i,j=intArgs.length;
	for( i=args.length-2; i >=1 ; i-=2){ 
        j--;
		int z = j+1;
		switch(args[i]){
			
			case "-":
			sum = sum -intArgs[j];
			System.out.println(args[i]);
			System.out.println(sum);
			flag =1;
			break;
			
			case "+":
			sum = sum+intArgs[j];
			System.out.println(args[i]);
			System.out.println(sum);
			flag =1;
			break;
			
			case "x":
			flag_mult=1;
			if (flag ==0){
				sum = intArgs[j-1]*intArgs[j];
				System.out.println(args[i]);
				System.out.println(sum);
			}
			else {
				
			sum =  (intArgs[j-1]*intArgs[j]) +sum;
			System.out.println(args[i]);
				System.out.println(sum);
				
			
				
			}
			--j;
			flag =1;
			break;
			case "/":
	
			if (flag ==0){
				flag =1;
				System.out.println("hhhhhhhh");
				sum = intArgs[j-1]/intArgs[j];
				System.out.println(args[i]);
				System.out.println(sum);
				j--;
			}
			else{
				if ( args[i-2] == "+"){
				
			sum = sum+(intArgs[j-1]/intArgs[j]);
			System.out.println(args[i]);
			System.out.println(sum);
				j--;}
				else if ( args[i-2] == "-"){
				
			sum = sum-(intArgs[j-1]/intArgs[j]);
			System.out.println(args[i]);
			System.out.println(sum);
				j--;}
			}
			flag =1;
			break;
			
			
		}
		
		
    }
	i+=2;
	--j;
	
	//System.out.println("j=");
	//System.out.print(j);
	if (j>=0){
		
	switch(args[i]){
	
			case "-":
			sum = sum -intArgs[j];
			System.out.println(sum);
		
			System.out.println(args[i]);
			
			break;
			case "+":
			sum = sum+intArgs[j];
			System.out.println(sum);
			
			System.out.println(args[i]);
			break;
			
			case "x":
			sum = sum *intArgs[j];
			System.out.println(args[i]);
			break;
			case "/":
			sum = sum /intArgs[j];
			System.out.println(args[i]);
			break;
			
			
		
		
	
		
	}}
	System.out.print("result=");
	System.out.println(sum);
	}
		else{
		System.out.println("what you entered is not a number");}
 
}
}