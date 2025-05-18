T = int(input())
for test_case in range(1, T + 1):
    n1, n2 = map(int, input().split())
    if n1 > n2:
        print(f"#{test_case} >")
    elif n1== n2:
        print(f"#{test_case} =")
    else:
        print(f"#{test_case} <")