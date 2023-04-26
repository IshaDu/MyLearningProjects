package com.learnswings;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class CalculateCost {
// Simple java swing application to calculate trip cost
	public static void main(String[] args) {
		JFrame calulateCostFrame=new JFrame("Calculate Cost"); 
		calulateCostFrame.setSize(500,350);  
		calulateCostFrame.setLayout(null);  
		calulateCostFrame.setVisible(true);
		
		JLabel distanceLabel = new JLabel("Enter Distance to be Travelled(in miles): ");
		distanceLabel.setVisible(true);
		distanceLabel.setBounds(50,50, 250,20);
		
		JTextField distanceTextField=new JTextField();  
		distanceTextField.setBounds(300,50, 150,20);  
		distanceTextField.setVisible(true);
		
		JLabel gasPriceLabel = new JLabel("Enter Gas Price(per gallon): ");
		gasPriceLabel.setVisible(true);
		gasPriceLabel.setBounds(50,100, 200,20);

		JTextField gasPriceTextField=new JTextField();  
		gasPriceTextField.setBounds(300,100, 150,20);  
		gasPriceTextField.setVisible(true);
		
		JLabel carMileageLabel = new JLabel("Enter Car Mileage (On Highways): ");
		carMileageLabel.setVisible(true);
		carMileageLabel.setBounds(50,150, 200,20);		
		
		JTextField carMileageTextField=new JTextField();  
		carMileageTextField.setBounds(300,150, 150,20);  
		carMileageTextField.setVisible(true);
		
		JLabel tripCostLabel = new JLabel("Your trip costs ($) : ");
		tripCostLabel.setVisible(true);
		tripCostLabel.setBounds(50,200, 200,20);		
		
		JTextField tripCostTextField=new JTextField();  
		tripCostTextField.setBounds(300,200, 150,20);  
		tripCostTextField.setVisible(true);
		
		
		JButton calculateButton=new JButton("Calculate");
		calculateButton.setVisible(true);
		calculateButton.setBounds(50,250,90,30);
		
		JButton clearButton=new JButton("Clear");
		clearButton.setVisible(true);
		clearButton.setBounds(150,250,90,30);
		
		JButton closeButton=new JButton("Close");
		closeButton.setVisible(true);
		closeButton.setBounds(250,250,90,30);
		
		calulateCostFrame.add(distanceLabel);
		calulateCostFrame.add(distanceTextField);
		calulateCostFrame.add(gasPriceLabel);
		calulateCostFrame.add(gasPriceTextField);
		calulateCostFrame.add(carMileageLabel);
		calulateCostFrame.add(carMileageTextField);
		calulateCostFrame.add(calculateButton);
		calulateCostFrame.add(clearButton);
		calulateCostFrame.add(closeButton);
		calulateCostFrame.add(tripCostLabel);
		calulateCostFrame.add(tripCostTextField);
		
		//Action performed on click of clear button
		clearButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				distanceTextField.setText("");
				gasPriceTextField.setText("");
				carMileageTextField.setText("");
				tripCostTextField.setText(" ");
			}
		});
		
		//Action performed on click of calculate button
		calculateButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String distanceValue = distanceTextField.getText();
				String gasPriceValue = gasPriceTextField.getText();
				String carMileageValue = carMileageTextField.getText();
				float tripCost;
				
				float distance = Integer.parseInt(distanceValue);
				float gasPrice = Integer.parseInt(gasPriceValue);
				float carMileage = Integer.parseInt(carMileageValue);

				tripCost = (distance * gasPrice)/carMileage;
				
				String tripCostValue = Float.toString(tripCost);
				
				tripCostTextField.setText(tripCostValue);
			}
		});
		//Action performed on the click of close button
		closeButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				calulateCostFrame.dispose();
			}
		});
		
	}

}
