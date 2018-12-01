"""
Implement function ToLowerCase() that has a string parameter str, and returns the same string in lowercase.

 

Example 1:

Input: "Hello"
Output: "hello"

"""
def toLowerCase(str): 

	"""
	for c in str:
		if "A" <= c <= "Z":
			print(chr(ord(c) + 32))
		else:
			print(c)
	"""
	return "".join(chr(ord(c) + ord('a') - ord('A')) if "A" <= c <= "Z" else c for c in str)
	# return "".join(chr(ord(c) + ord('a') - ord('A')) if "A" <= c and  c <= "Z" else c for c in str)





str = "HeLLO"
print(toLowerCase(str))