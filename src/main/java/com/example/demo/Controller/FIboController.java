package com.example.demo.Controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;

import com.example.demo.services.EmailService;

@Controller
public class FIboController {

    @Autowired
    private EmailService emailService;

    /**
     * This method generates a series of fibonacci and sends an email with the
     * series
     * 
     * @param n     number of elements in the series
     * @param seedX first element of the series
     * @param seedY second element of the series
     * @param date  date when the series was generated
     * @return the series of fibonacci
     * @throws Exception if n is less than 0, seedX and seedY are 0 or less than 0
     */
    public String fibo(int n, int seedX, int seedY, Date date) {

        String validations = validationValues(n, seedX, seedY);

        if (validations != "OK") {
            return validations;
        }

        List<Integer> series = new ArrayList<>();
        series.add(seedX);
        series.add(seedY);

        while (true) {
            int next = series.get(series.size() - 1) + series.get(series.size() - 2);
            if (series.size() - 1 > n) {
                break;
            }
            series.add(next);
        }

        String result = "";

        for (int i = 0; i < series.size(); i++) {
            result += series.get(i) + " ";
        }

        try {

            emailService.sendEmail("jdlm1999@gmail.com, jdlm201299@gmail.com", "Prueba Tecnica - Juan David Lozano Moreno",
                    "La serie de Fibonacci es: " + result + "\n" + " y fue generada en la fecha: "
                            + new SimpleDateFormat(" HH:mm:ss").format(date));
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }

        return result;
    }

    /**
     * This method validates the values of n, seedX and seedY
     * 
     * @param n     number of elements in the series
     * @param seedX first element of the series
     * @param seedY second element of the series
     * @return
     */
    public String validationValues(int n, int seedX, int seedY) {
        if (n <= 0) {
            return "Error: n must be a positive number";
        }

        if (seedX == 0 && seedY == 0) {
            return "Error: seedX and seedY must be different than 0";
        }

        if (seedX < 0 || seedY < 0) {
            return "Error: seedX and seedY must be a positive number";
        }

        return "OK";
    }

}
