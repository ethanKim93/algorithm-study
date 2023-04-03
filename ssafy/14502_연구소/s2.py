# 문제 풀이과정
'''
1. 벽을 선택한다.
2. 바이러스를 퍼트린다.
3. 바이러스가 퍼지지 않은 안전지역 면적을 구한다.
1~3번의 과정을 벽을 선택하는 모든 경우의 수에 대해서 반복하고,
마지막에 안전지역의 max값 리턴
'''

# input 및 변수선언

import copy
import sys

sys.stdin = open('input.txt')

input = sys.stdin.readline

T = int(input())

dr = [1,-1,0,0]
dc = [0,0,1,-1]

def stand_wall(start=0,count=0):
    global max_safe
    if count == 3:
        copy_data = copy.deepcopy(data)
        for virus in virus_list:
            r,c = virus
            spread_virus(r,c,copy_data)
        safe_count = sum(i.count(0) for i in copy_data)
        max_safe = max(max_safe,safe_count)
        return True
    else:
        for i in range(start,N*M):
            r = i // M
            c = i % M
            if data[r][c] == 0:
               data[r][c] = 1
               stand_wall(i,count+1)
               data[r][c] = 0

def spread_virus(r,c,copy_data):
    for dir in range(4):
        dx = r + dr[dir]
        dy = c + dc[dir]
        if 0<= dx < N and 0 <= dy < M and copy_data[r][c] == 2 and copy_data[dx][dy] == 0:
            copy_data[dx][dy] = 2
            spread_virus(dx,dy,copy_data)

for tc in range(T):
    N,M = map(int,input().split())
    data = [list(map(int,input().split())) for _ in range(N)]
    virus_list = []
    for i in range(N):
        for j in range(M):
            if data[i][j] == 2:
                virus_list.append([i,j])
    max_safe = 0
    stand_wall()
    print(max_safe)
