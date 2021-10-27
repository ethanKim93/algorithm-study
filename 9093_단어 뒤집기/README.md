## 1 .문제 번호: 9093번

## 2. 문제 출처

https://www.acmicpc.net/problem/10828

## 3. 풀이과정

- 입력을 단어별로 리스트로 나눠서 받고, 각 단어를 뒤집어서 출렸했다

## 4.어려웠던 점

- 없다

## 최종 코드

```python
import sys
sys.stdin = open("input.txt")

T = int(input())

for tc in range(1,T+1):
   datas = list(input().split()) # space를 기준으로 단어를 띄어쓰기함.
   for data in datas:
       print(data[::-1],end=' ') # 뒤집어서 출력
   print()
```

