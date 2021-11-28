import sys
sys.stdin = open("input.txt")

input = sys.stdin.readline

N,K = map(int,input().split())

cicle = list(i for i in range(1,N+1))
ans = []
point = -1
while cicle:
    for j in range(K):
        point += 1
        if point == len(cicle):
            point = 0
    ans.append(str(cicle.pop(point)))
    point -= 1
result = ', '.join(ans)
print('<'+result+'>')