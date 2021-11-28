import sys
sys.stdin = open("input.txt")


import sys

input = sys.stdin.readline

N = int(input())
que = []
def command(data):
    if len(data) != 1:
        cmd = data[0]
        X = data[1]
    else:
        cmd = data[0]

    if cmd == 'push':
        que.append(X)
    elif cmd == 'pop':
        try:
            print(que.pop(0))
        except:
            print(-1)
    elif cmd == "size":
        print(len(que))
    elif cmd == "empty":
        if len(que):
            print(0)
        else:
            print(1)
    elif cmd == "front":
        try:
            print(que[0])
        except:
            print(-1)
    elif cmd == "back":
        try:
            print(que[-1])
        except:
            print(-1)


for i in range(N):
    data = list(input().split())

    command(data)