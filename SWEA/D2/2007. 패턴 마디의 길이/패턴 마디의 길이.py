T = int(input())
for test_case in range(1, T + 1):
    sent = input()
    pattern = ""
    for i in range(1, len(sent)):
        word = sent[:i]

        if word == sent[i : i + len(word)]:
            pattern = word
            break

    print(f"#{test_case} {len(pattern)}")