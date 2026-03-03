package com.hnry.taxCalculator;

import com.hnry.taxCalculator.service.CalculationService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.Scanner;

@SpringBootApplication
public class TaxCalculatorApplication {

	public static void main(String[] args) {
		SpringApplication.run(TaxCalculatorApplication.class, args);
	}

	@Component
	public class App implements CommandLineRunner
	{
		private final CalculationService calculationService;

		public App(CalculationService calculationService){
			this.calculationService = calculationService;
		}

		public void run(String... args) throws IOException {
			Scanner userInput = new Scanner(System.in);
			boolean running = true;

			while (running) {
				System.out.println("Enter 2025 year end income (only characters 0-9 with a single decimal)");

				String untaxedIncome = userInput.nextLine();
				BigDecimal incomeTax = calculationService.calculateIncomeTax(untaxedIncome);

				if (incomeTax != null)
				{
					System.out.println("Total payable income tax for year ending 2025 is " + incomeTax);
				} else {
					System.out.println("Restart and enter a valid input.");
				}

				System.out.println("Enter y to restart: ");
				String continueEntry = userInput.nextLine();

				if (continueEntry.equalsIgnoreCase("y")) {
					System.out.println("Restarting");
				} else {
					running = false;
				}
			}
			System.exit(0);
		}
	}

}
