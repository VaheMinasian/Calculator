package com.example.calculator.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.event.dom.client.KeyDownEvent;
import com.google.gwt.event.dom.client.KeyDownHandler;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */


public class Calculator implements EntryPoint {
	
		// panels
	  private VerticalPanel mainPanel = new VerticalPanel();
	  
	  private HorizontalPanel upperRow = new HorizontalPanel();
	  private VerticalPanel middleRow = new VerticalPanel();

	  // display area
	  private static Label resultScreen = new Label("0");

	  
	  // first row buttons
	  private HorizontalPanel nullRow = new HorizontalPanel();
	  private HorizontalPanel firstRow = new HorizontalPanel();
	  private HorizontalPanel secondRow = new HorizontalPanel();
	  private HorizontalPanel thirdRow = new HorizontalPanel();
	  private HorizontalPanel forthRow = new HorizontalPanel();

	  private calcButton cButton = new calcButton("C");
	  private calcButton backButton = new calcButton("⌫");
	  private calcButton sqrButton = new calcButton("a^2");
	  private calcButton sqrRootButton = new calcButton("√");
	  
	  private calcButton addButton = new calcButton("+");
	  private calcButton subtrButton = new calcButton("-");
	  private calcButton multipButton = new calcButton("x");
	  private calcButton devisionButton = new calcButton("/");
	  private calcButton commaButton = new calcButton(".");
	  private calcButton oneButton = new calcButton("1");
	  private calcButton twoButton = new calcButton("2");
	  private calcButton threeButton = new calcButton("3");
	  private calcButton fourButton = new calcButton("4");
	  private calcButton fiveButton = new calcButton("5");
	  private calcButton sixButton = new calcButton("6");
	  private calcButton sevenButton = new calcButton("7");
	  private calcButton eightButton = new calcButton("8");
	  private calcButton nineButton = new calcButton("9");
	  private calcButton zeroButton = new calcButton("0");
	  private calcButton calculateButton = new calcButton("=");

	  
	  private static double op1 = 0, op2 = 0;
	  private static double currentResult = 0d;
	  private static String currentString = "0";
	  private static String operator = "";
	  private static String current = "op1";
	  private static boolean decimal1 = false;
	  private static boolean decimal2 = false;

	  

  /**
   * Entry point method.
   */
  public void onModuleLoad() {
	  //Suggests the valid operators
	  resultScreen.getElement().setAttribute("maxlength", "2");
	  upperRow.add(resultScreen);
	  
	  nullRow.add(cButton); 
	  nullRow.add(backButton);
	  nullRow.add(sqrButton);
	  nullRow.add(sqrRootButton);
	  
	  firstRow.add(oneButton); 
	  firstRow.add(twoButton);
	  firstRow.add(threeButton);
	  firstRow.add(addButton);
	  
	  secondRow.add(fourButton);
	  secondRow.add(fiveButton);
	  secondRow.add(sixButton);
	  secondRow.add(subtrButton);

	  thirdRow.add(sevenButton);
	  thirdRow.add(eightButton);
	  thirdRow.add(nineButton);
	  thirdRow.add(multipButton);
	  
	  forthRow.add(commaButton);
	  forthRow.add(zeroButton);
	  forthRow.add(calculateButton);
	  forthRow.add(devisionButton);
	  
	  middleRow.add(nullRow);
	  middleRow.add(firstRow);
	  middleRow.add(secondRow);
	  middleRow.add(thirdRow);
	  middleRow.add(forthRow);
	  
	  middleRow.addStyleName("gwt-middle-row");
	  
	  mainPanel.add(upperRow);
	  mainPanel.add(middleRow);
   
    // Associate the Main panel with the HTML host page.
	    RootPanel.get("calc").add(mainPanel);
   
	    
	   /* calculateButton.addKeyDownHandler(new KeyDownHandler() {
	        public void onKeyDown(KeyDownEvent event) {
	          if (event.getNativeKeyCode() == KeyCodes.KEY_ENTER) {
	            updateDisplay("=");
	          }
	        }
	      });
	    */
  }
	    private static void calculate(String s) {
			if (operator=="") {
			if(s=="+") {
				currentResult = op1 + op2;
				
				resultScreen.setText(adjustResult(currentResult+""));
				reset();
				currentResult=Double.parseDouble(resultScreen.getText().trim());
				op1= currentResult;	
			} else if (s=="-") {
				currentResult = op1 - op2;
				resultScreen.setText(adjustResult("" + currentResult));
				reset();
				currentResult=Double.parseDouble(resultScreen.getText().trim());
				op1= currentResult;
			} else if (s=="x") {
				currentResult = op1 * op2;
				resultScreen.setText(adjustResult(currentResult+""));
				reset();
				currentResult=Double.parseDouble(resultScreen.getText().trim());
				op1= currentResult;	
			} else if ((s=="/")&&(op2!=0)) {
				currentResult = op1 / op2;
				resultScreen.setText(adjustResult(currentResult+""));
				reset();
				currentResult=Double.parseDouble(resultScreen.getText().trim());
				op1= currentResult;	
			} else if ((s=="/")&&(op2==0)) {
				resultScreen.setText("får ej delas med 0");
				reset();
			}
	    } 
			/*
			else if (operator!="") {
	    	if ((operator=="/")&&(op2==0)) {
				reset();
	    		resultScreen.setText("får ej delas med 0");
	    		return;
	    	}
	    	else if(operator=="+")
	    		op1 = op1+op2;
	    	else if (operator=="-")
	    		op1 = op1-op2;
	    	else if (operator=="*")
	    		op1 = op1*op2;
	    	else if ((operator=="/")&&(op2!=0))
	    		op1 = op1/op2;
	    	
	    	currentString=op1+"";
	    	resultScreen.setText(adjustResult(currentString));
	    }*/
	    }
	    /*
	    calculateButton.addClickHandler(new ClickHandler() {
        public void onClick(ClickEvent event) {
          calculate();
        }});
  }		
		
			final String operator = operatorTextBox.getText().trim();
			calculateButton.setFocus(true);
			if ((!operator.equals("*") && !operator.equals("+") && !operator.equals("%")) || !isInteger(operand1TextBox.getText().trim())|| !isInteger(operand2TextBox.getText().trim())) {
		        Window.alert("You have entered a non valid binary operator or one of the operands is not an integer");
		        
		        return;
		      }
			
			 int operand1=Integer.parseInt(operand1TextBox.getText());
			 int operand2=Integer.parseInt(operand2TextBox.getText());
			 int answer;
			 //Multiplication
			 if(operator.equals("*"))
			 {
				 answer=operand1*operand2;
				 Window.alert("The answer is: " + answer);
			 }
			 //Modulo
			 else if (operator.equals("%"))
			 {
				 answer=operand1%operand2;
				 Window.alert("The answer is: " + answer);
			 }
			 //addition
			 else { 
				 answer=operand1+operand2;
				 Window.alert("The answer is: " + answer);		 
			 }
			*/
		
