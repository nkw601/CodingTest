N = int(input())
F = int(input())

base = (N // 100) * 100

print(f"{(-base) % F:02d}")