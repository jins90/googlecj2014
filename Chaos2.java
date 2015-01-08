import java.util.*;
import java.io.*;

public class Chaos2
{
    BufferedReader b;
    int max = 0;
    public void go(String fName) throws Exception
    {
       FileInputStream file = new FileInputStream(fName);
       b = new BufferedReader(new InputStreamReader(file));
       String line = b.readLine();
       int cases = Integer.parseInt(line);
       for(int i=0; i<cases; i++) {
          exec(i+1);
       } 
    }

    public long convertLong(String line)
    {
       char arr[] = line.toCharArray();
       long result = 0;
       int len = 0;
       for(int i=arr.length-1; i >= 0; i--) {
          if(arr[i] == '1')  {
             result = result | (1 << len);
          }
          len++;
       }
       return result;
    }

    public void print(long val, int len)
    {
        String result = "";
        for(int i=0; i<len; i++) {
           if( (val & (1L << i))  != 0) {
               result = "1" + result;
           } 
           else {
               result = "0" + result;
           }
        }
        System.out.print(result);
    }

    public void calc(long[] init, long[] aps, int len)
    {
        int size = init.length;
        long[][] lookup = new long[size][size];
      
        for(int i=0; i<size; i++) {
           for(int j=0; j<size; j++) {
              lookup[i][j] = aps[j] ^ init[i];
           }
        }        

       for(int i=0; i<size; i++) {
          long comp = lookup[i][0];
          boolean used[] = new boolean[size];
          int ucount = 1;
          used[i] = true;
    
          for(int j=1; j<size; j++) {
              for(int k=0; k<size; k++) {
                  if(used[k] == true) {
                     continue;
                  }
                  if(comp == lookup[k][j]) {
                     used[k] = true;
                     ucount++;
                  }         
              } 
          }
           
          if(ucount == size) {
             int count = convertCount(comp, len);
             max = Math.min(max, count);
          }
       }
    }

    public int convertCount(long val, int len)
    {   
       int result = 0;
       for(int i=0; i<len; i++) {
           if( (val & (1L << i)) != 0) {
                result++;
           }
       }
       return result;
    }

    public void exec(int index) throws Exception
    {
       String line = b.readLine();
       String args[] = line.split("\\s+");
       int n = Integer.parseInt(args[0]);
       int l = Integer.parseInt(args[1]);
   
       long init[] = new long[n];
       long aps[] = new long[n];
       line = b.readLine();
       args = line.split("\\s+");
       for(int i=0; i<args.length; i++) {
          init[i] = convertLong(args[i]);
       }
       line = b.readLine();
       args = line.split("\\s+");
       for(int i=0; i<args.length; i++) {
          aps[i] = convertLong(args[i]);
       }
       max = Integer.MAX_VALUE;
       calc(init, aps, l);
       if(max == Integer.MAX_VALUE) {
           System.out.println("Case #" + index + ": NOT POSSIBLE");
       }
       else {
           System.out.println("Case #" + index + ": " + max);
       }
    }


    public static void main(String args[])  throws Exception
    {
        Chaos2 c = new Chaos2();
        c.go(args[0]);
    }
}
