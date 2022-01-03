import sys
sys.stdin = open('input.txt')

input = sys.stdin.readline

T = int(input())

for tc in range(T):
    N = int(input())
    rank = []
    for _ in range(N):
        rank.append(list(map(int,input().split())))
    rank = sorted(rank,key= lambda x:x[0])
    std = rank[0][1]
    cnt = 1
    for i in range(N):
        if std > rank[i][1]:
            cnt += 1
            std = rank[i][1]
    print(cnt)