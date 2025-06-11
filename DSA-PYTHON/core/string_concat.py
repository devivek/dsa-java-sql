import timeit
import os, sys, platform, multiprocessing

print("Python:", sys.version)
print("Interpreter:", sys.executable)
print("Platform:", platform.platform())
print("Logical CPUs :", multiprocessing.cpu_count())

# Concatenate strings
start_time = timeit.default_timer()
s = ''
for i in range(100000000):
    s += 'abcd'
elapsed_time_concat = timeit.default_timer() - start_time
print('Time taken for string concatenation:', elapsed_time_concat)

# Join strings
start_time = timeit.default_timer()
lst = []
for i in range(100000000):
    lst.append('abcd')
s = ''.join(lst)
elapsed_time_join = timeit.default_timer() - start_time
print('Time taken for string join:', elapsed_time_join)

join_performance = (elapsed_time_concat - elapsed_time_join) / elapsed_time_concat
print('Performance gained with join', join_performance)