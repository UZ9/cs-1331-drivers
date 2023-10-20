import glob
import os

filename = "./output/TestDriver.java"

os.makedirs(os.path.dirname(filename), exist_ok=True)

read_files = glob.glob("*.java")

with open(filename, "wb") as outfile:
    for f in read_files:
        with open(f, "rb") as infile:
            outfile.write(infile.read())