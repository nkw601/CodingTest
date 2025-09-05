import sys
from heapq import heappop, heappush

INF = float('inf')

def dijkstra(start):
    pq = []
    # 시작점 거리 0으로 초기화, pq에 넣기
    dist[start] = 0
    heappush(pq, (0, start))
    while(pq):
        wei, cur = heappop(pq)

        if wei > dist[cur]:
            continue

        for next in nodes[cur]:
            # to, weight
            cost = dist[cur] + next[1]

            if cost < dist[next[0]]: # next의 to까지 가는 가중치가 여길 거쳐서 가는 것보다 크다면 업데이트
                dist[next[0]] = cost
                heappush(pq, (cost, next[0]))


input = sys.stdin.readline

V, E = map(int, input().split()) # 정점 수, 간선 수
K = int(input()) # 시작점

nodes = [[] for _ in range(V + 1)]
dist = [INF] * (V + 1)

for i in range(E):
    # 입력
    u, v, w = map(int, input().split())
    nodes[u].append((v, w))

dijkstra(K)

for i in range(1, V + 1):
    d = dist[i]
    if(d < INF):
        print(d)
    else:
        print("INF")