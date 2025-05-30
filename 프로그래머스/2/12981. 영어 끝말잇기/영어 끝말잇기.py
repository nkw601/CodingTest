def solution(n, words):
    word = set()
    
    prev = words[0]
    word.add(words[0])
    
    cur = 2
    rnd = 1
    
    for w in words[1:]:
        if w in word:
            return[cur, rnd]
        if prev[-1] != w[0]:
            return[cur, rnd]
        
        cur += 1
        word.add(w)
        prev = w
        
        if cur == (n+1):
            rnd += 1
            cur = 1

            
    return [0, 0]