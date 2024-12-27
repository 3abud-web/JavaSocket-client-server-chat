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
  
  
  
  
  BufferedReader br;
 
     
     String st;
     
 @Override
 
 public void run()  {
  while(true){
    try{
     br = new BufferedReader(new InputStreamReader(s.getInputStream()));

     st = br.readLine();
     System.out.println("client : " + st);
}catch(Exception e){}
   
   
  }
 }
 
}
public class Server {
    
    public static void main(String[] args)throws Exception {
         System.out.println("Server Started");
        ServerSocket ss = new ServerSocket(9789);
     
         System.out.println("Server Waiting For Client Request");
         Socket s = ss.accept();
         System.out.println("client connected");
         
     
         Write wr = new Write(s);
         Thread write = new Thread(wr);
     
         Read rd = new Read(s);
         Thread read = new Thread(rd);
     
         write.start();
         read.start();
    
}
}