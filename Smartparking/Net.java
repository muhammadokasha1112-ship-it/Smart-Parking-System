package Smartparking;
abstract class Net implements Parkable {
	double  basefee;
	double perhour;
	Net(double basefee,double perhour){
		this.perhour=perhour;
		this.basefee=basefee;
	}


	public double feeForHours(double hours){
		if(hours<=0){
			return 0.0;
		}
		double h=Math.ceil(hours);
		return  basefee+(h*perhour);


	}
	
	 public String buildReceipt(String vehicleId, double hours) {
        double fee = feeForHours(hours);
        return "CAR | ID: " + vehicleId + " | Hours: " + hours + " | Fee: " + fee;
    }


}