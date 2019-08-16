# -*- coding:UTF-8 -*-

import numpy as np
import matplotlib.pyplot as plt

# cmd에서 아래 두개 입력해서 설치
# pip install numpy (수치, 숫자로 연산할 때 사용하는 라이브러리)
# pip install matplotlib (그래프 나타내는 라이브러리)

if __name__ == '__main__':
    x = np.arange(0, 10)
    y = x
    
    plt.plot(x, y)
    plt.show()