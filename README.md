# Generate a Random String

The program will write into csv random strings containing numbers [0-9] and letters [a-z,A-Z].

Unicode chart - http://www.ssec.wisc.edu/~tomw/java/unicode.html

Code explanation:

Generate random numbers within the range 48 (unicode for 0) to 122 (unicode for z).
Only allow numbers less than 57 (the digits 0-9) or greater than 65 and less than 90 (letters A-Z) or great than 97 (the letters A-Z).
Map each number to a char.
Stop when you have the required length of the string. 
Collect the chars produced into a StringBuilder
Turn the StringBuilder in a String and return
