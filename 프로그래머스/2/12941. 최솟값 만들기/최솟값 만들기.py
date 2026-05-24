def solution(A, B):
    answer = 0
    A.sort()
    B.sort()

    for i in range(len(A)):

        answer += A[i] * B[len(B) - i - 1]
    return answer

A = [1, 4, 2]
B = [5, 4, 4]
print(solution(A, B))