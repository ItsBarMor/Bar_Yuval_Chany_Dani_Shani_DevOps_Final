# DevOps Final Project - HIT 2026 Semester B

## Team Members
* Daniel
* Yuval
* Bar
* Chany
* Shani

## Project Overview
This project demonstrates a complete, automated CI/CD pipeline taking a Java web application from source control to production deployment, including automated testing and monitoring.

### Architecture and Pipeline Steps
1. **Source Control (Git/GitHub):** The source code (a JSP web application) is stored in this repository.
2. **CI/CD Orchestration (Jenkins):** Jenkins serves as the orchestrator for the entire pipeline.
3. **Deployment:** A Jenkins pipeline pulls the latest code from the main branch and deploys it directly to a local Apache Tomcat 9 server.
4. **Internet Exposure (Ngrok):** The local Tomcat server is exposed to the public internet via an Ngrok tunnel to fulfill the bonus requirement.
5. **Availability Monitoring:** A custom PowerShell script (SiteMonitorLite.ps1) is triggered by a Jenkins cron job every 5 minutes to ping the public URL and assert a 200 OK status.
6. **Automated UI Testing (Selenium):** A Selenium IDE script (selenium_tests.side) is executed via Jenkins using Chrome Headless to perform 5 specific validations:
   * Verify: Link existence
   * Assert: Text presence
   * Positive Test: Form submission
   * Click: Button functionality
   * Negative Test: Empty submission rejection
7. **Performance Testing (Gatling):** Three distinct Gatling simulations (Java) are executed to test the server limits against the public ngrok endpoint:
   * Max Limit Test: Ramping users to find the point of failure.
   * Load Test: Sustained 5-minute traffic at a constant rate.
   * Stress Test: 5 minutes of heavy traffic spikes.

## Repository Contents
* /daniel-yuval-bar-chany-shani/ - Contains the index.jsp application source code.
* deploy.bat - Jenkins deployment script.
* run-selenium.bat - Jenkins Selenium execution script.
* SiteMonitorLite.ps1 - 5-minute availability monitor script.
* selenium_tests.side - The 5 UI validations test suite.
