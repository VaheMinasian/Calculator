package com.example.calculator.client;

import java.awt.Component;

import javax.swing.SwingConstants;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.dev.jjs.ast.JLabel;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.MultiWordSuggestOracle;
import com.google.gwt.user.client.ui.SuggestBox;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */


public class Calculator implements EntryPoint {
	  private VerticalPanel mainPanel = new VerticalPanel();
	  
	  private HorizontalPanel upperRow = new HorizontalPanel();
	  private Label resultScreen = new Label("0");

	  private VerticalPanel middleRow = new VerticalPanel();

	  private HorizontalPanel firstRow = new HorizontalPanel();
	  private HorizontalPanel secondRow = new HorizontalPanel();
	  private HorizontalPanel thirdRow = new HorizontalPanel();
	  private HorizontalPanel forthRow = new HorizontalPanel();

	  private Button addButton = new Button("+");
	  private Button subtrButton = new Button("-");
	  private Button multipButton = new Button("x");
	  private Button devisionButton = new Button("/");
	  private Button calculateButton = new Button("=");
	  private Button commaButton = new Button(",");
	  private Button oneButton = new Button("1");
	  private Button twoButton = new Button("2");
	  private Button threeButton = new Button("3");
	  private Button fourButton = new Button("4");
	  private Button fiveButton = new Button("5");
	  private Button sixButton = new Button("6");
	  private Button sevenButton = new Button("7");
	  private Button eightButton = new Button("8");
	  private Button nineButton = new Button("9");
	  private Button zeroButton = new Button("0");

  /**
   * Entry point method.
   */
  public void onModuleLoad() {
	  //Suggests the valid operators
	  
	  upperRow.add(resultScreen);
	  
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
	
	  middleRow.add(firstRow);
	  middleRow.add(secondRow);
	  middleRow.add(thirdRow);
	  middleRow.add(forthRow);
	  
	  middleRow.addStyleName("gwt-middle-row");
	  mainPanel.add(upperRow);
	  mainPanel.add(middleRow);
   
	   
    // Associate the Main panel with the HTML host page.
	  
	    RootPanel.get("calc").add(mainPanel);
   
	    
	    calculateButton.addClickHandler(new ClickHandler() {
        public void onClick(ClickEvent event) {
          calculate();
        }});
  }	

		private void calculate() {
		/*
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
