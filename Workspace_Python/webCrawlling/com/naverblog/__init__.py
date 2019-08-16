# -*- coding:UTF-8 -*-

from selenium import webdriver
from bs4 import BeautifulSoup

keyword = input('검색어 입력 : ')
url = 'https://section.blog.naver.com/Search/Post.nhn?keyword='+keyword

options = webdriver.ChromeOptions()
options.add_argument('headless')
options.add_argument('disable-gpu')

driver = webdriver.Chrome('c:/Work/chromedriver.exe', options=options)
driver.implicitly_wait(0)
driver.get(url)

soup = BeautifulSoup(driver.page_source, 'html.parser')

desc = soup.find_all('div', {'class','desc'})

list = list()
for descTitle in desc:
    title = descTitle.find('span')
    link = descTitle.find('a')
    list.append(title.text)
    print(title.text)
    print(link.get('ng-href'))
print(list)






