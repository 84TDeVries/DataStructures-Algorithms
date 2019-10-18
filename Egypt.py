string = input().split( )
for i in range(len(string)):
        string[i] = int(string[i])
while string[0] != string[1] or string[1] != string[2] or string[0] != 0:
    
    maxim = max(string)
    ind = string.index(maxim)
    total = 0 
    if 0 == ind:
        total = string[1] * string[1] + string[2] * string[2]
    elif 1 == ind:
        total = string[0] * string[0] + string[2] * string[2]
    else:
        total = string[1] * string[1] + string[0] * string[0]
    if total == maxim * maxim:
        print("right")
    else:
        print("wrong")
    string = input().split( )
    for i in range(len(string)):
        string[i] = int(string[i])
