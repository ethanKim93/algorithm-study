import sys
input = sys.stdin.readline

import collections
#sys.stdin = open("input.txt")

queue = collections.deque()

N = int(input())
for _ in range(N):
   data = input().split()
   cmd = data[0]
   if len(data) > 1:
      num = data[1]

   if cmd == 'push':
      queue.append(num)
   elif cmd =='front':
      if queue:
         print(queue[0])
      else:
         print(-1)
   elif cmd == 'back':
      if queue:
         print(queue[-1])
      else:
         print(-1)
   elif cmd == 'pop':
      if queue:
         print(queue.popleft())
      else:
         print(-1)
   elif cmd =='size':
         print(len(queue))
   elif cmd =='empty':
      if queue:
         print(0)
      else:
         print(1)