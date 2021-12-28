import sys
sys.stdin = open("input.txt")
input = sys.stdin.readline

T = int(input())

for tc in range(T):
    N = int(input())
    matrix = []
    for _ in range(N):
        matrix.append(list(map(int,input().split())))
    start = (0,0)
    queue = [start]
    visit = []
    while queue:
        cur = queue.pop(0)
        x,y = cur[0],cur[1]
        visit.append((x,y))
        move = matrix[x][y]
        if move == -1:
            print('HaruHaru')
            break
        dx = x + move
        dy = y + move
        if dx < N and (dx,y) not in visit:
            queue.append((dx,y))
        if dy < N and (x,dy) not in visit:
            queue.append((x,dy))
    else:
        print('Hing')