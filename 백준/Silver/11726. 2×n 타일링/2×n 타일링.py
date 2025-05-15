import sys
from math import factorial

# def factorial(n):
#     if n <= 1:
#         return 1
#     else:
#         return n * factorial(n - 1)


n = int(sys.stdin.readline())
cnt = 0
for two_cnt in range((n // 2) + 1):
    one_cnt = n - (2 * two_cnt)
    cnt += factorial(one_cnt + two_cnt) // (factorial(one_cnt) * factorial(two_cnt))

print(cnt % 10007)
