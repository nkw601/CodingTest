def solution(s):
    answer = ''
    nums = s.split()
    nums = [int(i) for i in nums]
    answer += str(min(nums))
    answer += " "
    answer += str(max(nums))

    return answer