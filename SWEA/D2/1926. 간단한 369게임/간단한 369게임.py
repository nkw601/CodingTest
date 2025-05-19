def find369(sent):
    cnt = 0
    for s in sent:
        if s in ["3", "6", "9"]:
            cnt += 1
    return cnt


n = int(input())
for i in range(1, n + 1):
    num = str(i)
    cnt = find369(num)
    if cnt == 0:
        print(num, end="")
    else:
        print("-" * cnt, end="")

    if i < n:
        print(" ", end="")
