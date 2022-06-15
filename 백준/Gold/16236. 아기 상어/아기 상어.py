import sys
from collections import deque

input = sys.stdin.readline

N = int(input())
space = [list(map(int, input().split())) for _ in range(N)]

babySize = 2

dx = [0, 1, 0, -1]
dy = [1, 0, -1, 0]
now = tuple()
ans = 0
exp = 0
for i in range(N):
    for j in range(N):
        if space[i][j] == 9:
            now = (i, j)

def bfs(start):
    queue = deque()
    candidate = []
    queue.append((start[0], start[1], 0))
    visit = [[0] * N for _ in range(N)]
    visit[start[0]][start[1]] = 1

    while queue:
        x, y, w = queue.popleft()
        for d in range(4):
            r = x + dx[d]
            c = y + dy[d]
            if r < 0 or r >= N or c < 0 or c >= N:
                continue
            if space[r][c] > babySize or visit[r][c]:
                continue
            else:
                queue.append((r, c, w + 1))
                visit[r][c] = 1
            if space[r][c] and space[r][c] < babySize:
                candidate.append((r, c, w + 1))



    return sorted(candidate, key=lambda x: (x[2], x[0], x[1]))


while True:
    candidate = bfs(now)
    if not candidate:
        break
    catchFish = candidate.pop(0)
    exp += 1
    if exp == babySize:
        babySize += 1
        exp = 0
    ans += catchFish[2]
    space[now[0]][now[1]] = 0
    space[catchFish[0]][catchFish[1]] = 0
    now = (catchFish[0], catchFish[1])

print(ans)
