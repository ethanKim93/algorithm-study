import sys
sys.stdin =open('input.txt')
input = sys.stdin.readline
def power(x, y):
    # 코드를 작성하세요.
    if y ==0:
        return 1
    if y == 1:
        return x*y

    return power(x,y//2)*power(x,y//2)*power(x,y%2)

T = int(input())
for tc in range(T):
    a, b = map(int, input().split())
    ans = str(power(a, b))
    ans = ans[-1]
    if ans == '0':
        ans = 10
    print(ans)