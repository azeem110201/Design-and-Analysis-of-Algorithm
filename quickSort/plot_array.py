import matplotlib.pyplot as plt

size = list()
time = list()
output = list()

with open("plot.txt", "r") as f:
    output = f.readlines()

for i in range(len(output)):
    size.append(int(output[i].split("size")[1].split("is")[0]))

for i in range(len(output)):
    time.append(int(output[i].split("size")[1].split("is")[1].split("ms")[0]))

plt.plot(time, size)
plt.xlabel("Time (ms)")
plt.ylabel("Size of Array")
plt.savefig('quickSortImage.png')
plt.show()

