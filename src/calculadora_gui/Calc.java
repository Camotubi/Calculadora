package calculadora_gui;

public class Calc {
	public static final String COSINE ="c";
	public static final String SINE	= "s";
	public static final String TANGENT= "t";
	public static final String ARCOSINE = "C";
	public static final String ARCSINE = "S";
	public static final String ARCTANGENT= "T";
	public static final String NATURAL_LOG= "l";
	public static final String LOG= "L";
	private char[] priOrder = {'c','s','t', 'q','w','r','l','L', '^','/','*','+'};//Priority Order
	
	public double StringToCalculations(String commands)
	{
		String[] comStat = new String[3];// comStat[0] is the type of operation remaining, comStat[1] is the position of the operation and comStat[2] is "1" if there is a minus in the string and it is not at the beginning
		double answer=0;
		String rNum= "";
		String lNum= "";
		String commandsInPar="";
		commands = commands.replaceAll("Cos","c");
		commands = commands.replaceAll("Sin","s");
		commands = commands.replaceAll("Tan","t");
		commands = commands.replaceAll("Acs", "C");
		commands = commands.replaceAll("Asn", "S");
		commands = commands.replaceAll("Atn", "T");
		commands = commands.replaceAll("Ln", "l");
		commands = commands.replaceAll("Log", "L");
		int lFI;// left first index
		int rLI;// right last index
		int oParI=-1; //opening parenthesis index
		int cParI=-1; //closing parenthesis index
		int cParC=0; //closing parenthesis counter
		boolean match = false; // false when  a "match"with a closing parenthesis ")" has not been found
		boolean mapped = false; // true if the commands string has been "scanned" already for opening and closing parenthesis "(" , ")"
		int i;
		do
		{
			for(int ParI = commands.length()-1 ; ParI >-1  ; ParI--)
			{
				if(commands.charAt(ParI)==')'  && !match)
				{
					if(!mapped)
					{
					cParC++;
					}
					cParI=ParI;
				}else if(commands.charAt(ParI)==')')
					{
						if(!mapped)
						{
						cParC++;
						}
					}
				
				if(commands.charAt(ParI)=='(' && !match)
				{
					match = true;	
					oParI=ParI;	
					System.out.println(commands);
					commandsInPar = commands.substring(oParI+1,cParI);
					System.out.println("commandsInPar:" + commandsInPar);
				}
				System.out.println( "cParC:" + cParC );
				System.out.println("oParI:"+ oParI+ " cParI:" + cParI);
				
			}
			
			mapped = true;
			
			if(match){
				System.out.println("oParI:"+ oParI+ " cParI:" + cParI);
				if(oParI==0 && cParI==commands.length()-1)
				{
					match = false;
					System.out.println("Estoy llamando a la funcionStrin"+commandsInPar);
					
					commands=String.valueOf(StringToCalculations(commandsInPar));
				}else{
					if(oParI==0 && cParI!=commands.length()-1)
					{
						match = false;
						System.out.println("oParI==0");
						commands=StringToCalculations(commandsInPar)+commands.substring(cParI+1,commands.length());
					}
					if(oParI >0 &&cParI==commands.length()-1)
					{
						System.out.println("HEY");
						System.out.println("Estoy llamando a la funcionStrin"+commandsInPar);
						commands=commands.substring(0,oParI)+StringToCalculations(commandsInPar);
						System.out.println("Esto es coomands:"+commands);
						match = false;
					}
					if(oParI > 0 && cParI<commands.length())
					{
						System.out.println(commands.length()-1);
						System.out.println("Esto es commands:"+ commands);
						System.out.println("ESTO: es coommandsinpar: " + commandsInPar);
						commands=commands.substring(0,oParI)+StringToCalculations(commandsInPar)+commands.substring(cParI+1,commands.length());
						match = false;
					}
				}
				cParC--;
			}
				oParI=0;
				cParI=0;
				
		}while(cParC>0);
		
		comStat = OpChecker(commands, priOrder);
		while(comStat[0]!="0")//While there are remaining operations
		{
			if(comStat[2]=="1")
			{
				commands=commands.substring(0,Integer.parseInt(comStat[1]))+ "+" + commands.substring(Integer.parseInt(comStat[1]));
				
				System.out.println("Esto es commands:" + commands);
			}

			switch(comStat[0])
			{
		
			case "c":
				
				for(i = Integer.parseInt(comStat[1])+1; (i < commands.length())&&(!OpCheckerB(commands, priOrder ,i)); i++)
				{
					rNum=rNum+commands.charAt(i);
				}
				rLI=i;
				System.out.println("rNum:"+rNum);
				System.out.println("Commands:"+commands);
				
				if(Integer.parseInt(comStat[1])==0)
				{
					commands=String.valueOf(cos(Double.parseDouble(rNum)))+commands.substring(rLI);
				} else
				{
					commands=commands.substring(0,Integer.parseInt(comStat[1]))+String.valueOf(cos(Double.parseDouble(rNum)))+commands.substring(rLI);
				}
				break;
				
			case "s":

				for(i = Integer.parseInt(comStat[1])+1; (i < commands.length())&&(!OpCheckerB(commands, priOrder ,i)); i++)
				{
					rNum=rNum+commands.charAt(i);
				}
				rLI=i;
				System.out.println("rNum:"+rNum);
				System.out.println("Commands:"+commands);
				
				if(Integer.parseInt(comStat[1])==0)
				{
					commands=String.valueOf(sin(Double.parseDouble(rNum)))+commands.substring(rLI);
				} else
				{
					commands=commands.substring(0,Integer.parseInt(comStat[1]))+String.valueOf(sin(Double.parseDouble(rNum)))+commands.substring(rLI);
				}
				break;
				
			case "t":

				for(i = Integer.parseInt(comStat[1])+1; (i < commands.length())&&(!OpCheckerB(commands, priOrder ,i)); i++)
				{
					rNum=rNum+commands.charAt(i);
				}
				rLI=i;
				System.out.println("rNum:"+rNum);
				System.out.println("Commands:"+commands);
				
				if(Integer.parseInt(comStat[1])==0)
				{
					commands=String.valueOf(tan(Double.parseDouble(rNum)))+commands.substring(rLI);
				} else
				{
					commands=commands.substring(0,Integer.parseInt(comStat[1]))+String.valueOf(tan(Double.parseDouble(rNum)))+commands.substring(rLI);
				}
				break;
			
			case "C":
				for(i = Integer.parseInt(comStat[1])+1; (i < commands.length())&&(!OpCheckerB(commands, priOrder ,i)); i++)
				{
					rNum=rNum+commands.charAt(i);
				}
				rLI=i;
				System.out.println("rNum:"+rNum);
				System.out.println("Commands:"+commands);
				
				if(Integer.parseInt(comStat[1])==0)
				{
					commands=String.valueOf(acos(Double.parseDouble(rNum)))+commands.substring(rLI);
				} else
				{
					commands=commands.substring(0,Integer.parseInt(comStat[1]))+String.valueOf(acos(Double.parseDouble(rNum)))+commands.substring(rLI);
				}
				break;
				
			case "S":
				for(i = Integer.parseInt(comStat[1])+1; (i < commands.length())&&(!OpCheckerB(commands, priOrder ,i)); i++)
				{
					rNum=rNum+commands.charAt(i);
				}
				rLI=i;
				System.out.println("rNum:"+rNum);
				System.out.println("Commands:"+commands);
				
				if(Integer.parseInt(comStat[1])==0)
				{
					commands=String.valueOf(asin(Double.parseDouble(rNum)))+commands.substring(rLI);
				} else
				{
					commands=commands.substring(0,Integer.parseInt(comStat[1]))+String.valueOf(asin(Double.parseDouble(rNum)))+commands.substring(rLI);
				}
				break;
				
			case "T":
				for(i = Integer.parseInt(comStat[1])+1; (i < commands.length())&&(!OpCheckerB(commands, priOrder ,i)); i++)
				{
					rNum=rNum+commands.charAt(i);
				}
				rLI=i;
				System.out.println("eeerNum:"+rNum);
				System.out.println("Commands:"+commands);
				
				if(Integer.parseInt(comStat[1])==0)
				{
					commands=String.valueOf(atan(Double.parseDouble(rNum)))+commands.substring(rLI);
				} else
				{
					commands=commands.substring(0,Integer.parseInt(comStat[1]))+String.valueOf(atan(Double.parseDouble(rNum)))+commands.substring(rLI);
				}
				break;
				
			case "l":
				for(i = Integer.parseInt(comStat[1])+1; (i < commands.length())&&(!OpCheckerB(commands, priOrder ,i)); i++)
				{
					rNum=rNum+commands.charAt(i);
				}
				rLI=i;
				System.out.println("eeerNum:"+rNum);
				System.out.println("Commands:"+commands);
				
				if(Integer.parseInt(comStat[1])==0)
				{
					commands=String.valueOf(ln(Double.parseDouble(rNum)))+commands.substring(rLI);
				} else
				{
					commands=commands.substring(0,Integer.parseInt(comStat[1]))+String.valueOf(ln(Double.parseDouble(rNum)))+commands.substring(rLI);
				}
				break;
			case "L":
				for(i = Integer.parseInt(comStat[1])+1; (i < commands.length())&&(!OpCheckerB(commands, priOrder ,i)); i++)
				{
					rNum=rNum+commands.charAt(i);
				}
				rLI=i;
				System.out.println("eeerNum:"+rNum);
				System.out.println("Commands:"+commands);
				
				if(Integer.parseInt(comStat[1])==0)
				{
					commands=String.valueOf(log(Double.parseDouble(rNum)))+commands.substring(rLI);
				} else
				{
					commands=commands.substring(0,Integer.parseInt(comStat[1]))+String.valueOf(log(Double.parseDouble(rNum)))+commands.substring(rLI);
				}
				break;
			
			case "^":
				
				for(i = Integer.parseInt(comStat[1])+1; (i < commands.length())&&(!OpCheckerB(commands, priOrder ,i)); i++)
				{
					rNum=rNum+commands.charAt(i);
				}
				rLI=i;
				for(i = Integer.parseInt(comStat[1]) - 1; (i > -1)&&(!OpCheckerB(commands, priOrder,i)); i--)
				{
					lNum=commands.charAt(i)+lNum;
				}
				if(i<0){
					lFI=0;
				}else {lFI=i+1;}
				commands=commands.substring(0,lFI)+String.valueOf(pow(Double.parseDouble(lNum),Double.parseDouble(rNum)))+commands.substring(rLI);
				break;
				
			case "/":

				for(i = Integer.parseInt(comStat[1])+1; (i < commands.length())&&(!OpCheckerB(commands, priOrder ,i)); i++)
				{
					rNum=rNum+commands.charAt(i);
				}
				
				rLI=i;
				System.out.println(rLI);
				for(i = Integer.parseInt(comStat[1]) - 1; (i > -1)&&(!OpCheckerB(commands, priOrder,i)); i--)
				{
					lNum=commands.charAt(i)+lNum;
				}
				if(i<0){
					lFI=0;
				}else {lFI=i+1;}
				commands=commands.substring(0,lFI)+String.valueOf(div(Double.parseDouble(lNum),Double.parseDouble(rNum)))+commands.substring(rLI);
				break;
				
			case "*":
			
				for(i = Integer.parseInt(comStat[1])+1; (i < commands.length())&&(!OpCheckerB(commands, priOrder ,i)); i++)
				{
					rNum=rNum+commands.charAt(i);
				}
				rLI=i;
				System.out.println(rLI);
				for(i = Integer.parseInt(comStat[1]) - 1; (i > -1)&&(!OpCheckerB(commands, priOrder,i)); i--)
				{
					lNum=commands.charAt(i)+lNum;
				}
				if(i<0){
					lFI=0;
				}else {lFI=i+1;}
			
				commands=commands.substring(0,lFI)+String.valueOf(mult(Double.parseDouble(lNum),Double.parseDouble(rNum)))+commands.substring(rLI);
				break;
				
			case "+":	
			case"-":
				
				for(i = Integer.parseInt(comStat[1])+1; (i < commands.length())&&(!OpCheckerB(commands, priOrder ,i)); i++)
				{
					rNum=rNum+commands.charAt(i);
				}
				rLI=i;
				System.out.println(rLI);
				for(i = Integer.parseInt(comStat[1]) - 1; (i > -1)&&(!OpCheckerB(commands, priOrder,i)); i--)
				{
					lNum=commands.charAt(i)+lNum;
				}
				System.out.println("rNum:" +rNum + " lNum:"+ lNum);
				if(i<0){
					lFI=0;
				}else {lFI=i+1;}
				commands=commands.substring(0,lFI)+String.valueOf(sum(Double.parseDouble(lNum),Double.parseDouble(rNum)))+commands.substring(rLI);
				break;
				
				default: break;
			}
		
			rNum="";
			lNum="";
			lFI=0;
			rLI=0;
			oParI=0;
			cParI=0;
			comStat = OpChecker(commands, priOrder);
			System.out.println("comStat:"+comStat[0]+comStat[1]);
		}
		System.out.println(commands);
		if(commands=="")
		{
			answer=0;
		}
		else answer=Double.parseDouble(commands);
		System.out.println("termine");
		oParI=0;
		cParI=0;
		return answer;
	}

