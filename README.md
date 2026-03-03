# Running the code
Clone the repo and build locally. You will need installed:
 - Java 17
 - Maven

Clone the repo by copying the url from GitHub, and using the following commands:

`git clone <repo_url>`  
`cd <project_folder>`

When in the project folder, run this command using Maven:
```bash
./mvnw clean verify
```

If successful, you should be able to run the app using the following command:
```bash
java -jar target/taxCalculator*.jar
```

# Walkthrough
After cloning the repo, as part of the `./mvnw clean verify` the [tests](https://github.com/ajp64/taxCalculator/blob/main/src/test/java/com/hnry/taxCalculator/serviceTests/CalculationServiceTests.java) will run. When running the app, the user is prompted to enter a value using numnerical characters with a single decimal. If a valid value is entered, the tax amount will be returned in the console and the user will be prompted to restart or close the app. 

# Planning 
 - For language and framework, I decided to use Java in Spring. While it could possibly be a bulkier framework than what is required, I feel comfortable using it to easily set up a stand-alone app to handle this task.

- Basic scaffolding:
  - Create a simple app that has a single service layer, which handles the tax calculations. App will take inputs from the command line and return calculations.

  - Start by writing the tests as specified in the task. All tests will be for the service layer.

  - Build service. Create a public method which handles the input and returns a value, and delegates to private methods for calculations based on the value. Use separate methods to handle each income bracket.

  
