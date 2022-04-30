def solution(progresses, speeds):
    answer = []
    days = [0] * len(progresses)
    flag = True
    day = 1
    while flag:
        flag = False
        for i in range(len(progresses)):
            if progresses[i]:
                flag = True
            progresses[i] += speeds[i]
            if progresses[i] >= 100:
                progresses[i] = 0
                speeds[i] = 0
                days[i] = day
        day += 1
        print(days)
        head = 0
        tail = 0
        cnt = 0
        while True:
            if tail==len(days):
                break               
            if days[head] >= days[tail] and tail<len(days):
                pass
            else:
                answer.append(sum(days[head:tail]))
                head = tail
            tail += 1
    return answer

print(solution([93, 30, 55],	[1, 30, 5]))