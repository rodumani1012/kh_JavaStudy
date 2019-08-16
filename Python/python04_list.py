# list []

# 생성자를 사용해서
a=list()
print(a)
a.append(1)
print(a)
a[0]='a'
print(a)

# []를 사용해서
b=[1,2,3,4,5]
print(b)
print(b[0]+b[4])
b.reverse()
print(b)
b.sort()
print(b)

# 배열에 배열을 넣을 수 있다.
c=[1,2,3,4,5,b]
print(c)
# 다른타입도 넣을 수 있다.
d=['a','b','c',[1,2,3]]
print(d)

# list 더하기
print(c+d)









