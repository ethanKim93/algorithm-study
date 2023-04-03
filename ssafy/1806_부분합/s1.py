#https://www.acmicpc.net/submit/1806

import sys
sys.stdin = open("input.txt")


def solution(L,S):
    result = L + 1
    left, right = 0, 0
    total = 0

    if sum(data) < S:
        return 0
    while not (left == right == N):
        if total >= S:
            result = min(result, right - lfeft)
            total -= data[left]
            left += 1

        else:
            total += data[right]
            if right == N-1:
                return result
            right += 1
    return result

N,S = map(int,input().split())
data = list(map(int,input().split()))


ans = solution(N,S)

print(ans)
