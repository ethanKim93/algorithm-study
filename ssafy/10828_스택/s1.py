import sys

def push(stack,x):
    stack.append(x)
    return stack
def pop(stack):
    if len(stack):
        return print(stack.pop(-1))
    return print(-1)
def size(stack):
    return print(len(stack))
def is_empty(stack):
    if len(stack): return print(0)
    else: print(1)
def top(stack):
    if len(stack):
        return print(stack[-1])
    return print(-1)

stack = []

N = int(sys.stdin.readline())

for _ in range(N):
    cmd = list(sys.stdin.readline().split())
    if cmd[0] == 'push':
        stack = push(stack,cmd[1])
    elif cmd[0] == 'pop':
        pop(stack)
    elif cmd[0] == 'size':
        size(stack)
    elif cmd[0] == 'empty':
        is_empty(stack)
    elif cmd[0] == 'top':
        top(stack)