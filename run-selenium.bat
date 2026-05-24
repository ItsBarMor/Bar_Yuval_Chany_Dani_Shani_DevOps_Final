@echo off
echo "Running Selenium Tests on Firefox (Headless)..."
selenium-side-runner -c "browserName=firefox moz:firefoxOptions.args=[-headless]" "selenium_tests.side"
