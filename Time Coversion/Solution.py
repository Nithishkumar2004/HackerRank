#!/bin/python3

import math
import os
import random
import re
import sys

#
# Complete the 'timeConversion' function below.
#
# The function is expected to return a STRING.
# The function accepts STRING s as parameter.
#

def timeConversion(s):
    # Write your code here
      # Extract parts from the input string
    hh = int(s[:2])
    mmss = s[2:8]
    period = s[8:]

    # Logic to convert 12-hour format to 24-hour format
    if period == "AM":
        if hh == 12:
            hh = 0
    else:
        if hh != 12:
            hh += 12

    # Format the hour part to always have two digits
    hour_formatted = f"{hh:02}"

    # Construct the result string in 24-hour format
    result = hour_formatted + mmss

    return result

if __name__ == '__main__':
    fptr = open(os.environ['OUTPUT_PATH'], 'w')

    s = input()

    result = timeConversion(s)

    fptr.write(result + '\n')

    fptr.close()
