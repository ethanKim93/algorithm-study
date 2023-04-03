import sys
sys.stdin =open('input.txt')

T = int(input())
for tc in range(T):
data = input()
ans = 0
mode = 0 #0은 덧셈 ,1은 뺄셈
head = 0
for idx,i in enumerate(data):
    k = 1
    if mode: # 뺄셈 모드일때
        if idx == (len(data) - 1):
            ans -= int(data[head:])
        if i == '+' :
            ans -= int(data[head:idx])
            head = idx+1
        elif i =='-':
            ans -= int(data[head:idx])
            head = idx + 1

    else: # 덧셈 모드일때
        if idx == (len(data) - 1):
            ans += int(data[head:])
        if i == '+' :
            ans += int(data[head:idx])
            head = idx+1
        elif i == '-':
            mode = 1
            ans += int(data[head:idx])
            head = idx + 1
print(ans)