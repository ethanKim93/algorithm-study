import sys
sys.stdin = open('input.txt')
input = sys.stdin.readline

T = int(input())
for tc in range(T):
    kg = int(input())
    cnt = 0
    while True:
        if kg % 5 == 0:
            cnt += kg //5
            break
        elif kg >= 3:
            cnt += 1
            kg -= 3
        else:
            cnt = -1
            break
    print(cnt)