T = int(input())
for test_case in range(1, T + 1):
    sudoku = []
    for _ in range(9):
        sudoku.append(list(map(int, input().split())))
    available = True

    # 가로
    for line in sudoku:
        nums = set(line)
        if len(nums) != 9:
            available = False

    # 세로
    if available:
        for j in range(9):
            col = set([sudoku[i][j] for i in range(9)])
            if len(col) != 9:
                available = False
                break
    # 네모
    if available:
        for i in range(0, 9, 3):
            for j in range(0, 9, 3):
                block = set()
                for dx in range(3):
                    for dy in range(3):
                        block.add(sudoku[i + dx][j + dy])
                if len(block) != 9:
                    available = False
                    break

    print(f"#{test_case} {1 if available else 0}")
