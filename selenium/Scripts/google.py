from selenium import webdriver
from selenium.webdriver.common.keys import Keys
import time
import urllib.request
driver = webdriver.Chrome()
driver.get("https://www.google.co.kr/imghp?hl=ko&tab=wi&ogbl")

elem = driver.find_element_by_name("q")

elem.send_keys("아이유")
elem.send_keys(Keys.RETURN) # RETURN = ENTER
images = driver.find_elements_by_css_selector(".rg_i.Q4LuWd")
count = 1
for image in images:
    try :
        image.click()
        time.sleep(3)
        imgUrl = driver.find_element_by_css_selector(".n3VNCb").get_attribute("src")
        urllib.request.urlretrieve(imgUrl, str(count) + ".jpg")
        count = count + 1
    except :
        pass

driver.close() #웹브라우저 닫기