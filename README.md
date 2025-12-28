# Patient Registration Automation Framework

A Selenium TestNG automation framework built from scratch to automate a Patient Registration web application using Excel data-driven testing and reporting.

---

## 🛠 Tech Stack
- Java  
- Selenium WebDriver  
- TestNG  
- Maven  
- Apache POI (Excel)  
- Extent Reports  

---

## 📁 Framework Design
- Page Object Model (POM)
- Base Test for WebDriver setup
- Utilities layer (Excel, Reporting)
- Data-Driven Testing using Excel
- Explicit Waits for stable UI synchronization

---

## 🧪 Test Scenario
- Automate Patient Registration form
- Enter Name, Age, and Mobile Number
- Validate successful registration message
- Execute multiple test cases using Excel DataProvider

---

## 🚀 Key Features
- Excel-based DataProvider
- Handles Excel numeric formatting issues
- Skips invalid or empty Excel rows
- Screenshot capture on test execution
- Extent HTML Report generation
- Stable execution using WebDriverWait

---

## ▶️ How to Run the Project
1. Clone the repository
   ```bash
   git clone https://github.com/<your-username>/patient-registration-automation.git
Import project into Eclipse as Maven Project

Ensure Java and Maven are installed

Run the test:

PatientRegistrationTest.java → Run As → TestNG Test

📊 Test Report

HTML report generated using Extent Reports

Screenshots attached for each test execution

Report path:

/reports/ExtentReport.html

👤 Author

Deepak Kumar Sahukar

📌 Note

This project demonstrates a real-world Selenium automation framework with proper handling of data-driven challenges and UI synchronization issues.


---

## ✅ HOW TO ADD THIS TO GITHUB

1. Create file in project root:
2. Paste the above content
3. Save
4. Commit & push:

```cmd
git add README.md
git commit -m "Added clean professional README"
git push
