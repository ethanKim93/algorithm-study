import sys
sys.stdin = open('input.txt')

T = int(input())

for tc in range(T):
    N = int(input())
    datas = []
    result = 0
    for _ in range(N):
        datas.append(input())
    num = [n for n in range(10)]
    data_dic = {}
    for data in datas:
        data_len = len(data)-1
        for c in data:
            if c in data_dic:
                data_dic[c] += 10**data_len
            else:
                data_dic[c] = 10**data_len
            data_len -= 1
    data_dic = sorted(data_dic.items(),key=lambda x:x[1] , reverse=True)
    for data in data_dic:
        result += data[1]*num.pop(-1)
    print(result)