import sys
sys.stdin = open('input.txt')

input = sys.stdin.readline
N = int(input())
room = []
for i in range(N):
    room.append(list(map(int,input().split())))

room = sorted(room,key= lambda x:x[0])
room = sorted(room,key= lambda x:x[1])

last = 0
cnt = 0

for i,j in room:
    if i >= last:
        cnt += 1
        last = j
print(cnt)