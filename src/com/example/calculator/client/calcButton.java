package com.example.calculator.client;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;

public class calcButton extends Button implements ClickHandler{

	String buttonLabel = ""; 
	
	public calcButton(String string) {
		this.buttonLabel = string;
		this.setText(buttonLabel);
		addClickHandler(this);
	}
	@Override
	public void onClick(ClickEvent event) {
		Calculator.updateDisplay(this.buttonLabel);
	}
}
