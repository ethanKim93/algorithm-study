import sys
sys.stdin = open("input.txt")

T = int(sys.stdin.readline()) # 테스트 케이스

for tc in range(1,T+1): #테스트 케이스 만큼 반복
   data = list(sys.stdin.readline())
   m = int(sys.stdin.readline())
   idx = len(data)
   for i in range(m):
       order = list(sys.stdin.readline().split())
       if order[0] == 'P':
           data.insert(idx,order[1])
           idx += 1
       elif order[0] == 'L':
            if idx:
                idx -= 1
       elif order[0] == 'D':
            if idx != len(data):
                idx += 1
       elif order[0] == 'B':
           if idx:
               data.pop(idx-1)
               idx -= 1

   for c in data:
       print(c,end='')
   print()