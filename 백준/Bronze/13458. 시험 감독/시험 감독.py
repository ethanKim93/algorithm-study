import sys
import math

N = int(input())
A = list(map(int,input().split()))
B,C = map(int,input().split())

ans = 0
for student in A:
    ans += 1
    temp = student-B
    if temp > 0:
        ans += math.ceil(temp/C)
print(ans)
