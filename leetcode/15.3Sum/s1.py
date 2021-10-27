nums = [-1,0,1,2,-1,-4]

def dfs(v,total,ans=[]):
    if v == 3:
        if total == 0:
            sorted(ans)
            if ans not in result:
                result.append(ans)
            for k in ans:
                print(numsk[k],end=' ')
            print()

    for i in range(len(nums)):
        if i not in ans:
            ans.append(i)
            dfs(v+1,total+nums[i])
            ans.pop(-1)
result = []
type(result)
dfs(0,0)

