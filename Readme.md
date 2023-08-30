**Use Case #10 (Danylo Yurchyk)**

**Application Description**

This application serves as a utility tool designed to validate strings based on specific criteria. It ensures that a given input meets the requirements of containing uppercase letters, lowercase letters, digits, predefined special characters, and adheres to a specified maximum length. Moreover, the utility ensures that the input does not contain any whitespace characters.

**Regex Implementation Description**

The core of the application lies in the implementation of a regular expression (regex). This regex is dynamically generated based on a provided maximum length and checks for the presence of specific character types (uppercase, lowercase, digit, special character) while simultaneously ensuring the absence of whitespace characters. By utilizing the power of regex, the application achieves efficient and reliable validation, making it suitable for various use cases, from form validation to security checks.

**How to Run the Application Locally**

Prerequisites: Ensure you have Java 11 or higher installed. You can check by running:

css
`java --version`

Clone the Repository:

bash
`git clone [repository-url]`

Navigate to the Application Directory:

bash
`java --version`


Compile the Application:

css
`javac -d bin src/*.java`

Run the Application:

bash
`java -cp bin ApplicationMainClass`

Replace ApplicationMainClass with the main class name if it's different.

Run Tests (if JUnit is set up):

bash
`java -cp path-to-junit.jar:bin org.junit.runner.JUnitCore RegexValidatorTest`