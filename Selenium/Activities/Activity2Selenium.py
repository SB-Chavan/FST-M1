from selenium import webdriver
from selenium.webdriver.common.by import By

with webdriver.Firefox() as driver:
# Navigate to the URL
    driver.get("https://training-support.net/webelements/login-form")

# Print --> Page Title
    print("Page title is: ", driver.title)

# Get username field
    username = driver.find_element(By.ID, "username")
# Get password field
    password = driver.find_element(By.ID, "password")


# Enter username as admin
    username.send_keys("admin")

# Enter password as password
    password.send_keys("password")

# Get Login button and click 
    login = driver.find_element(By.XPATH, "//button[text()='Submit']")
    login.click()

# Print the login message
    message = driver.find_element(By.CSS_SELECTOR, "h1.text-center")
    print("Login message: ", message.text)