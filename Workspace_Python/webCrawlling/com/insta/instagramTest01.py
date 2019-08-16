# -*- coding:UTF-8 -*-

# pip install requests

import requests
from bs4 import BeautifulSoup

tag = input('search tag : ')
# print(tag)
url = 'https://www.instagram.com/explore/tags/'+tag
resp = requests.get(url)
# print(resp)
soup = BeautifulSoup(resp.text, 'html.parser')
# print(soup)
print(soup.find('div',{'class','KL4Bh'}))
# 페이지가 response된 후에 다시 내부적으로 request하여 다른 데이터를 가져오기때문에
# 우리가 원하는 데이터를 가져오지 못한다.






