@echo off
echo "Running Selenium Tests on Chrome (Headless CI Mode)..."
selenium-side-runner -c "browserName=chrome goog:chromeOptions.args=[--headless,--no-sandbox,--disable-dev-shm-usage]" "selenium_tests.side"
