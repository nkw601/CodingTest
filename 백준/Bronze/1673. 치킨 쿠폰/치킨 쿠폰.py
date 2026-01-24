import sys

out = []
for line in sys.stdin:
    line = line.strip()
    if not line:
        continue
    n, k = map(int, line.split())
    total = 0
    coupons = n

    while coupons >= k:
        new = coupons // k
        total += new
        coupons = new + (coupons % k)

    out.append(str(total + n))

sys.stdout.write("\n".join(out))