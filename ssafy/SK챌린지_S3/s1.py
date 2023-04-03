
def factorial(num):
    fac = 1
    for n in range(1, num+1):
        fac *= n
    return(fac)

def solution(width, height, diagonals):
    answer = 0
    min_num = 987654321
    for dia in diagonals:
        dia_w = dia[0]
        dia_h = dia[1]
        for i in range(2):
            if i == 1:
                a1 = dia_w
                b1 = dia_h -1
                a2 = width - (dia_w - 1)
                b2 = height - dia_h
                First = int(factorial(a1 + b1) / (factorial(a1) * factorial(b1)))
                Second = int(factorial(a2 + b2) / (factorial(a2) * factorial(b2)))
            else:
                a1 = dia_h
                b1 = dia_w -1
                a2 = width - dia_w
                b2 = height - (dia_h -1)
                First = int(factorial(a1 + b1) / (factorial(a1) * factorial(b1)))
                Second = int(factorial(a2 + b2) / (factorial(a2) * factorial(b2)))
            answer += First*Second
    return int(answer)

width = 2
height = 2
diagonals = [[1,1],[2,2]]
print(solution(width, height, diagonals))

width = 51
height = 37
diagonals = [[17,19]]
print(solution(width, height, diagonals))