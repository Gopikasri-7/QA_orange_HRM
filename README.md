# 🧪 OrangeHRM Automation Testing

A ready-to-run **Selenium automation framework** for testing the OrangeHRM demo application. Built with **Maven + Java + TestNG + Page Object Model + ExtentReports + Log4j2** for professional QA automation.

---

## 🚀 Features

### Core Testing Areas
* 🔐 **User Authentication** – Login and session validation
* 🧭 **UI Navigation** – Testing navigation between HR modules
* 📝 **Form Validation** – Input handling and data validation
* 🔄 **Regression Testing** – Automated testing of existing features

### Technical Features
* ⚡ **Selenium WebDriver** – Browser automation for testing
* 📋 **Page Object Model (POM)** – Maintainable and reusable page classes
* 📊 **ExtentReports** – Detailed HTML test reports with screenshots
* 📝 **Log4j2** – Comprehensive logging for debugging
* 🧪 **TestNG** – Test framework with parallel execution support

---

## 🛠 Technologies Used

| Technology | Purpose |
|------------|---------|
| 🧪 Selenium WebDriver | Browser automation and testing |
| ☕ Java 11+ | Core programming language for test scripts |
| 🧪 TestNG | Test framework and test execution |
| 🌐 ChromeDriver | Browser driver for Chrome automation |
| 📦 Maven | Dependency and build management |
| 📊 ExtentReports | Test reporting with screenshots |
| 📝 Log4j2 | Application logging |

---

## 📂 Project Structure

```
orangeHRMAutomation/
├─ config/
│  ├─ config.properties       # Configuration settings
│  └─ log4j2.xml             # Logging configuration
├─ reports/
│  └─ ExtentReport.html      # Generated test reports
├─ src/
│  ├─ main/java/com/orangehrm/pages/
│  │  └─ *.java              # Page Object Model classes
│  └─ test/java/com/orangehrm/tests/
│     └─ *.java              # Test case classes
├─ target/                   # Build output folder
├─ pom.xml                   # Maven configuration
├─ testng.xml                # TestNG suite configuration
└─ README.md                 # Project documentation
```

---

## 🖥 How It Works

**1. Extract and Open**
- Extract the ZIP and open in IntelliJ as an existing Maven project

**2. Setup**
- Ensure JDK 11+ is installed and selected in IntelliJ

**3. Run Tests**
```bash
mvn -q test
```
Or right-click `testng.xml` → Run

**4. View Reports**
- Reports generated in `reports/` folder (ExtentReport.html and screenshots)

---

## 🧠 Key Functionalities Tested

- User login and authentication
- UI navigation between HR modules
- Form validation and data input handling
- Regression testing of existing features

---

## 📊 QA Practices Followed

- Clear and structured test cases
- Page Object Model for maintainability
- Automation for critical workflows
- Regression testing after changes
- Detailed test reports with screenshots
- Clean and readable test scripts

---

## 🎯 Perfect For

| User Type | Use Case |
|-----------|----------|
| 🧪 QA Engineers | Learning Selenium automation framework |
| 👨‍🎓 Students | Understanding software testing lifecycle |
| 💼 Testers | Building automated regression test suites |
| 🎤 Interview Prep | Demonstrating QA automation skills |

---

## 📌 Conclusion

This project demonstrates professional **QA Automation testing** using Selenium with industry-standard practices like Page Object Model, ExtentReports, and structured test frameworks. It reflects the ability to test real-world web applications with maintainable and scalable automation scripts.
