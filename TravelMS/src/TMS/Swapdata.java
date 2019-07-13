package TMS;
public class Swapdata {
	public String name,phone,journey,date,seat; 
	public Swapdata(String a,String b,String c,String d,String e)
	{
		name=a;
		phone=b;
		journey=c;
		date=d;
		seat=e;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getJourney() {
		return journey;
	}
	public void setJourney(String journey)
	{
		this.journey=journey;
	}
	public void setDate(String Date) {
		this.date = date;
	}
	
	public String getDate()
	{
		return date;
	}
	public String getSeat() {
		return seat;
	}
	public void setSeat(String seat) {
		this.seat = seat;
	}
	
}
