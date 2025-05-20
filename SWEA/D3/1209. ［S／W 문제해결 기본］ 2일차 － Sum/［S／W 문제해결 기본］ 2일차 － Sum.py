T = 10
for test_case in range(1, T + 1):
    # 100 * 100 배열에서 각 행의 합, 각 열의 합, 각 대각선의 합 중 최댓값

    # 입력
    input()
    nums = []
    for i in range(100):
        nums.append(list(map(int, input().split())))

    max_val = 0
    # 각 행 합
    for row in nums:
        max_val = max(max_val, sum(row))

    # 각 열 합
    for i in range(100):
        col = [nums[j][i] for j in range(100)]
        max_val = max(max_val, sum(col))
    # 대각선 \
    diag = []
    for i in range(100):
        diag.append(nums[i][i])

    max_val = max(max_val, sum(diag))
    # 대각선 /
    diag = []
    for i in range(99, -1, -1):
        diag.append(nums[i][99 - i])
    max_val = max(max_val, sum(diag))

    print(f"#{test_case} {max_val}")