

package com.other.threads;

import java.util.Calendar;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

public class TimerSchedule extends TimerTask
{

	public static void main(String[] args)
	{
		TimerTask ts =new TimerSchedule();
		Calendar today = Calendar.getInstance();
		today.set(Calendar.HOUR_OF_DAY, 19);
		today.set(Calendar.MINUTE, 10);
		today.set(Calendar.SECOND, 0);
		// every night at 2am you run your task
		Timer timer = new Timer();
		timer.schedule(ts, today.getTime(), TimeUnit.MILLISECONDS.convert(1, TimeUnit.DAYS)); // period:
																											
	}

	@Override
	public void run()
	{
		System.out.println("My time is coming");
	}
}
