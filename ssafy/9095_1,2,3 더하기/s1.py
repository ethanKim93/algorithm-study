#https://www.acmicpc.net/problem/19941
import sys
sys.stdin = open("input.txt")

T = int(input())

for tc in range(1,T+1):
    N,K = map(int,input().split())
    data = list(input())
    hambuger = []
    cnt = 0
    for idx,i in enumerate(data):
        if i == "P":
            for j in range(-K, K+1):
                if 0<(idx+j)<N and data[idx+j] == "H":
                   data[idx+j] = "E"
                   cnt += 1
                   break

    print(cnt)