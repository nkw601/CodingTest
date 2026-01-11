import sys
import math

input = sys.stdin.readline

t = int(input().strip())
for _ in range(t):
    a, b = map(int, input().split())
    g = math.gcd(a, b)
    lcm = a // g * b
    print(lcm)