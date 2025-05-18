def make_snail(n):
    # 오른쪽 아래 왼쪽 위
    direction = [(0, 1), (1, 0), (0, -1), (-1, 0)]

    visited = [[False] * n for _ in range(n)]
    cnt = 1
    idx = 0
    cx, cy = 0, 0

    while cnt <= n * n:
        visited[cx][cy] = cnt
        cnt += 1

        dx, dy = direction[idx]

        nx = cx + dx
        ny = cy + dy

        if 0 <= nx < n and 0 <= ny < n and not visited[nx][ny]:
            cx, cy = nx, ny

        else:
            idx = (idx + 1) % 4
            dx, dy = direction[idx]
            cx += dx
            cy += dy
    return visited


T = int(input())
for test_case in range(1, T + 1):
    n = int(input())
    maps = make_snail(n)
    print(f"#{test_case}")

    for r in maps:
        print(" ".join(map(str, r)))
