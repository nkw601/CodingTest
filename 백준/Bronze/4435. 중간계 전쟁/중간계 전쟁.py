t = int(input().strip())

good_w = [1, 2, 3, 3, 4, 10]
evil_w = [1, 2, 2, 2, 3, 5, 10]

for i in range(1, t + 1):
    good = list(map(int, input().split()))
    evil = list(map(int, input().split()))

    g_score = sum(x * w for x, w in zip(good, good_w))
    e_score = sum(x * w for x, w in zip(evil, evil_w))

    if g_score > e_score:
        msg = "Good triumphs over Evil"
    elif g_score < e_score:
        msg = "Evil eradicates all trace of Good"
    else:
        msg = "No victor on this battle field"

    print(f"Battle {i}: {msg}")