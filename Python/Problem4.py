
def shortestPalindrome(self, s: str) -> str:
    reverse = s[::-1]
    combined_string = s + '.' + reverse

    lps = [0] * len(combined_string)

    for i in range(1, len(combined_string)):
        pattern = lps[i - 1]
        while pattern > 0 and combined_string[i] != combined_string[pattern]:
            pattern = lps[pattern - 1]
        if combined_string[i] == combined_string[pattern]:
            pattern += 1
        lps[i] = pattern

    chars_to_add = s[lps[-1]:]
    return chars_to_add[::-1] + s
