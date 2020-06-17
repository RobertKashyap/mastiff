 consider a programming language "mastiff"
 it has 8 commands only
 
 +  increment of value of cell by 1
 -  decreasing the value of cell by 1
 >  moves the pointer to the next cell
 <  moves the pointer to the previous cell
 ,  input into the cell
 .  output the contents of the cell
 [  if cell:present == 0 goto "]"
 ]  if cell:present != 0 foto "["
 
 this code "mastiff.java" is a compiler---it simply takes in a source code written in the above mentioned commands and runs in an large strip of memory containing 30,000 cells each of one byte in size.
 
 the source code can manipulate the contents of cells based on the commands given
 
 at program startup--the memory pointer is at cell:0 and all cells are empty
 we can move around into cells using "<" & ">" by moving the pointer  "+" & "-" can increase or decrease cell contents 
 "," inputs data   while "." outputs data from the cell
 "[" & "]" forms a loop in the code bcz---if instruction reads "[" and if content of cell at pointer equal to zero---the instruction pointer jumps to successive "]"
 whereas if instruction reads "]" and if content of the present cell is not equal to zero, ---the  the instruction pointer jumps to preceeding "]"
 "[" and "]" are always paired or compiler will hang---and hanging is never an option!
 
 after excecuting an instruction...machine simply reads the next 
 
 every thing else in the source code except +-><,.[] are ignored and hence considered comments
 
 examples:
1. source code:
               ++++++++++[>+>+++>+++++++>++++++++++<<<<-]>>>++.>+.+++++++..+++.<<++.>+++++++++++++++.>.+++.------.--------.<<+.<.
   output:
          Hello World!
2.source code :
                .+[.+]prints the whole of ascii set
  output:
         	
         
          !"#$%&'()*+,-./0123456789:;<=>?@ABCDEFGHIJKLMNOPQRSTUVWXYZ[\]^_`abcdefghijklmnopqrstuvwxyz{|}~ ¡¢£¤¥¦§¨©ª«¬­®¯°±²³´µ¶·¸¹º»¼½¾¿ÀÁÂÃÄÅÆÇÈÉÊËÌÍÎÏÐÑÒÓÔÕÖ×ØÙÚÛÜÝÞßàáâãäåæçèéêëìíîïðñòóôõö÷øùúûüýþÿ

(in above example ".+[.+]prints the whole of ascii set"----"prints the whole of ascii set" is automatically taken as comment lines)

3.source code:
              ,>,[+<->]<.To print of sum of two ascii values from input
  inputs:
         (prompt for first value): 3(say)
         (prompt for second value):4(say)
         output--> g 
         bcz 3=51(ascii code)&4=52(in ascii) 3+4=>51+52=53=>g(in ascii code)
         
NOTE: this whole language is totally turing complete---so practically anything can be made using this language--provided enough space, time and energy.
(but this compiler may have bugs--do return corrections)
