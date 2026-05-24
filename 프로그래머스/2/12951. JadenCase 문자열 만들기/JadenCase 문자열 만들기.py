def solution(s):
    answer = ''
    words = s.split(" ")
    for i in words:
        if i != "":
            answer += i[0].upper() + i[1:].lower()
            answer += " "
        else:
            answer += " "
    
    return answer[:-1]
    