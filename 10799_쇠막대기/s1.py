import sys
sys.stdin = open('input.txt')

T = int(input())

for i in range(1,T+1):
    bars = input()
    ans = 0
    stack = []
    for idx,i in enumerate(bars):
        if i == '(':
            stack.append(i)
        if i == ')':
            if stack:
                stack.pop()
                if bars[idx-1] == '(':
                    ans += len(stack)
                else:
                    ans += 1
            else:
                ans += 1
    print(ans)