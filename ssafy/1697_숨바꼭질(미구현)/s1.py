import sys
sys.stdin = open('input.txt')

dx = [-1,1,2]

def move(v,n):
    if n == 1:
        return v+1
    elif n == -1:
        return v-1
    else:
        return v*2

def bfs(v):
    visit = [v]
    queue = [(v,0)]
    cnt = 0
    while v != K:
        v = queue.pop(0)
        for n in dx:
            queue.append(move(v[0],n)vv)
        cnt += 1
    print(cnt)

N,K = map(int,input().split())
bfs(N)
