# set (집합) {}
# java에서 set은 순서 X, 중복 X

# list는 [], tuple은 (), set은 {}

# 생성자로
a=set(['1','2','3'])
print(a)

# 생성자에 iterable한 객체를 넣으면
b=set('hello')
print(b)

# {}로
c={'a','b','c','d','hello'}
print(c)

d={'hello'}
print(d)

# 추가
d.add('world')
print(d)

# 합집합(union, |) / 교집합(intersection, &)
print(c.union(d))
print(c.intersection(d))
print(c|d)
print(c&d)




















