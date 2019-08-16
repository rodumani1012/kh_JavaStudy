# dictionary
# 순서 : X 중복 : key(X), value(O)

dict01 = dict()
dict01[1] = 1
dict01[2] = 2
print(dict01)

dict02 = {}
dict02['one'] = 'This is One!'
dict02['two'] = 'This is One!'
dict02[3] = 3
dict02[3] = 'This is Three!'
print(dict02)

# key를 가지고 value를 출력해보자
print(dict01.get(1))
print(dict02.get('one'))

# key 따로 value 따로 가져오기.
print(dict01.keys())
print(dict02.values())

print(list(dict02.values())[1])



















