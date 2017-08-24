package com.example.calculator.client;

import com.google.gwt.event.dom.client.MouseDownEvent;
import com.google.gwt.event.dom.client.MouseDownHandler;
import com.google.gwt.user.client.ui.Button;

public class calcButton extends Button implements MouseDownHandler {

	String buttonLabel = ""; 
	
	public calcButton(String string) {
		this.buttonLabel = string;
		this.setText(buttonLabel);
		addMouseDownHandler(this);
	}
	public String asString() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void onMouseDown(MouseDownEvent event) {
		// TODO Auto-generated method stub
		Calculator.updateDisplay(this.buttonLabel);

	}
	
}
