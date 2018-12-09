
package sort_find;
import java.io.*;
import java.io.BufferedReader;
//import java.io.StringReader;

public class Main {
	//package sort_find;

	public static void main (String[] args)
	{
		try {
		BufferedReader reader=new BufferedReader(new FileReader("C:\\Users\\ridhima\\Downloads\\csx-351-hw3-pankushm88-master\\HW3-unsorted-keywords.txt"));
		//reader.mark(0) and read src file1;
		String line=reader.readLine();
		int count=0;
		while(line!=null)//read no of keywords in source file
		{if(line.length()>0)
		   { 
			   count++;
		
			//System.out.println(line);
		   }
		line=reader.readLine();
		
		}
		
		//count++;
		System.out.println(count);
		if(count==84)
			System.out.println("You are on the right path");//if 84 keywords then file is correct
		else
		{
			System.out.println("Sorry not right file");//else the file is incorrect 
			System.exit(0);
			
		}
		//reader.reset();
        reader.close();//terminate src file
		
        BufferedReader reader1=new BufferedReader(new FileReader("C:\\Users\\ridhima\\Downloads\\csx-351-hw3-pankushm88-master\\HW3-unsorted-keywords.txt"));
		//read source file again
        
        String keywords[]=new String[count];
		line=reader1.readLine();//read line by line
		int i=0;
		while(line!=null)
		{if(line.length()>0)
		   { 
			 keywords[i++]=line;
		   }
		line=reader1.readLine();
		
		}
		//for(int j=0;j<i;j++)
		//   System.out.println(keywords[j]);
		reader1.close();
		//System.out.println("Sorted:");
		Sort a=new Sort(keywords,84);//call sort function
		for(int j=0;j<i;j++)
	    	System.out.println(keywords[j]);//print found keyword
			
		BufferedReader reader2=new BufferedReader(new FileReader("C:\\Users\\ridhima\\Desktop\\java lab\\HW3-input-code.cpp"));
		//read keywords from given cpp prog
		line=reader2.readLine()+" ";//space for character termination
		int start=0;int numline=1;
		int totcount=0,lcount;
		FileWriter f_w= new FileWriter("C:\\Users\\ridhima\\Desktop\\java lab\\output3.txt.txt");//display on output file
		BufferedWriter wr=new BufferedWriter(f_w);//writes on output3.txt file
		String str="";int l=0;
		while(line!=null)
		{
			start=0;lcount=0;
			int len=line.length();
			if(line.length()>0)
			{
				str=""; l=0;
				while(l<len)
				{
					if(line.charAt(l)=='/' && (l+1)<len && line.charAt(l+1)=='/' )//dont include commenting part
						break;
					if(belongs(line.charAt(l))==1)//calls belongs static method
					{
						str=str+line.charAt(l);
					}
					else
					{
						//search
						Search word=new Search();
						if(word.present(str,keywords,84)==1)
						{
							if(lcount==0)
							{wr.newLine();
								String str1="Line "+Integer.toString(numline)+": ";
								//Returns a String object representing the specified integer
								//Argument is converted to signed decimal representation and returned as a string
								
								str1+=str+"("+Integer.toString(start)+")";
								//write
								wr.write(str1);
								System.out.println(str1);
							}
							else
							{
								String str2=" "+ str+"("+Integer.toString(start)+")";
								//write
								wr.write(str2);
								System.out.println(str2);
							}
							
							//write
							totcount++;
							lcount++;
						}
						start=l+1;
						str="";
					}
					l++;	
				  }
				
			}
			numline++;
			
			line=reader2.readLine();
			if(line==null)
				break;
			line=line+" ";
			
		//	System.out.println("line read = "+numline);
		}
		wr.newLine();
		String str3="Number of keywords found = "+Integer.toString(totcount);
		wr.write(str3);
		wr.close();
		System.out.println("Total count= "+totcount);
		
		reader2.close();
		
		
	  }
		catch (IOException e)//signals if i/o exception has occured
		{
			e.printStackTrace();//Prints this throwable and its backtrace to the standard error stream
		}
	}
static int belongs(char c)
{
	if((c>='a' && c<='z')|| (c=='_') || (c>='0' && c<='9'))//valid keyword start with a-z,0-9,'_'
		return 1;
	else
		return 0;
}

}

