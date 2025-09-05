import sys
from heapq import heappop, heappush

input = sys.stdin.readline
INF = float('inf')
N = int(input())

dr = [-1, 1, 0, 0]
dc = [0, 0, -1, 1]
cnt = 1
while(N != 0):
    maps = [list(map(int, input().split())) for _ in range(N)]
    distance = [[INF] * N for _ in range(N)]
    pq = []

    distance[0][0] = maps[0][0]
    heappush(pq, (distance[0][0], 0, 0)) 

    while(len(pq) != 0):
        dist, cr, cc = heappop(pq)
        
        if cr==N-1 and cc==N-1:
            print(f"Problem {cnt}: {dist}")
            cnt+=1
            break  
        
        if dist > distance[cr][cc]:
            continue
        
        for d in range(4):
            nr = cr + dr[d]
            nc = cc + dc[d]

            if 0 <= nr < N and 0 <= nc < N:
                nd = dist + maps[nr][nc]

                if(nd < distance[nr][nc]):
                    distance[nr][nc] = nd
                    heappush(pq, (nd, nr, nc))

    N = int(input())