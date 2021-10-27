import sys
sys.stdin = open("input.txt")

T = int(input())

for tc in range(1,T+1):
   stack = [] # 빈스택
   datas = input()
   ans = 'YES'
   for data in datas:
       if data == '(':
           stack.append(data)
       else:
           if stack:
                stack.pop(-1)
           else:
               ans = 'NO'
               break
   if stack:
        ans = 'NO'
   print(ans)
