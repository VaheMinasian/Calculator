package com.example.calculator.client;

import java.awt.ComponentOrientation;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.VerticalPanel;
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
	  private calcButton calculateButton = new calcButton("=");
	  private calcButton commaButton = new calcButton(",");
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
	  
	  
	  private static String currentResult = "0";

	  

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
   
	    /*
	    calculateButton.addClickHandler(new ClickHandler() {
        public void onClick(ClickEvent event) {
          calculate();
        }});
  }	

		private void calculate() {
		
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
			*/}
		//Checkes if a String could be seen as an integer
		public static String getResultScreen() {
			return resultScreen.getText();
		}
		public static void setResultScreen(String number) {
			resultScreen.setText(number);
		}
		public static void updateDisplay(String s) {
			if (s=="C") {
				currentResult = "0";
				resultScreen.setText("0");
				return;
			}
			if(s=="⌫"){
				int temp = resultScreen.getText().trim().length(); 
				currentResult = resultScreen.getText().substring(0, temp-1);
				resultScreen.setText(currentResult);
				return;
				}
			
			  if (currentResult=="0") {
				  if (s=="0") {
				  }
				  else{
					  currentResult = s;
					  resultScreen.setText(currentResult);
				  }
			  } else if (currentResult != "0") {
				  currentResult += s; 
				  resultScreen.setText(currentResult);
			  }
			  if(resultScreen.getText().trim().length()>=12) {
					resultScreen.setText(resultScreen.getText().substring( 0, 12 ));
					}
		}
		
		public boolean isInteger( String input )
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
}
