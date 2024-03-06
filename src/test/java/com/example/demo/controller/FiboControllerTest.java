package com.example.demo.controller;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.Controller.FIboController;

public class FiboControllerTest {

    @Test
    public void verifyThatSecodsIsPositive() {
        FIboController fiboController = new FIboController();
        String response = fiboController.fibo(0, 1, 1, null);
        Assertions.assertThat(response).isEqualTo("Error: n must be a positive number");
    }

    @Test
    public void verifyThatSeedXAndSeedYAreDifferentThanZero() {
        FIboController fiboController = new FIboController();
        String response = fiboController.fibo(1, 0, 0, null);
        Assertions.assertThat(response).isEqualTo("Error: seedX and seedY must be different than 0");
    }

    @Test
    public void verifyThatSeedXAndSeedYArePositive() {
        FIboController fiboController = new FIboController();
        String response = fiboController.fibo(1, -1, -1, null);
        Assertions.assertThat(response).isEqualTo("Error: seedX and seedY must be a positive number");
    }

    @Test
    public void verifyThatFiboSerieIsCorrect() {
        FIboController fiboController = new FIboController();
        String response = fiboController.fibo(5, 1, 1, null);
        Assertions.assertThat(response.trim()).isEqualTo("1 1 2 3 5 8 13");
    }

    @Test
    public void verifyThatFiboSerieIsCorrectWith9And4() {
        FIboController fiboController = new FIboController();
        String response = fiboController.fibo(8, 4, 9, null);
        Assertions.assertThat(response.trim()).isEqualTo("4 9 13 22 35 57 92 149 241 390");
    }

}
