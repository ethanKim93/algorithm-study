import sys

l_data = list(sys.stdin.readline().strip())
m = int(sys.stdin.readline())
r_data = []
for i in range(m):
   com = sys.stdin.readline().strip()
   if com[0] == 'P':
       l_data.append(com[2])
   elif com[0] == 'L':
        if l_data:
            r_data.append(l_data.pop())
   elif com[0] == 'D':
        if r_data:
            l_data.append(r_data.pop())
   elif com[0] == 'B':
        if l_data:
           l_data.pop()

print(''.join(l_data + list(reversed(r_data))))