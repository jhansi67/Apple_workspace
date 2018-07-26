package training_project;
import java.time.*;
import java.time.temporal.ChronoUnit;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Set;

public class datetimetest {
	public static void main(String args[]){
datetimetest local = new  datetimetest();
local.test1();
local.zone();
local.prd();

	}
public void test1(){
	//displaying local date and time
	LocalDateTime curr = LocalDateTime.now();
	System.out.println(curr);
	//displaying local date using the current date value
	LocalDate date = curr.toLocalDate();
	//250 day of the year 2013
    System.out.println(date);
    LocalDateTime a= curr.withDayOfYear(250).withYear(2013);
    System.out.println(a);
   
}
public void zone(){
	//displaying different time zones 
	LocalDateTime cu = LocalDateTime.now();
	ZoneId c = ZoneId.systemDefault();
	System.out.println(c);
	
	 ZoneId d= ZoneId.of("America/Los_Angeles");
     System.out.println(d);
     ZonedDateTime Ar= cu.atZone(d);
     System.out.println("Europe:"+ Ar);
     
     ZoneId f= ZoneId.of("Europe/Paris");
     System.out.println(f);
     ZonedDateTime Eu= cu.atZone(f);
     System.out.println("Europe:"+ Eu);
    
     ZoneId e= ZoneId.of("Asia/Karachi");
     System.out.println(e);
     ZonedDateTime Kr= cu.atZone(e);
     System.out.println("karachi:"+ Kr);
     
     ZoneId h= ZoneId.of("Asia/Kolkata");
     System.out.println(h);
     ZonedDateTime Ko= cu.atZone(h);
     System.out.println("karachi:"+ Ko);
     
     
}
public void prd(){
	//using period and duration to figure out the difference between the two dates
	LocalDate ab = LocalDate.now();
	LocalDate abc = ab.plus(6,ChronoUnit.MONTHS);
	Period bet = Period.between(ab, abc);
	System.out.println(bet);
	LocalTime tt = LocalTime.now();
	LocalTime tt2= tt.plus(2,ChronoUnit.HOURS);
	Duration bet1 = Duration.between(tt, tt2);
	System.out.println(bet1);
	
}
public void chr(){
	//adding and subtracting the date to the current date using ChronoUnit
	LocalDate e= LocalDate.now();
	
	LocalDate f = e.minus(3,ChronoUnit.MONTHS);
	 System.out.println(f);
		
		LocalDate g = e.plus(3,ChronoUnit.YEARS);
		 System.out.println(g);
}
}