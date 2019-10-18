numbs = tuple(map(int, input().split(" ")))
amount = tuple(map(int, input().split(" ")))
xvar = 1
yvar = 1

if numbs[0] > numbs[1]:
    xvar = max(amount[0]-1, 1)
else:
    yvar = max(amount[0]-1, 1)
    total = 2 * xvar + yvar
    yvar -= max(amount[1] - total, 0)
    xvar += max(amount[1] - total, 0)



print(numbs[0]*xvar + numbs[1]*yvar)
