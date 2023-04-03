import sys
sys.stdin = open('input.txt')

T = int(input())

for tc in range(T):
    N = int(input())
    stack = []
    for i in range(N):
        k = int(input())
        if k:
            stack.append(k)
        else:
            stack.pop()
    print(sum(stack))