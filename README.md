# Automation Exercise with SHAFT

This repository contains a project showcasing automation testing using SHAFT, a powerful framework designed to simplify and enhance the automation testing experience.

## Table of Contents
- [Project Description](#project-description)
- [Technologies Used](#technologies-used)
- [Setup Instructions](#setup-instructions)
- [Running the Tests](#running-the-tests)
- [Project Structure](#project-structure)
- [Contributing](#contributing)
- [License](#license)

## Project Description
This project demonstrates how to create effective and efficient automated tests using the SHAFT_ENGINE framework. The purpose of this project is to:

- Provide a hands-on example of automation testing using SHAFT.
- Highlight best practices for designing and executing tests.
- Serve as a reference for individuals looking to implement automation in their projects.
- Valid login test
- Add products to cart
- E2E purchasing scenario

## Technologies Used
- **Programming Language**: Java
- **Framework**: SHAFT
- **Build Tool**: Maven
- **Testing Tool**: Selenium WebDriver (integrated with SHAFT)
- **Version Control**: Git

## Setup Instructions

1. **Clone the Repository:**
   ```bash
   git clone https://github.com/MahmoudAdel-cpu/Automation_Exercise_SHAFT.git
   cd Automation_Exercise_SHAFT
   ```

2. **Install Dependencies:**
   Ensure that Maven is installed and run the following command to download dependencies:
   ```bash
   mvn clean install
   ```

3. **Configuration:**
   Update any configuration files (e.g., `properties` or `config` files) as needed for your environment.

## Running the Tests

1. **Execute Tests Using Maven:**
   Run the following command to execute the tests:
   ```bash
   mvn test
   ```

2. **Generate Reports:**
   SHAFT automatically generates detailed reports. Locate the report in the `target` directory after running the tests.

## Project Structure
```
Automation_Exercise_SHAFT
├── src
│   ├── main
│   │   └── java
│   └── test
│       └── java
├── pom.xml
└── README.md
```
- **src/main/java**: Contains application source code (if applicable).
- **src/test/java**: Contains test scripts.
- **pom.xml**: Maven configuration file for managing dependencies and build process.

## Contributing
Contributions are welcome! Please follow these steps:

1. Fork the repository.
2. Create a new branch for your feature/bug fix.
3. Commit your changes and push to your branch.
4. Create a pull request detailing the changes made.

## License
This project is licensed under the MIT License. See the `LICENSE` file for details.

---

For any questions or support, feel free to reach out or open an issue in this repository.
