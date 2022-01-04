import sys
from collections import deque
sys.stdin = open('input.txt')


N = int(input())
cards = deque()
for _ in range(N):
    cards.append(int(input()))
cards = deque(sorted(cards))
ans = 0
while len(cards) > 1:
    temp = cards.popleft()+cards.popleft()
    ans += temp
    idx = 0
    while cards:
        if temp <= cards[idx] or idx == (len(cards)-1):
            cards.insert(idx,temp)
            break
        else:
            idx += 1
print(ans)