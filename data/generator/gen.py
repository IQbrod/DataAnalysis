import numpy
import pandas as pd 
lab = range(100)
m = numpy.random.randint(10, size=(10000,100))
df = pd.DataFrame(lab+m)
df.to_csv("file_path.csv")
