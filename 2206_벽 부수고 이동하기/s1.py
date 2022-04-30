import sys
sys.stdin = open('input.txt')

dr = [0,0,1,-1]
dc = [1,-1,0,0]

T = int(sys.stdin.readline())

for tc in range(T):
    N,M = map(int,input().split())
    matrix = [list(input()) for _ in range(N)]
    queue = [(0,0,1,1)] #x,y,count,block
    visit = []
    min_count = 987654321
    while queue:
        x,y,count,block = queue.pop(0)
        if x == (N-1)and y== (M-1):
           min_count = min(min_count,count)
           continue
        for dir in range(4):
           dx = x + dr[dir]
           dy = y + dc[dir]
           if 0 <= dx < N and 0<= dy < M and (dx,dy) not in visit:
               if matrix[dx][dy] == 0:
                    queue.append((dx,dy,count+1,block))
                    visit.append((dx,dy))
               elif block:
                    matrix[dx][dy] = 0
                    queue.append((dx,dy,count+1,0))
                    visit.append((dx,dy))
        print(min_count)