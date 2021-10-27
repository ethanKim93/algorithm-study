import sys
sys.stdin = open("input.txt")

T = int(sys.stdin.readline()) # 테스트 케이스

for tc in range(1,T+1): #테스트 케이스 만큼 반복
   stack = [] # 빈스택
   n = int(sys.stdin.readline())
   std =[int(sys.stdin.readline()) for i in range(n)]
   result = []
   top = 0
   num = 1

   while top < n:
       if std[top] >= num: # std[top] in not stack으로 사용했다가 시간초과 발생,현재 스택에 없다면
           stack.append(num)
           result.append('+')
           num += 1
       elif std[top] == stack[-1]: #스택 끝자리에 찾고자 하는 답이 있다면
           stack.pop(-1)
           result.append('-')
           top += 1
       else:
           print('NO')
           break
   else:#while문을 break하지 않았다면
       for ans in result:
           print(ans)