import sys
sys.stdin = open("input.txt")

tc = 1
while True:
    stack = []
    brackets = input()
    if '-' in brackets:
        break
    cnt = 0
    for bracket in brackets:
        if bracket == '{':
            stack.append(bracket)
        else:
            if stack:
                stack.pop()
            else:
                cnt += 1
                stack.append('{')
    cnt += len(stack)//2
    print(tc,end='. ')
    print(cnt)
    tc+=1
