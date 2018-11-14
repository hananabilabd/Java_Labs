//package Lab1;
public class Complex{
	int real=0 ;
	int imag=0 ;
	
	public void setReal (int r){
		real =r;
	}
	public void setImag (int i){
		imag =i;
	}
	
	public int getReal(){
		return real;
	}
	public int getImag (){
		return imag;
	}
	public void print(){
		if (imag >0){
		System.out.print(real);
		System.out.print("+");
		System.out.print(imag);
		System.out.println("i");
		}
		else{
			System.out.print(real);
			System.out.print(imag);
			System.out.println("i");
		}
	}
	public void setComplex (int r , int i){
		real=r;
		imag=i;
	}
	public void setComplex (int v){
		imag=real=v;
	}
	
	public static Complex add(Complex a,Complex b){
		Complex c = new Complex();
		c.setReal(a.getReal()+b.getReal());
		c.setImag(a.getImag()+b.getImag());
		return c;
	}
	public static Complex subtract(Complex a,Complex b){
		Complex c = new Complex();
		c.setReal(a.getReal()-b.getReal());
		c.setImag(a.getImag()-b.getImag());
		return c;
	}
	
   
	public static void main(String[] args){
		int[] intArgs = new int[args.length];
		for (int i=0 ;i<args.length; i++) 
		{
         try {
            intArgs[i] = Integer.parseInt(args[i]); 
			//System.out.println(intArgs[i]);
         } catch (NumberFormatException e) {
            System.err.println("Failed trying to parse a non-numeric argument, " + args[i]);
         }
         }
		Complex c1 =new Complex();
		Complex c2 = new Complex();
		Complex c3 = new Complex();
		 
		Complex c4 = new Complex();
		
		c1.setComplex(intArgs[0],intArgs[1]);
		c2.setComplex(intArgs[2],intArgs[3]);
		System.out.print("c1=");
		c1.print();
		System.out.print("c2=");
		c2.print();
		c3=Complex.add(c1,c2);
		System.out.print("c3=c1+c2=");
		c3.print();
		for (int i =0; i<intArgs.length ; i++) 
		{
         System.out.println(intArgs[i]);
         }
		
		
	}
	
}