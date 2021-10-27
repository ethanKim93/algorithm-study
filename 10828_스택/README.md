## 1 .문제 번호: 10828번

## 2. 문제 출처
https://www.acmicpc.net/problem/10828

## 3. 풀이과정

- 각 기능 별 메소드를 정의하여 문제를 풀었다.

## 4.어려웠던 점

- 문제 자체는 어렵지 않게 쉽게 풀었는데 계속 시간 초과가 발생하였다.

- 최대한 더 간결하게 작성하려 했지만 계속 시간 초과가 발생하여 자료를 찾아보았다.
- input()함수를 사용할 경우 시간초과가 발생한다고 한다.
- `import sys`를 정의하고**sys.stdin.readline()** 사용하여 해결하였다.

## 최종 코드

```python
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
```
