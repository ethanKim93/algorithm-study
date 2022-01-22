import sys
sys.stdin = open("input.txt")


def makeone(x,cnt=0):
    global min_cnt

    if x == 1:
        min_cnt = min(min_cnt,cnt)
        return 0
    else:
        if x % 5 == 0:
            makeone(x / 5,cnt+1)
        if x % 3 == 0:
            makeone(x / 3,cnt+1)
        if x % 2 == 0:
            makeone(x / 2,cnt+1)
        makeone(x-1,cnt+1)

X = int(input())
min_cnt = 987654321
makeone(X)
print(min_cnt)