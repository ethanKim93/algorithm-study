import sys
sys.stdin = open('input.txt')
input = sys.stdin.readline

N = int(input())
P = list(map(int,input().split()))
P.sort()
result = 0
t = 0
for i in P:
    t += i
    result += t
print(result)
