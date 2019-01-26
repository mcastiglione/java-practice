package com.intivefdv.backend;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


import com.myclasses.Print;

public class RentBike_BAD extends Print {

	public Double fee;
	
	public boolean checkInfo(HashMap<String, Integer> details) {
		
		Integer option = details.get("option");
		if(option == null) {
			return false;
		}
		
		Integer QuantBikes = null;
		Integer QB4 = 0;
		Integer QuantTime = null;
		Integer CorrectCases = 0;
		
		switch(option) {
		case 1:
			QuantBikes = details.get("QuantBikesOption1");
			QuantTime = details.get("QuantTimeOption1");
		case 2:
			QuantBikes = details.get("QuantBikesOption2");
			QuantTime = details.get("QuantTimeOption2");
		case 3:
			QuantBikes = details.get("QuantBikesOption3");
			QuantTime = details.get("QuantTimeOption3");
		case 4:
			for (int x = 1; x < 4; x++) {
				QuantBikes = details.get("QuantBikesOption" + x);
				QB4 = QB4 + QuantBikes;
				QuantTime = details.get("QuantTimeOption" + x);
				if (QuantBikes != null && QuantTime != null) {
					CorrectCases++;
				}
			}
			
		}
		
		if ((option == 1 || option == 2 || option == 3) && (QuantBikes == 0 || QuantTime == 0)) {
			print("rental details not specified");
			return false;
		}
		
		if (option == 4 && CorrectCases == 0) {
			print("need to specify at least 1 rental option");
			return false;
		}
		
		if (option == 4 && (QB4 > 5) || QB4 < 3){
			print("Invalid quantity of Rentals, must be from 3 up to 5 ");
			return false;
		}
		
		return true;
	}
	
	public Double calculateFee(HashMap<String, Integer> details) {
		Integer option = details.get("option");
		Integer price = null;
		Double fee = 0.0;
		Integer qb = null;
		Integer qt = null;
		
		
		if (option == 1 || option == 2 || option == 3) {
			price = details.get("PriceOption" +  option);
			qb = details.get("QuantBikesOption" + option); 
			qt = details.get("QuantTimeOption" + option);
			
			fee = price.doubleValue()*qb.doubleValue()*qt.doubleValue();
		} else {
			for (int x = 1; x < 4; x++) {
				price = details.get("PriceOption" +  x);
				qb = details.get("QuantBikesOption" + x); 
				qt = details.get("QuantTimeOption" + x);
				fee = fee + (price.doubleValue()*qb.doubleValue()*qt.doubleValue());
			}
			Double Discount = details.get("DiscountOption4").doubleValue();
			fee = fee * (1-(Discount/100));
		}
		
		return fee;
	}

	public RentBike_BAD(HashMap<String, Integer> details) {
		boolean isValid = this.checkInfo(details);
		if (isValid == true) {
			Double fee = this.calculateFee(details);
			this.fee = fee;
			print(this.fee);
		}
	}

	public static void main(String args[]) {
		HashMap<String, Integer> details = new HashMap<String, Integer>();
		details.put("option", 4);
		details.put("QuantBikesOption1", 1);
		details.put("QuantTimeOption1", 3);
		details.put("QuantBikesOption2", 2);
		details.put("QuantTimeOption2", 1);
		details.put("QuantBikesOption3", 2);
		details.put("QuantTimeOption3", 3);
		details.put("PriceOption1", 5);
		details.put("PriceOption2", 20);
		details.put("PriceOption3", 60);
		details.put("DiscountOption4", 30);
		RentBike_BAD rb = new RentBike_BAD(details);
	}
}