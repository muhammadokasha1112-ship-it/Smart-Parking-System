package Smartparking;
import java.util.*;
import java.sql.*;

interface Parkable{
	double feeForHours(double hours);
	String buildReceipt(String vehicleId, double hours);

}