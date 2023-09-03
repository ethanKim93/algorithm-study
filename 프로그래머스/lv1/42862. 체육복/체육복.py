def solution(n, lost, reserve):
    m,k = n,n
    new_lost = set(lost) - set(reserve)
    new_reserve = set(reserve) -set(lost)
    for i in new_lost:
        if i+1 in new_reserve:
            new_reserve.remove(i+1)
        elif i-1 in new_reserve:
            new_reserve.remove(i-1)
        else:
            m -= 1
    
    new_lost = set(lost) - set(reserve)
    new_reserve = set(reserve) -set(lost)
    for i in new_lost:
        if i-1 in new_reserve:
            new_reserve.remove(i-1)
        elif i+1 in new_reserve:
            new_reserve.remove(i+1)
        else:
            k -= 1
    return max(m,k)