import sys
sys.stdin = open("input.txt")

T = int(input())

for tc in range(1,T+1):
   datas = list(input().split()) # space를 기준으로 단어를 띄어쓰기함.
   for data in datas:
       print(data[::-1],end=' ') # 뒤집어서 출력
   print()