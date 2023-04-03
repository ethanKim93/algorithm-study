import sys
sys.stdin = open("input.txt")



def birus(computers,start = 1):
    visit = []
    queue = [start]
    while queue:
        start = queue.pop(0)
        for computer in computers[start]:
            if computer not in visit:
                queue.append(computer)
                visit.append(computer)
    print(len(visit)-1)

N = int(input())
M = int(input())

computers = list([] for _ in range(N+1))
for c in range(M):
    node1,node2 = map(int,input().split())
    computers[node1].append(node2)
    computers[node2].append(node1)

birus(computers)