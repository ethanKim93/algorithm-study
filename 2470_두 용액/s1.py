#https://www.acmicpc.net/problem/3273

import sys
sys.stdin = open("input.txt")

N = int(input())
data = list(map(int,input().split()))
data.sort()
left,right = 0,len(data)-1
#매우큰수
min_mix = 10000000000
result = []

while left < right:

    mix = data[left]+data[right]
    if abs(mix) < abs(min_mix):
        min_mix = abs(mix)
        result = [data[left],data[right]]

    if mix > 0:
        right -= 1
    elif mix < 0:
        left += 1
    else:
        break

print(*result)
