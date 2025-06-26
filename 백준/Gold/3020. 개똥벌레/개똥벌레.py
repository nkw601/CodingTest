import sys

data = sys.stdin.read().splitlines()

n, h = map(int, data[0].split())


stalagmite = [0] * (h + 2)  # 석순
stalactite = [0] * (h + 2)  # 종유석

for i in range(1, n + 1):
    length = int(data[i])
    # length 이상에서 날면 충돌
    # 1. 석순
    if i % 2 == 1:
        stalagmite[length] += 1
    # 2. 종유석
    else:
        stalactite[h - length + 1] += 1

for i in range(h - 1, 0, -1):
    stalagmite[i] += stalagmite[i + 1]

for i in range(1, h + 1):
    stalactite[i] += stalactite[i - 1]


min_cnt = n + 1
cnt = 0

for i in range(1, h + 1):
    crash = stalagmite[i] + stalactite[i]
    if crash < min_cnt:
        min_cnt = crash
        cnt = 1
    elif crash == min_cnt:
        cnt += 1

print(min_cnt, cnt)
