import sys
sys.stdin = open("input.txt")


def solution(strings, n):
    answer = sorted(sorted(strings),key=lambda x:(x[n]))
    return answer

T = int(input())
for tc in range(T):
    strings = list(input().split(','))
    n = int(input())
    print(solution(strings,n))
