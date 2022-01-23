import sys
#input = sys.stdin.readline

sys.stdin = open('input.txt')
TC = int(input())

for ttc in range(TC):
    T = int(input())
    for tc in range(T):
        d = list([0, 0] for _ in range(41))
        N = int(input())
        d[0] = [1,0]
        d[1] = [0,1]
        for i in range(2,N+1):
            d[i] = [d[i-1][0]+d[i-2][0],d[i-1][1]+d[i-2][1]]
        print(*d[N])