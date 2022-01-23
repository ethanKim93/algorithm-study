import sys
input = sys.stdin.readline

sys.stdin = open('input.txt')

p = [0]*21
p[0] = 0
p[1] = 1
N = int(input())
for i in range(2,N+1):
    p[i] = p[i-1]+p[i-2]
print(p[N])