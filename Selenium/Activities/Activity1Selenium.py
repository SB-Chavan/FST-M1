from selenium import webdriver
from selenium.webdriver.common.by import By

with webdriver.Firefox() as driver:
# Navigate to the URL
    driver.get("https://training-support.net/")

# Title of the Page
    print("Title of the Page : ", driver.title)

# Click on About Us Button
    driver.find_element(By.LINK_TEXT, "About Us").click()

# Print ->Title of the new page
    print("New page title is: ", driver.title)