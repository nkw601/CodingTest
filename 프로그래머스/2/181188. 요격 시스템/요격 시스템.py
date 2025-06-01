def solution(targets):
    targets.sort(key=lambda x: x[1])
    
    answer = 0
    end = 0
    for t in targets:
        if t[0] >= end:
            answer += 1
            end = t[1]
        
    return answer