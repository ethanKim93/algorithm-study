import sys
sys.stdin = open("input.txt")

T = int(input())

for tc in range(1,T+1):
    n = int(input())
    d = [0]*12
    d[1] = 1
    d[2] = 2
    d[3] = 4
    for i in range(4,n+1):
        d[i] = d[i-3]+d[i-2]+d[i-1]
    print(d[n])
