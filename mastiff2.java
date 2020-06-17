import java.util.Scanner;
import java.io.*;
class mastiff2
{
	private static Scanner scan=new Scanner(System.in);//she is just being here---helping data from you to get to us---our cutee translator interface
	private static int size=30000;//let n be the number of memory cells for instruction set evaluation---here n=30,000
	private static byte strip[]=new byte[size];//8xn bits used from memory for strip data evaluation(cell size 1 byte of memory...btw does hearing "byte" make you crave for fooood too??)
	private static int ptr=0;//just a fickle memory cell pointer---dont worry about it much, it just takes care that I process the same cell data until asked to move 
	private static String output="";//I m dormant---until last; when ur output is revealed---then its my work to wrap it nicely for you and present it to you
	private static void compile(String code,String inpStr)//this guy takes ur code,chomps it---yum yum--then processes it as u wished,and yes in accordance to ur input set
	{
		int len=code.length(),inpInd=0;//sometimes isn't it good to know the code length??Don't worry about 2nd guy--he just takes ur inputs serially if input is from another file 
		for(int instrPtr=0;instrPtr<len;instrPtr++)//our heart!!
		{
			switch(code.charAt(instrPtr))
   			{
				case '+':++strip[ptr];break;//when recipe says '+' we add +1 to the cell you want
				
				case '-':--strip[ptr];break;//and when '-' obviously we have subtract 1 from the desired cell
				
				case '>':ptr=(ptr==size-1)?0:ptr+1;break;//wanna surf to the right cell? one cell at a time!
				
				case '<':ptr=(ptr==0)?size-1:ptr-1;break;//you know what --- moving left across memory is interesting, yeah obviously one cell at a time
				
				case ',':if(inpStr.equals("")){//if u had prompted me that u want to input from console ',' guy takes ur input guiding you through the way
				            System.out.print("Console input required at index "+ptr+" of the strip : ");
				            strip[ptr]=(byte)(scan.next().charAt(0));}
				         else//when u give me an input source--we take serial inputs from the file--cool!!?
				            strip[ptr]=(byte)inpStr.charAt(inpInd++);
				         break;
				
				case '.':output=output+(char)strip[ptr];break;//our output guy---take the output~~>place it in output string~~>repeat
                
                //we are kinda looping guys you know---we loop between [ and ] marks in the insruction cell, we just take ur repeatative tasks so that you need to write once!
				case '[':if(strip[ptr]==0)while(code.charAt(instrPtr)!=']')instrPtr++;break;//if the value at presnt cell goes 0,a booooshhh jump to ']'
				
				case ']':if(strip[ptr]!=0)while(code.charAt(instrPtr)!='[')instrPtr--;break;//if cell value isn't zero, go backkk to '[' !!!
				
				default:
			}
		}
	}
	public static String readFile() throws Exception //Naahhh!! dont go overwhelmed---we as a grouped guys just read any text file from ur system and give the text to the one who needs
	{
		String data="";
		File file=new File(scan.next());
		Scanner filescan = new Scanner(file);
		while (filescan.hasNextLine())
			data=data+filescan.nextLine();
		return data;
	}
	public static void writeFile(String data,String name) throws Exception//we are writers!! B) give us a file-a piece of thing to write and kabooom!!
	{
	    FileWriter myWriter = new FileWriter(name);
        myWriter.write(data);
        myWriter.close();
        System.out.println("Successfully output to the file : "+name);//see i told ya' B)
	}
	public static void finalstrip()// for nerds who wanna see operate my hippocampus kinda memory cells 
	{
	    System.out.print("\nHey are you nerd!! Wish to peep upon the memory matrix a bit? (y/n) : ");
	    if(scan.next().charAt(0)=='y'){
		System.out.println("\nHow many cells dude??\n");
		int c=0,lim=scan.nextInt();
		for(int i=0,j;c<lim;i++)
		{
			for(j=0;j<20;j++)
			{
				System.out.print(strip[c]+"\t");c++;
				if(c==lim)break;
			}
			System.out.println();
		}
		}
	}
	public static void resetmemory()//this is our way to wash the face nad have some snacks and drinks b4 the next session
	{
	    for(int i=0;i<size;i++)strip[i]=0;
	    int ptr=0;
	    output="";
	}
	//the nervous system!!! This big mann watches that things go as planned, and when exceptional things happen--system dosent hang!! bcz hanging is never the solution--you gotcha face it
	public static void main(String args[])
	{
	    String code,input;
	    outer: while(true){code="";input="";
	    System.out.println("C'mmon dude!!Choose~~> \n1.Live Interpreter or\n2.Source code path\n3.HALT SYSTEM!!");
	    int choice=scan.nextInt();
	    switch(choice)
	    {
	        case 1:System.out.print("\nEnter your code after the '#' appears \n\n# ");
	               code=scan.next();
	               break;
	        case 2:System.out.println("\nEnter source code path address\n");
	               try{code=readFile();}
	               catch(Exception e){System.out.println("EXCEPTION(things went wrong guys!!) in file name occured!!! : "+e);}
	               break;
	        case 3:System.exit(0);
	               break;
	        default:System.out.println("OOOPSSS!!Invalid input!!");continue outer;
	    }
	    System.out.println("\nFor above source code -- enter choice\n1.To handle inputs from console or\n2.for attaching an input source stream file\n");
	    choice=scan.nextInt();
	    switch(choice)
	    {
	        case 1:compile(code,"");
	               break;
	        case 2:System.out.println("\nEnter input source stream file path\n");
	               try{input=readFile();}
	               catch(Exception e){System.out.println("EXCEPTION(things went wrong guys!!) in file name occured!!! : "+e);}
	               compile(code,input);
	               break;
	        default:System.out.println("Sorry that's not an option I believe!!!");continue outer;
	    }
	    System.out.println("Your output is ready!!---enter\n1.for console output or\n2.to output to an external file\n");
	    choice=scan.nextInt();
	    switch(choice)
	    {
	        case 1:System.out.println("output--->\n"+output);
	               break;
	        case 2:System.out.println("Enter a suitable name for output file :");
	               try{writeFile(output,(scan.next()+".txt"));}
	               catch(Exception e){System.out.println("exception : "+e+" occured");}
	               break;
	        default:System.out.println("Mannn!! you okay?? ");continue outer;
	    }
	    finalstrip();
	    resetmemory();
	    }
	}
}
