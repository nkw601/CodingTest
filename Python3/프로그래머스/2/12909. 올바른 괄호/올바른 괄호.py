def solution(s):
    answer = True
    cnt = 0
    
    # 첫 번째에 )면 false
    if s[0] == ')':
        return False
    
    for i in range(len(s)):
        if s[i] == '(':
            cnt+=1
        else:
            cnt-=1
        
        if cnt < 0:
            return False
    return cnt == 0
