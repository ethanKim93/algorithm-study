x = int(input())
y = str(input())

ans = 0
cnt = 0
for n in range(len(y)-1,-1,-1):
    temp = x*int(y[n])
    ans += temp*(10**cnt)
    cnt += 1
    print(x*int(y[n]))
print(ans)