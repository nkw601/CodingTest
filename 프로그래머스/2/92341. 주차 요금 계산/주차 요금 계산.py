def solution(fees, records):
    answer = []
    # 단순 구현인 것 같은데?
    park_dict = {}
    price_dict = {}
    
    for record in records:
        times, car_num, txt = record.split()
        
        if txt == "IN":
            park_dict[car_num] = times
        
        # txt == "OUT"
        else:
            in_time = park_dict[car_num]
            in_hour, in_min = map(int, in_time.split(':'))
            out_hour, out_min = map(int, times.split(':'))
            
            # park_dict에서 출차한 차 제거
            del park_dict[car_num]
            
            # 이용 시간 확인
            using_min = (out_hour - in_hour) * 60 + out_min - in_min
            # 차 번호, 이용 시간을 price_dict에 추가
            if car_num in price_dict:
                price_dict[car_num] += using_min
            else:
                price_dict[car_num] = using_min
        
        # 입차만 하고 출차는 안 한 경우: 23:59에 출차로 간주
    for car_num, in_time in park_dict.items():
        in_hour, in_min = map(int, in_time.split(':'))
        out_hour, out_min = 23, 59
        
        using_min = (out_hour - in_hour) * 60 + (out_min - in_min)
        if car_num in price_dict:
            price_dict[car_num] += using_min
        else:
            price_dict[car_num] = using_min
        
    # 돈 계산
    for car_num in sorted(price_dict.keys()):
        using_min = price_dict[car_num]
        # 기본 시간 이하라면
        if using_min <= fees[0]:
            answer.append(fees[1])
        # 기본 시간 초과라면
        else:
            using_min -= fees[0]
            
            unit = using_min // fees[2]
            remain = using_min % fees[2]
            if remain != 0: unit += 1
            
            answer.append(fees[1] + (unit * fees[3]) )
    return answer