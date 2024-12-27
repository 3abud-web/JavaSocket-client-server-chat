
import java.io.*;
import java.net.*;
import java.util.*;

class Write implements Runnable {
		Socket s;
		public Write(Socket s){
			
			this.s = s;
		}
		
		
		
		Scanner obj = new Scanner(System.in);
		OutputStreamWriter os;
	    PrintWriter pr;
	    String st;
	    
	@Override
	
	public void run()  {
		while(true){
			String b = obj.nextLine();
			try{
	        os = new OutputStreamWriter
	    (s.getOutputStream());}
	    catch(Exception e){}
	        pr = new PrintWriter(os);
	        	
	    pr.println(b);
	    pr.flush();
		}
	}
	
}

class Read implements Runnable {
		Socket s;
		public Read(Socket s){
			
			this.s = s;
		}
		
		
		
		Scanner obj = new Scanner(System.in); 
		BufferedReader br;
	
	    
	    String st;
	    
	@Override
	
	public void run()  {
		while(true){
				try{
					br = new BufferedReader(new InputStreamReader(s.getInputStream()));

					st = br.readLine();
					System.out.println("Server : "+st);
}catch(Exception e){}
			
			
		}
	}
	
}
		
	
	

public class Client { 
	public static void main(String[] args)throws Exception {

		Socket s = new Socket("localhost",9789);
		
		Write wr = new Write(s);
		Thread write = new Thread(wr);
		
		
		
		Read rd = new Read(s);
		Thread read = new Thread(rd);
		
		//start both threads
		
		write.start();
		read.start();
		
	}
}
