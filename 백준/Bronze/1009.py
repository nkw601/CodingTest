t = int(input())

for _ in range(t):
    a, b = map(int, input().split())

    a %= 10
    if a == 0:
        print(10)
        continue

    cycle = [a]
    while True:
        nxt = (cycle[-1] * a) % 10
        if nxt == cycle[0]:
            break
        cycle.append(nxt)

    print(cycle[(b - 1) % len(cycle)])
