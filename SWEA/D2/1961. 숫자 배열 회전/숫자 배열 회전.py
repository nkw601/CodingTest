def rotate(arr, n):
    arr_rot = [[-1] * n for _ in range(n)]
    for i in range(n):
        for j in range(n):
            arr_rot[i][j] = arr[n - (j + 1)][i]

    return arr_rot


# 00 01 02
# 10 11 12
# 20 21 22

# 90도
# 20 10 00
# 21 11 01
# 22 12 02

# 180도
# 22 21 20
# 12 11 10
# 02 01 00

# 270도
# 02 12 22
# 01 11 21
# 00 10 20

T = int(input())

for test_case in range(1, T + 1):
    N = int(input())
    numbers = []
    for _ in range(N):
        numbers.append(list(map(int, input().split())))

    numbers_90 = rotate(numbers, N)
    numbers_180 = rotate(numbers_90, N)
    numbers_270 = rotate(numbers_180, N)
    print(f"#{test_case}")

    for i in range(N):
        for j in range(N):
            print(numbers_90[i][j], end="")
        print(" ", end="")
        for j in range(N):
            print(numbers_180[i][j], end="")
        print(" ", end="")
        for j in range(N):
            print(numbers_270[i][j], end="")
        print()


# 741 987 369
# 852 654 258
# 963 321 147
