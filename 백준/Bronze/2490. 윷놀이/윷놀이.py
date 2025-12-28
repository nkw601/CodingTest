for i in range(3):
    a = list(map(int, input().split()))
    n = a.count(0)
    if n == 1:
        print("A")
    elif n == 2:
        print("B")
    elif n == 3:
        print("C")   
    elif n == 4:
        print("D")
    else:
        print("E") 