package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import model.exceptions.DomainException;

public class Reservation {
	private Integer roomNumber;
	private Date checkin;
	private Date checkout;
	private final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	public Reservation(Integer roomNumber, Date checkin, Date checkout) throws DomainException {
		Date now = new Date();
		if(checkin.after(checkout)) {
			throw new DomainException("The date of checkin must be before checkout");
		}
		if(checkin.before(now) || checkout.before(now)) {
			throw new DomainException("The dates must be after now!");
		}
		this.roomNumber = roomNumber;
		this.checkin = checkin;
		this.checkout = checkout;
	}


	public Reservation() {
	}

	public Integer getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(Integer roomNumber) {
		this.roomNumber = roomNumber;
	}

	public Date getCheckin() {
		return checkin;
	}

	public Date getCheckout() {
		return checkout;
	}

	public long duration() {
		long diff = checkout.getTime() - checkin.getTime();
		return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);

	}
	public void updateDates(Date checkin, Date checkout) throws DomainException {
		Date now = new Date();
		if(checkout.before(now) || checkin.before(now)){
			throw new DomainException("The dates for update must be future dates!");
		}
		if(checkin.after(checkout)){
			throw new DomainException("The date of check-in must be before the checkout!!");
		}
		this.checkin = checkin;
		this.checkout = checkout;
	}
	
	@Override
	public String toString() {
		return "Room " + roomNumber
				+",  check-in : " + sdf.format(checkin) 
				+", check-out : " + sdf.format(checkout)
				+", "+ duration() +" Nights";
	}
}
