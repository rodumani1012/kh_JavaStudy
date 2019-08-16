# 산술연산
a = 13
b = 4

print(a+b)
print(a-b)
print(a*b)
print(a/b)
## 몫
print(a//b)
## 나머지
print(a%b)

# 비교 연산
a, b = 4, 5 # 이렇게 값 넣을 수 있음

print("a == b", a == b)
print("a != b", a != b)
print("a > b", a > b)
print("a >= b", a >= b)
print("a < b", a < b)
print("a <= b", a <= b)
print("a is b =>", a is b)
print("a is not b =>", a is not b)

print("True and False =>", True and False)
print("True or True =>", True or True)
print("not True =>", not True)

# 범위연산

list01 = list(range(100)) # 0 ~ 99 까지
print(list01)

print(list01[5])
print(list01[5 : 11]) # [start : end-1] 까지 가져옴
print(list01[5 : 51 : 2]) #[start : end-1 : step] step 만큼 증가하면서 가져옴

'''
 [:] 연산자는 리스트의 일부 구간을 반환하는데.
     앞부분은 시작인덱스, 뒷부분은 끝 인덱스이다.
     주의해야 할 것은, 끝나는 인덱스는 포함되지 않는다!
 [::] 연산자는 위와 같고, 추가로 스텝을 지정해준다.
'''

str01 = 'Hello, World!'
print(str01)
print(str01[1])
print(str01[7:12])
print(str01[7:12]*2)
# 거꾸로 출력하기
print(str01[-1]) # 힌트
print(str01[-1:])
print(str01[:-1])
print(str01[::-1]) # start, end 지정없이 스텝만 지정

# 멤버연산
list02 = [1,2,3,4,5]
print("list02안에 0이 있니?", 0 in list02)
print("list02안에 3이 없니?", 3 not in list02)
print("list02안에 6이 없니?", 6 not in list02)



















