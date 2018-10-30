def uniqueMorseRepresentations(words):
	d = [".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..", "--",
	"-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--.."]
	return len({''.join(d[ord(i) - ord('a')] for i in w) for w in words})   #{} 大括号，集合

	# seen = ["".join(d[ord(c) - ord('a')] for c in word) for word in words]
	# mset = set(seen)
	# print(seen)
	# print(mset)
 #    return len(seen)

words = ["gin", "zen", "gig", "msg"]
print(uniqueMorseRepresentations(words))