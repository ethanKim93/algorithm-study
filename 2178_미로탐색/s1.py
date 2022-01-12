import sys
from collections import deque
sys.stdin = open('input.txt')
T = int(input())

di = [1,-1,0,0]
dj = [0,0,1,-1]

for tc in range(T):
    N,M = map(int,input().split())
    matrix = []
    for i in range(N):
        matrix.append(list(map(int,input())))
    #print(matrix)
    visit = [(0,0)]
    queue = deque([(0,0,0)])
    flag = True
    while flag:
        x,y,cnt = queue.popleft()
        for dir in range(4):
            dx = x + di[dir]
            dy = y + dj[dir]
            if dx == (N - 1) and dy == (M - 1):
                ans = cnt+2
                flag = False
            if 0<=dx<N and 0<=dy<M and (dx,dy) not in visit and matrix[dx][dy]:
                visit.append((dx,dy))
                queue.append((dx,dy,cnt+1))
    print(ans)
