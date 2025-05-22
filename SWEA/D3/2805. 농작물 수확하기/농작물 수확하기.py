T = int(input())
for test_case in range(1, T + 1):
    n = int(input())
    maps = [list(map(int, input())) for _ in range(n)]

    profit = 0
    harvest = 0
    idx = n // 2

    # 늘어남
    for i in range((n // 2) + 1):
        profit += sum(maps[i][idx - harvest : idx + harvest + 1])
        harvest += 1

    harvest -= 1

    # 줄어듦
    for i in range((n // 2) + 1, n):
        harvest -= 1
        profit += sum(maps[i][idx - harvest : idx + harvest + 1])

    print(f"#{test_case} {profit}")