	public  String[] OpChecker(String expression,char[] priorityOrder)//Checks for operations in the string attending to the order of priority and returns where is it.
	{
		String[] report = new String[3];
		int expressionIndex;//expression index
		int priorityOrderIndex;//operation Index
		for(priorityOrderIndex=0 ;  priorityOrderIndex < priorityOrder.length ; priorityOrderIndex++)
		{
			for(expressionIndex=expression.length()-1 ;  expressionIndex > -1 ; expressionIndex-- )
			{
				if(expression.charAt(expressionIndex)==priorityOrder[priorityOrderIndex])
				{
					report[0]=String.valueOf(priorityOrder[priorityOrderIndex]);
					report[1]=String.valueOf(expressionIndex);
					report[2]="0";
					System.out.println("Se encontro la operacion :(" + priorityOrder[priorityOrderIndex] + ") en la posicion:(" + expressionIndex + ") del string");
					return report;
				}
				
			}
			
		}	
			for(expressionIndex=expression.length()-1 ;  expressionIndex > -1 ; expressionIndex-- )
			{
				if(expression.charAt(expressionIndex)=='-' && expressionIndex!=0  )
				{
					report[0]="+";
					report[1]=String.valueOf(expressionIndex);
					report[2]="1";
					return report;
				}
			}
		report[0]="0";
		report[1]="0";
		report[0]="0";
		System.out.println("No Se encontro ninguna operacion restante en la string");
		return report;
	}	

