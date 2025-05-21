def dfs(row):
    global sucess

    if row == N:
        sucess += 1
        return

    for col in range(N):
        if (
            col not in cols
            and (row + col) not in pos_diag
            and (row - col) not in neg_diag
        ):
            cols.add(col)
            pos_diag.add(row + col)
            neg_diag.add(row - col)

            dfs(row + 1)

            cols.remove(col)
            pos_diag.remove(row + col)
            neg_diag.remove(row - col)


T = int(input())
for test_case in range(1, T + 1):
    global N
    sucess = 0
    rows = set()
    cols = set()
    pos_diag = set()
    neg_diag = set()
    N = int(input())

    dfs(0)
    print(f"#{test_case} {sucess}")