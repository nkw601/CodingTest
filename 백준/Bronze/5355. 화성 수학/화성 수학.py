t = int(input())

for _ in range(t):
    tokens = input().split()
    value = float(tokens[0])

    for op in tokens[1:]:
        if op == '@':
            value *= 3
        elif op == '%':
            value += 5
        elif op == '#':
            value -= 7

    print(f"{value:.2f}")
