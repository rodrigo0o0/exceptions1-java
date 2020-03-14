package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import model.entities.Reservation;
import model.exceptions.DomainException;

public class Program {

	public static void main(String[] args)  {

		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Locale.setDefault(Locale.US);
		try {
			System.out.print("Room Number : ");
			int roomNumber = sc.nextInt();
			System.out.print("Check-in date (DD/MM/YYYY) : ");
			Date checkin = sdf.parse(sc.next());
			System.out.print("Check-out date (DD/MM/YYYY) : ");
			Date checkout = sdf.parse(sc.next());
	
			Reservation reservation = new Reservation(roomNumber, checkin, checkout);
			System.out.print("Reservation : " + reservation);
	
			System.out.println();
			System.out.println("Enter data to update the reservation: ");
			System.out.print("Check-in date (DD/MM/YYYY) : ");
			checkin = sdf.parse(sc.next());
			System.out.print("Check-out date (DD/MM/YYYY) : ");
			checkout = sdf.parse(sc.next());
	
			reservation.updateDates(checkin, checkout);
			System.out.print("Reservation : " + reservation);
		}catch(ParseException e) {
			System.out.println("Invalid date format");
		}catch (DomainException e) {
			System.out.println(e.getMessage());
		}catch(RuntimeException e) {
			System.out.println("Unexpected ERROR!");
		}
		sc.close();

	}

}
