package com.lti.ui;

import java.sql.Time;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;

public class Main2 {
	public static void main(String[] args) {
	LocalTime time = LocalTime.of(12, 30, 0);
	Time time2 = Time.valueOf(time);
	System.out.println(time2);
	
}
}

