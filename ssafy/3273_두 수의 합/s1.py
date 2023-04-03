#https://www.acmicpc.net/problem/3273

import sys
sys.stdin = open("input.txt")

N = int(input())
data = list(map(int,input().split()))
X = int(input())


#런타임 에러
# ans = 0
# for i in range(N):
#     if data[i] > X:
#         continue
#     for j in range(i+1,N):
#         if data[j] > X:
#             continue
#         if data[i]+data[j]==X:
#             ans += 1
#             break
# print(ans)

#sort 방식
data.sort()
left,right = 0,(N-1)
ans = 0
while left<right:
    hap = data[left] + data[right]

    if hap == X:
        ans += 1
        right -= 1
    elif hap < X:
        left += 1
    elif hap > X:
        right -= 1
        left = 0

print(ans)