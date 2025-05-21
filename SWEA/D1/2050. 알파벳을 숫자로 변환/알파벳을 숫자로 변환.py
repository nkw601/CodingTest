# ord chr
sent = input()
for i in range(len(sent)):
    if i == len(sent) - 1:
        print(ord(sent[i].upper()) - 64, end="")
    else:
        print(ord(sent[i].upper()) - 64, end=" ")
