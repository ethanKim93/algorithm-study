import sys
from collections import deque
sys.stdin = open('input.txt')
T = int(input())

def DFS(v,visit):
    visit.append(v)
    for i in sorted(node[v]):
        if i not in visit:
            visit =  DFS(i,visit)
    return visit
def BFS(v,visit):
    visit = [v]
    queue = [v]
    while queue:
        v = queue.pop(0)
        for w in sorted(node[v]):
            if w not in visit:
                visit.append(w)
                queue.append(w)
    return visit
for tc in range(T):
    N,M,V = map(int,input().split())
    node = list([] for _ in range(N+1))

    for _ in range(M):
        start,end = map(int,input().split())
        node[start].append(end)
        node[end].append(start)
    dfs_visit = []
    bfs_visit = []

    print(*DFS(V,dfs_visit))
    print(*BFS(V,bfs_visit))