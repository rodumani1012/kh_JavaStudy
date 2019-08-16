# -*- coding:UTF-8 -*-

# 1. for문을 사용하여 구구단을 출력하는 gugu() 함수를 만들자.
def gugu():
    for i in range(2,10):
        print('< ',i, '단 >')
        for j in range(1,10):
            print(i,'×',j,' = ', i*j)

# 2. while문을 사용하여 구구단 중, 입력된 단을 출력하는 gugudan(x) 함수를 만들자
def gugudan(x):
    i = 1
    print('< ', x, '단 >')
    while i < 10:
        print(x,'×',i,' = ', x*i)
        i += 1    
            
def gugudaninput():
    x = int(input('숫자입력 ㄱㄱ : '))
    i = 1
    print('< ', x, '단 >')
    while i < 10:
        print(x,'×',i,' = ', x*i)
        i += 1

# 3. gugu()랑 gugudan(x) 호출하자.
if __name__ == '__main__':
    gugu()
    gugudan(3)
    gugudaninput()
    
