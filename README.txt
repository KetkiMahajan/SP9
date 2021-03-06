## CS-5V81.001-SP9

Implementation of data structures and algorithms
Fall 2018
Short Project 9: Divide and conquer algorithms
Thu, Oct 25, 2018

Version 1.0: Initial description (Thu, Oct 11).

Due: 11:59 PM, Sun, Nov 4.

Submission procedure: same as usual.


Team task:
1. Implement and compare the running times of the following algorithms
   on randomly generated arrays: (a) Insertion sort, (b) Merge sort (take 1),
   (c) Merge sort (take 2), (d) Merge sort (take 3).
   Do not run more than one algorithm in each trial.
   For Insertion sort, if the running time exceeds 2 min, write the time as infinity.
   For Merge sort, in each trial, run only one algorithm, for one value of n, 100 times
   in a loop, and taking the average time.
   Try the following values of n: 8M, 16M, 32M, 64M, ..., until you get out of memory exception.
   Submit a report with your observations.  Starter code is provided.


Individual task (optional):

2. Use BigInteger class and write programs to computer f(n), the nth Fibonacci number.
   Implement the O(n) algorithm and the O(log n) algorithm.  Compare their running times
   for the following values of n: 1000, 10000, 100000.  Since printing the output
   takes a lot of time, stop the timer before starting to print the output.
   In each trial, run only one algorithm, for just one value of n.
   At the top of your source file, write the observations within /* ... */ comments.
