package Smartparking;
class CarParking extends Net{
	 double carfee;
		CarParking(double basefee,double perhour,double carfee){
		super(basefee,perhour);
		this.carfee=carfee;
	}

	@Override
	public double feeForHours(double hours){
		if(hours<=0){
			return 0.0;
		}
		double h=Math.ceil(hours);
		return  basefee+(carfee*h);

}
	@Override
	 public String buildReceipt(String vehicleId, double hours) {
        double fee = feeForHours(hours);
        return "CAR | ID: " + vehicleId + "\n | Hours: " + hours + "\n | Fee: " + fee;
    }

}