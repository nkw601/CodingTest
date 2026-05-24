def solution(cap, n, deliveries, pickups):
    answer = 0
    d_sum, p_sum = 0, 0
    # 그리디 알고리즘, 먼 곳부터 가고, 가는 김에 가까운 집 처리
    for i in range(n-1, -1, -1):
        d_sum += deliveries[i]
        p_sum += pickups[i]

        # 이 위치에서 총 몇 번 방문해야 하는지 계산
        while d_sum > 0 or p_sum > 0:
            d_sum -= cap
            p_sum -= cap
            answer += (i + 1) * 2  # 왕복 거리
            
    return answer