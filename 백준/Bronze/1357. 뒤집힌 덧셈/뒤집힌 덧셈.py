def rev(s):
    return int(str(s)[::-1])

a, b = map(int, input().split())
print(rev(rev(a) + rev(b)))