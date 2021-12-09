import sys
sys.stdin = open("input.txt")

def percent(cur_per,visit):
    global max_per

    if not max_per == 100 and cur_per < max_per:
        return max_per
    elif 0 not in visit_work:
        max_per = cur_per

    for i in range(N):
        if not visit_worker[i]:
            visit_worker[i] = 1
            for j in range(N):
                if not visit_work[j]:
                    visit_work[j] = 1
                    percent(cur_per)
                    visit_work[j] = 0
                if visit_work:
                    pass
            visit_worker[i] = 0
        else:
            continue
T = int(input())

for tc in range(1,T+1):
    N = int(input())
    Pij = [ list(map(int,input().split())) for _ in range(N)]

    max_per = 1
    visit_worker = [0] * N
    visit_work = [0] * N
