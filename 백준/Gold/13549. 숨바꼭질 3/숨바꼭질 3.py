from collections import deque
N, K = map(int,input().split())

q = deque()
cost = [-1 for _ in range(200001)]
cost[N]=0
q.append(N)
while(q):
    now = q.popleft()
    if now==K:
        break

    if now*2<=K*2:
        if cost[now*2]==-1 or cost[now] < cost[now*2]:
            q.appendleft(now*2)
            cost[now*2]=cost[now]
    if now+1<=K:
        if cost[now+1]==-1 or cost[now]+1 < cost[now+1]:
            q.append(now+1)
            cost[now+1]=cost[now]+1
    if 0<=now-1:
        if cost[now-1]==-1 or cost[now]+1 < cost[now-1]:
            q.append(now-1)
            cost[now-1]=cost[now]+1

print(cost[now])