		public static void updateDisplay(String s) {
			
		switch(s) {
			case "C":
				reset();
				resultScreen.setText(adjustResult("" + currentResult));
				break;
			
			case ".":	
				if ((current=="op1")&&(!decimal1)) {
					currentString = resultScreen.getText().trim();
					currentString += s;
					currentResult= Double.parseDouble(currentString);
					updateOperant(currentResult);
					resultScreen.setText(adjustResult(currentString));
					decimal1=true;
				}else if ((current=="op2")&&(!decimal2)) {
					currentString = resultScreen.getText().trim();
					if(op2!=0)
						currentString += s;
					else if(op2==0)
						currentString = "0"+s;
					currentResult= Double.parseDouble(currentString);
					updateOperant(currentResult);
					resultScreen.setText(adjustResult(currentString));
					decimal2=true;
				}
				break;
			
			case "⌫":
					String tString = resultScreen.getText().trim(); 
					int temp = tString.length();
					if(tString.charAt(temp-1)=='.')
						if (current=="op1")
						decimal1=false;
						else if (current=="op2")
						decimal2=false;
					if(temp==1)
						resultScreen.setText("0");
					currentString = resultScreen.getText().trim().substring(0, temp-1);
					currentResult = Double.parseDouble(currentString);
					updateOperant(currentResult);
					resultScreen.setText(adjustResult(currentString));
		
					break;
			
			case "a^2":
				double sqtemp = Double.parseDouble(resultScreen.getText().trim());
				sqtemp *= sqtemp;
				updateOperant(sqtemp);
				currentString = sqtemp + "";
				if (currentString.length()>14) {
					resultScreen.setText(adjustResult(currentString));
				} else if (currentString.length()<=14) {
					resultScreen.setText(adjustResult(currentString));
				}
				break;
			
			case "√":
				double rttemp = Double.parseDouble(resultScreen.getText().trim());
				rttemp = Math.sqrt(rttemp);
				updateOperant(rttemp);
				currentString = rttemp + "";
				if (currentString.length()>14) {
					resultScreen.setText(adjustResult(currentString));
				} else if (currentString.length()<=14) {
					resultScreen.setText(adjustResult(currentString));
				}
				break;
			
			case "+":
			case "-":
			case "x":
			case "/":
				operator = s;
				current = "op2";
				//if((operator!="")&&(op2!="0"))
				//calculate("operator");
				
				break;
			case "=":
				String op = operator;
				operator = "";
				calculate(op);
				break;
			case "0":				
			case "1":
			case "2":
			case "3":
			case "4":
			case "5":
			case "6":
			case "7":
			case "8":
			case "9":
				
				if ((current=="op1")&&(op1==0)) {
					Window.alert("a");
					if(decimal1)
						currentString += s; 
					else if (!decimal1)
						currentString = s;
					op1 = Double.parseDouble(currentString);
					if (operator=="-")
					op1 = op1*-1;
					currentString = op1+"";
					resultScreen.setText(adjustResult(currentString));

				} else if ((current=="op1")&&(op1!=0)) {
					Window.alert("b");
					
					currentString += s;
					op1 = Double.parseDouble(currentString);
					resultScreen.setText(adjustResult(currentString));

				} else if ((current=="op2")&&(op2==0)) {
					Window.alert("c");

					if(decimal2)
						currentString += s; 
					else if(!decimal2)
						currentString = s;	
					op2 = Double.parseDouble(currentString);
					resultScreen.setText(adjustResult(currentString));

				}	else if ((current=="op2")&&(op2!=0)) {
					Window.alert("d");

						currentString += s;
					op2 = Double.parseDouble(currentString);
					resultScreen.setText(adjustResult(currentString));

					}
			
			default:
			break;
		}	
	}
		
		static void reset() {
			op1 = 0; op2=0;
			currentString = "";
			operator = "";
			currentResult = 0;
			current = "op1";
			decimal1 = false;
			decimal2 = false;
		}
		
		public static boolean isInteger( String input )
		{
		   try
		   {
		      Integer.parseInt( input );
		      return true;
		   }
		   catch(NumberFormatException e)
		   {
		      return false;
		   }
		}
		public static void updateOperant(Double s) {
			if(current=="op1") {
				op1 = s;
			}else if (current=="op2") {
				op2 = s;
			}	
		}
		public static String adjustResult(String s) {
			String result ="";
			if(s.length()>14) 
				result = s.substring(0, 14);
			else
				result = s;
			return result;
		}
}
