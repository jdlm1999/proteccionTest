package com.example.demo.Api;

import java.util.Calendar;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Controller.FIboController;

@RestController
@RequestMapping("/api")
public class FIboApi {

    @Autowired
    private FIboController fiboController;

    /**
     * This method returns the fibonacci number of the current time
     * 
     * @return Fibonacci number of the current time and sent to the email
     */
    @GetMapping("/fibo")
    public String login() {
        try {
            Date date = new Date();
            Calendar calendar = Calendar.getInstance();

            int minutes = calendar.get(Calendar.MINUTE);
            int seconds = calendar.get(Calendar.SECOND);

            String minutesInteger = Integer.toString(minutes);

            int firstMinuteNumber = Character.getNumericValue(minutesInteger.charAt(0));
            int secondMinuteNumber = Character.getNumericValue(minutesInteger.charAt(1));

            return fiboController.fibo(seconds, firstMinuteNumber, secondMinuteNumber, date);
        } catch (Exception e) {
            return "Error: " + e;
        }

    }
}
