import sys
sys.stdin = open("input.txt")



def solution(nums):
    N = int(len(nums)/2)
    poketmon = []
    for num in nums:
        if len(poketmon) == N:
            break
        if num not in poketmon:
            poketmon.append(num)
    answer = len(poketmon)
    return answer


T = int(input())
for tc in range(T):
    print(solution(list(map(int,input().split(',')))))