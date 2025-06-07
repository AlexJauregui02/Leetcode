
function shortestPalindrome(s: string): string {
    const reverseString = s.split('').reverse().join('');
    const combinedString = s + "." + reverseString;

    const lps = new Array(combinedString.length).fill(0);

    for (let i = 1; i < combinedString.length; i++) {
        let len = lps[i - 1];
        while (combinedString[i] !== combinedString[len] && len > 0 ) {
            len = lps[len - 1];
        }
        if (combinedString[i] === combinedString[len]) {
            len++;
        }
        lps[i] = len;
    }

    const charAdd = s.substring(lps[combinedString.length - 1]);
    return charAdd.split('').reverse().join('') + s;
};