	public  boolean OpCheckerB(String commands,char[] operations,int cIS)// Check for operation in A SPOT, return true or false
	{
		
		int operationsIndex;//op Index
		for(operationsIndex=0 ;  operationsIndex < operations.length ; operationsIndex++)
		{
			if(commands.charAt(cIS)==operations[operationsIndex])
			{
				System.out.println("OpCheckerB:Se encontro la operacion:(" + operations[operationsIndex] + ") en la posicion:(" + cIS + ") del string");
				return true;
			}
		}
		System.out.println("OpCheckerB:No Se encontro ninguna operacion restante en la posicion: "+ cIS+ " la string");
		return false;
	}
	public double pow(double base, double exp){
		return Math.pow(base,exp);
	}
	public double mult(double a, double b){
		return a*b;
	}
	public double div(double num, double denom){
		return num/denom;
	}
	public double sum(double a, double b){
		return a+b;
	}
	public double log(double a){
		return Math.log10(a);
	}
	public double ln(double a){
		return Math.log(a);
	}
	public double acos(double a){
		return Math.acos(a);
	}
	public double asin(double a){
		return Math.asin(a);
	}
	public double atan(double a){
		return Math.atan(a);
	}
	public double cos(double a){
		return Math.cos(a);
	}
	public double sin(double a){
		return Math.sin(a);
	}
	public double tan(double a){
		return Math.tan(a);
	}
	public int factorial(int a){
		int result=a;
		for(int i=1; i<a;i++){
			result= result*(a-i);
		}
		return result;
	}
}
	

