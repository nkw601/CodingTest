# import sys
# data = sys.stdin.read().splitlines()
# T = int(data[0])
# sudoku = []
# for line in data[1:]:
#     sudoku.append(list(map(int, line.split())))


T = int(input())
for test_case in range(1, T + 1):
    sudoku = []
    for _ in range(9):
        sudoku.append(list(map(int, input().split())))
    available = True

    # 가로
    for line in sudoku:
        nums = set()
        for num in line:
            if not (1 <= num <= 9):
                available = False
                break
            if num in nums:
                available = False
                break
            else:
                nums.add(num)
    # 세로
    columns = []
    for j in range(9):
        col = [sudoku[i][j] for i in range(9)]
        columns.append(col)

    for col in columns:
        if not available:
            break

        nums = set()
        for num in col:
            if not (1 <= num <= 9):
                available = False
                break
            if num in nums:
                available = False
                break
            else:
                nums.add(num)
    # 네모

    rectangles = []
    for i in range(0, 9, 3):  # 시작 행: 0, 3, 6
        for j in range(0, 9, 3):  # 시작 열: 0, 3, 6
            block = []
            for dx in range(3):
                for dy in range(3):
                    block.append(sudoku[i + dx][j + dy])
                rectangles.append(block)

    for r in rectangles:
        if not available:
            break

        nums = set()
        for num in r:
            if not (1 <= num <= 9):
                available = False
                break
            if num in nums:
                available = False
                break
            else:
                nums.add(num)

    if available:
        print(f"#{test_case} 1")
    else:
        print(f"#{test_case} 0")
