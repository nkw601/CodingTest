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
        if not available:
            break

        nums = set()
        for num in line:
            if not (1 <= num <= 9):
                available = False
                break
            if num in nums:
                available = False
                break
    # 가로 검사
    for row in sudoku:
        if not available:
            break
        nums = set()
        for num in row:
            if num in nums:
                available = False
                break
            nums.add(num)

    # 세로 검사
    if available:
        for j in range(9):
            nums = set()
            for i in range(9):
                num = sudoku[i][j]
                if num in nums:
                    available = False
                    break
                nums.add(num)
            if not available:
                break

    # 블록 검사
    if available:
        for i in range(0, 9, 3):
            for j in range(0, 9, 3):
                nums = set()
                for dx in range(3):
                    for dy in range(3):
                        num = sudoku[i + dx][j + dy]
                        if num in nums:
                            available = False
                            break
                        nums.add(num)
                if not available:
                    break
            if not available:
                break

    if available:
        print(f"#{test_case} 1")
    else:
        print(f"#{test_case} 0")
