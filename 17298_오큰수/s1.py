#ghttps://www.acmicpc.net/problem/17298

import sys
sys.stdin = open("input.txt")

T = int(input())

for tc in range(1,T+1):
    N = int(input())
    data = list(map(int,input().split()))

    result = [-1]*N
    stack = [data[-1]]
    i = N-2
    while i >= 0:
        if stack[]

        stack.append(data[i])
        i
    print(*result)
