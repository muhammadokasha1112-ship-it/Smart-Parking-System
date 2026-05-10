package Smartparking;
class BikeParking extends Net{
	 double bikefee;
	BikeParking(double basefee,double perhour,double bikefee){
		super(basefee,perhour);
		this.bikefee=bikefee;
	}


	@Override
	public double feeForHours(double hours){
		if(hours<=0){
			return 0.0;
		}
		double h=Math.ceil(hours);
		return  basefee+(bikefee*h);

}	
	@Override
	 public String buildReceipt(String vehicleId, double hours) {
        double fee = feeForHours(hours);
        System.out.println();
        return "BIKE | ID: " + vehicleId + "\n | Hours: " + hours + "\n | Fee: " + fee;
    }


}