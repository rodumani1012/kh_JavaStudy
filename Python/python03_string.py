# 문자
# ''(single quotation) ""(double quotation) 차이 없다.

# \ : escape sequence 라고 부름.
a='a\nb\'\s'
print(a)


b="a\nb's"
print(b)

# ''' 내용 '''
# ''' 3개는 안에 있는 엔터나 공백을 다 포함시켜줌.
c='''    a
b
    c    d
e'''
print(c)

# """
d="""a
    b
    c    d
"""
print(d)

# 섞어서
ex="""Weather you're new to
programming or an experienced
developer, it's easy to learn and use
Phthon."""
print(ex)

ex2='''Python Insider by the Python
Core Developers is licensed
under a 'Creative' "Commons" Attribution-NonCommercial-ShareAlike
3.0 Unported License.
Based on a work at blog.python.org.'''
print(ex2)

# 참고
'''
이 안에 주석을 쓰는 사람도 있다.
출력만 안하면 되기 때문이다.
'''

# 문자열 더하기, 문자열 곱하기
s1 = 'Hello, '
s2 = 'World'
s3 = '!'
print(s1+s2+s3)
print(s1+s2+(s3*10))

















