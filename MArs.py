year = 12*(int(input()) - 2018)
if (year-3)%26 == 0 or (year-2)%26 == 0 or (year-1)%26 == 0 or (year)%26 == 0 or (year+1)%26 == 0 or (year+2)%26 == 0 or (year+3)%26 == 0 or (year+4)%26 == 0 or (year+5)%26 == 0 or (year+6)%26 == 0:
    print("yes")
else:
    print("no")
