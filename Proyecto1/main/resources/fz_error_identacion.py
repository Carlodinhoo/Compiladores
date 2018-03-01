a = 20
cont = 1
while(cont < a):

	if cont%3 == 0 and cont%5 == 0:
		print "FizzBuzz!"
	elif cont%5 == 0:
		print "Buzz"
	elif cont%3 == 0:
		print "Fizz"
	else: 
print cont
	cont = cont+1