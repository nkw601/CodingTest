T = int(input())
for test_case in range(1, T + 1):
    b, w, x, y, z = map(int, input().split())
    # 까만 박스 흰 박스 까만 공 흰 공
    dp = [[[float("-inf")] * (b + 1) for _ in range(w + 1)] for _ in range(b + 1)]
    dp[0][0][0] = 0

    for bbox in range(b + 1):
        for wbox in range(w + 1):
            for bball in range(b + 1):
                cur = dp[bbox][wbox][bball]
                if cur == float("-inf"):
                    continue

                total_boxes = bbox + wbox
                wball = total_boxes - bball
                if wball > w or bball > b:
                    continue

                # 까만 박스 + 까만 공
                if bbox < b and bball < b:
                    dp[bbox + 1][wbox][bball + 1] = max(
                        dp[bbox + 1][wbox][bball + 1], cur + x
                    )
                # 까만 박스 + 흰 공
                if bbox < b and wball < w:
                    dp[bbox + 1][wbox][bball] = max(dp[bbox + 1][wbox][bball], cur + z)
                # 흰 박스 + 까만 공
                if wbox < w and bball < b:
                    dp[bbox][wbox + 1][bball + 1] = max(
                        dp[bbox][wbox + 1][bball + 1], cur + z
                    )
                # 흰 박스 + 흰 공
                if wbox < w and wball < w:
                    dp[bbox][wbox + 1][bball] = max(dp[bbox][wbox + 1][bball], cur + y)

    print(dp[b][w][b])
