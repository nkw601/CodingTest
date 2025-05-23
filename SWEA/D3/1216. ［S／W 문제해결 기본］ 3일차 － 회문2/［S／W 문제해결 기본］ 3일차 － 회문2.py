# 가로, 세로를 모두 보아 가장 긴 회문의 길이
# letters = ["A", "B", "C"]
def is_palindrome_col(sent, col, start, length):
    for i in range(length // 2):
        if sent[start + i][col] != sent[start + length - 1 - i][col]:
            return False
    return True
T = 10
for test_case in range(1, T + 1):
    n = input()
    sent = [list(input()) for _ in range(100)]
    length = 0
    found = False

    # 가로
    for length in range(100, 0, -1):
        for i in range(100):  # 가로 한 줄씩
            for start in range(0, 100 - length + 1):
                substr = sent[i][start : start + length]
                if substr == substr[::-1]:
                    found = True
                    break
            if found:
                break
        if found:
            break

    # 세로
    found = False
    length_col = 0
    for length_col in range(100, 0, -1):
        for i in range(100):  # 세로 한 줄씩
            for start in range(0, 100 - length_col + 1):
                substr = [sent[row][i] for row in range(start, start + length_col)]
                if substr == substr[::-1]:
                    found = True
                    break
            if found:
                break
        if found:
            break

    print(f"#{n} {max(length_col, length)}")
