def dfs(cur_kcal, confidence, idx):
    global max_confidence
    # 종결 조건
    if idx == N:
        max_confidence = max(max_confidence, confidence)
        return

    c_confidence, c_cal = ingredients[idx]
    if cur_kcal + c_cal <= L:
        dfs(cur_kcal + c_cal, confidence + c_confidence, idx + 1)

    dfs(cur_kcal, confidence, idx + 1)


T = int(input())
for test_case in range(1, T + 1):
    # n, 칼로리 제한
    global N, L
    N, L = map(int, input().split())
    max_confidence = 0
    ingredients = []

    for _ in range(N):
        # 점수, 칼로리
        t, k = map(int, input().split())
        ingredients.append((t, k))

    # dp = [[0] * N for _ in range(N)]
    dfs(0, 0, 0)
    print(f"#{test_case} {max_confidence}")
