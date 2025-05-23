# 1. N % 10 == 0
# 2. 1 <= K <= N
# 3. 총점은 동일 X
# 총점 = 중긴(35) + 기말(45) + 과제(20)
# 학점: 10개(A~C+0- D0), N/10명씩
# K번째의 학점은?
T = int(input())
for test_case in range(1, T + 1):
    N, K = map(int, input().split())
    scores = []
    k_sco = 0

    for i in range(N):
        mid, fin, asg = map(int, input().split())
        score = (mid * 0.35) + (fin * 0.45) + (asg * 0.20)
        scores.append(score)
        if i == K - 1:
            k_sco = score

    scores.sort(reverse=True)
    grades = ["A+", "A0", "A-", "B+", "B0", "B-", "C+", "C0", "C-", "D0"]
    k_rank = scores.index(k_sco)
    print(f"#{test_case} {grades[k_rank//(N // 10)]}")
