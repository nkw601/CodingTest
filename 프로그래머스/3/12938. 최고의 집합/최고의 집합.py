def solution(n, s):
    # 집합의 합: n
    # 1 ~ n / 2까지, 합이 s
    
    # 1. n > s면 최고의 집합 존재 X
    if  n > s:
        return [-1]
    
    # 2. 곱셈이 커짐 -> 3,4 등...
    # s // n
    fir = s // n
    num = s % n
    
    answer = [fir] * n
    
    for i in range(num):
        answer[-1 - i] += 1
    
    return answer
