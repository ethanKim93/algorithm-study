import sys
sys.stdin = open('input.txt')

T = int(input())

for tc in range(T):
    N = int(input())
    data = []
    for _ in range(N):
        data.append(input())
    data.sort(key=len,reverse=True)
    num = [n for n in range(10)]
    char_dic = {}
    max_len = len(data[0])
    idx = 0
    while max_len:
        cur = max_len - idx
        for chars in data:
            if len(chars) >= cur:
                for c in chars:
                    if c not in char_dic:
                        char_dic[c]
        idx += 1