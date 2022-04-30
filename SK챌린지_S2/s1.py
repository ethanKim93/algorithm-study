from collections import deque
T_dr = [0,1,0,-1]
T_dc = [1,0,-1,0]

F_dr = [1,0,-1,0]
F_dc = [0,-1,0,1]

def solution(n, clockwise):
    if clockwise:
        c_dr = T_dr
        c_dc = T_dc
    else:
        c_dr = F_dr
        c_dc = F_dc
    matrix = [[0]*n for _ in range(n)]
    deq = deque([(0,0),(0,n-1),(n-1,n-1),(n-1,0)])
    cnt = 1
    circle_dir = 0
    flag = True
    flag_cnt = 0
    while True:
        for i in range(4):
            r,c = deq.popleft()
            matrix[r][c] = cnt
            dr = r+c_dr[(i+circle_dir)%4]
            dc = c+c_dc[(i+circle_dir)%4]
            #print((dr,dc))
            if 0 <= dr < n and 0<= dc < n and matrix[dr][dc] == 0:
                deq.append((dr,dc))
                #print(matrix)
            else:
                deq.append((r,c))
                flag = False
        if flag == False:
            circle_dir += 1
            flag = True
            if flag_cnt > 4:
                break
            flag_cnt += 1
        else:
            flag_cnt = 0
            cnt += 1
    return matrix

n = 5
clockwise = True
print(solution(n, clockwise))
#[[1,2,3,4,1],[4,5,6,5,2],[3,6,7,6,3],[2,5,6,5,4],[1,4,3,2,1]]

n = 6
clockwise = False
print(solution(n, clockwise))
#[[1,5,4,3,2,1],[2,6,8,7,6,5],[3,7,9,9,8,4],[4,8,9,9,7,3],[5,6,7,8,6,2],[1,2,3,4,5,1]]

n = 9
clockwise = False
print(solution(n, clockwise))
#	[[1,8,7,6,5,4,3,2,1],[2,9,14,13,12,11,10,9,8],[3,10,15,18,17,16,15,14,7],[4,11,16,19,20,19,18,13,6],[5,12,17,20,21,20,17,12,5],[6,13,18,19,20,19,16,11,4],[7,14,15,16,17,18,15,10,3],