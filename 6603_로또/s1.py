import sys
sys.stdin = open("input.txt")

flag = True
while flag:
    data = list(map(int,input().split()))
    k = data[0] #들어오는 숫자의 갯수
    if not k: flag = False
    S = data[1:] #들어오는 숫자리스트

    for i1 in range(0,k-5):
        for i2 in range(i1+1,k-4):
            for i3 in range(i2+1, k - 3):
                for i4 in range(i3+1, k - 2):
                    for i5 in range(i4+1, k - 1):
                        for i6 in range(i5+1, k):
                            print(S[i1],S[i2],S[i3],S[i4],S[i5],S[i6])

    print()