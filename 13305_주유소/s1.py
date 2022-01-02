# 마지막 도시의 가격은 필요 없음.
# 전체에서 최소값을 찾아서 그 이후의 도시 거리는 최소 도시에서 충전
# 그 앞에 도시는 다시 그중 최소값을 찾아서 뒤의 도시 거리만큼이동
# 최소비용 합


import sys
sys.stdin = open('input.txt')
input = sys.stdin.readline

T = int(input())
for tc in range(T):
    result = 0
    N = int(input())
    dis = list(map(int,input().split()))
    cities = list(map(int,input().split()))
    cities = cities[:N-1] #마지막 도시 제외
    min_idx = 0
    pre_city = -1
    while dis:
        min_city = 1000000001  # 제약조건보다 큰수
        for idx in range(len(cities)-1,-1,-1):
            if cities[idx] <= min_city:
                min_city = cities[idx]
                min_idx = idx
                if (pre_city + 1) == min_city:
                    break
        result += sum(dis[min_idx:]) * min_city
        pre_city = min_city
        cities = cities[:min_idx]
        dis = dis[:min_idx]
    print(result)