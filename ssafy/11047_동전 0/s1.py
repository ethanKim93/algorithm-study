import sys
sys.stdin = open('input.txt')
input = sys.stdin.readline

T = int(input())

for tc in range(T):
    N,K = map(int,input().split())
    moneys = []
    result = 0
    for _ in range(N):
        moneys.append(int(input()))
    for i in range(N-1,-1,-1):
        if K >= moneys[i]:
            result += K//moneys[i]
            K = K % moneys[i]
        if K == 0:
            break
    print(result)


