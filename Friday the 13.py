t = int(input())
for i in range(t):
    dayMon = input().split( )
    daysinMon = input().split( )
    daysMon = 0
    month = 0
    total = 0
    for i in range(int(dayMon[0])):
        
        if ((int(daysinMon[daysMon])+month) == i):
            month += int(daysinMon[daysMon])
            daysMon += 1 
        if (i % 7 == 6):
            if (i - month == 13):
                total += 1
    
    print(total)
    
        
