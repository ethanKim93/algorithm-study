import sys
sys.stdin = open("input.txt")

print('<',end='')

N,K = map(int,input().split())
queue = [i for i in range(1,N+1)]
ans = []
while queue:
    for i in range(K):
        queue.append(queue.pop(0))
    ans.append(queue.pop())
print(", ".join(map(str,ans)),end='')
print('>')