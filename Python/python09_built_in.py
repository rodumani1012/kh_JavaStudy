# int() : 정수
print(int(True))
print(int(False))
print(int('10'))
print(int(20.5))

# 2,8,16 진수
print('2진수 10101 : ', int('10101', 2))
print('8진수 77 : ', int('77',8))
print('16진수 ff : ', int('ff',16))

# float() : 실수
print(float('3'))
print(float(3))

# complex() : 복소수
print(7j)
print(type(7j))
print(1+7.65j)
a = 1+7.65j

# 실수 / 허수
print('---------------------------')
print(a)
print(a.real) # 실수 부분
print(a.imag) # 허수 부분

# str() : 문자열로 바꿔줌
print(str(3))
print(str(3)+'?')

# repr() : '문자열' 객체
print(repr('Hello, World!'))
print(str('Hello, World!'))
