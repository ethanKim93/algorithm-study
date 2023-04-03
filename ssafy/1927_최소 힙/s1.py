import sys
import heapq
from collections import deque
sys.stdin = open('input.txt')


N = int(input())

heap = []
for _ in range(N):
    num = int(input())
    if num:
        heapq.heappush(heap,num)
    else:
        if heap:
            print(heapq.heappop(heap))
        else:
            print(0)