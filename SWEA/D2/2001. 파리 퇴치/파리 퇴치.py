# n, m: 맵 크기, 파리채 크기

# data = sys.stdin.read().splitlines()
# T = int(data[0])
# n, m = map(int, data[1].split())
# maps = [list(map(int, line.split())) for line in data[1:]]
def get_prefix(n, m):
    prefix = [[0] * (n + 1) for _ in range(n + 1)]
    for i in range(1, n + 1):
        for j in range(1, n + 1):
            prefix[i][j] = (
                maps[i - 1][j - 1]
                + prefix[i - 1][j]
                + prefix[i][j - 1]
                - prefix[i - 1][j - 1]
            )
    return prefix


T = int(input())
for test_case in range(1, T + 1):
    n, m = map(int, input().split())
    maps = [list(map(int, input().split())) for _ in range(n)]
    prefix = get_prefix(n, m)

    max_flies = 0
    for i in range(1, n - m + 2):
        for j in range(1, n - m + 2):
            x1, y1 = i, j
            x2, y2 = i + m - 1, j + m - 1

            s = (
                prefix[x2][y2]
                - prefix[x1 - 1][y2]
                - prefix[x2][y1 - 1]
                + prefix[x1 - 1][y1 - 1]
            )
            
            max_flies = max(max_flies, s)
    print(f"#{test_case} {max_flies}")
