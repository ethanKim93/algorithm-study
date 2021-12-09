import sys
sys.stdin = open('sample_input.txt')

def findmember(n,total,visit):
    global max_total
    if total+(n*100) < max_total:
        return max_total
    if max_total < total:
        max_total = total
    if n == 0:
        return max_total

    for i in range(M):
        if not visit[i] and favor[i]:
            visit[i] = 1
            love = favor[i] + n
            if love > 10:
                love = 10
            findmember(n-1,total+(skills[i]*love),visit)
            visit[i] = 0


T = int(input())

for tc in range(1,T+1):
    M,N = map(int,input().split())
    skills = list(map(int,input().split()))
    favor = list(map(int,input().split()))
    member = [[] for _ in range(M)]

    visit = [0]*M
    max_total = 0
    findmember(N,0,visit)
    print('#',end='')
    print(tc,max_total)