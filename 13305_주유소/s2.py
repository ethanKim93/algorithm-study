import sys
sys.stdin = open('input.txt')
input = sys.stdin.readline

T = int(input())
for tc in range(T):
    N = int(input())
    dis = list(map(int,input().split()))
    cities = list(map(int,input().split()))
    result = 0
    head = 0
    for i in range(len(cities)):
        if cities[head] >= cities[i] or i == (len(cities)-1):
            result += sum(dis[head:i])*cities[head]
            head = i
    print(result)
