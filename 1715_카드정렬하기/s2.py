import sys
import heapq
sys.stdin = open('input.txt')

N = int(input())
cards = []
for _ in range(N):
    heapq.heappush(cards,int(input()))
ans = 0
while len(cards) > 1:
    temp = heapq.heappop(cards)+heapq.heappop(cards)
    ans += temp
    heapq.heappush(cards,temp)
print(ans)