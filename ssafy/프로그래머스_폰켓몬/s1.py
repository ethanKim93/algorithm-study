
coins = [1,5,10,50,100,500]
def solution(money, costs):
    reverse_coins = coins[::-1]
    worth = []
    for i in range(6):
        worth.append((coins[i],costs[i],reverse_coins[i]*costs[i]))
    worth = sorted(worth,key= lambda x : x[2])
    answer = 0
    for c in worth:
        answer += (money//c[0])*c[1]
        money %= c[0]
    return answer

money = 4578
costs = [1, 4, 99, 35, 50, 1000]
print(solution(money, costs))
#2308

money =1999
costs =[2, 11, 20, 100, 200, 600]
print(solution(money, costs))
#2798