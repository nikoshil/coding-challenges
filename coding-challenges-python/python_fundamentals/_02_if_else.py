
# If is odd, print Weird
# If is even and in the inclusive range of 2 to 5, print Not Weird
# If is even and in the inclusive range of 6 to 20, print Weird
# If is even and greater than , print Not Weird

if __name__ == '__main__':
    n = int(input().strip())

if n % 2 > 0:
    print("Weird")
elif n > 20:
    print("Not Weird")
elif n > 5:
    print("Weird")
else:
    print("Not Weird")