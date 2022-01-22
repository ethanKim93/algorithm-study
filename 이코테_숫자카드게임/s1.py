import sys
sys.stdin = open("input.txt")


N,M,K = map(int,input().split())
data = list(map(int,input().split()))

data = sorted(data,reverse=True)
print(data)
cnt = 0
ans = 0
while cnt < M:
    for i in range(K):
        ans += data[0]
        cnt += 1
        if cnt == M:
            break
    ans += data[1]
    cnt +=1
print(ans)


