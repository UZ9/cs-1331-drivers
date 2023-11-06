import glob
import os
import re

filename = "../Driver.java"

os.makedirs(os.path.dirname(filename), exist_ok=True)

read_files = glob.glob("../src/*.java")

with open(filename, "wb") as outfile:
    code_lines = []
    import_lines = []

    inject_path = None

    for f in read_files:
        with open(f, "rb") as infile:
            code_lines.append(("//AUTOGENERATED FROM " + infile.name + "\n").encode())
            
            for line in infile:
                line = str(line, 'UTF-8')
                line = line.replace("public class", "class")
                line = line.replace("public @interface", "@interface")
                line = line.replace("HW06Driver", "Driver")

                if inject_path != None:
                    regex = r"^(.*?)\""
                    match = re.search(regex, line).group(1).rstrip()

                    with open("../src/" + inject_path) as inject_file:
                        inject_lines = "".join(inject_file.readlines())
                        inject_lines = inject_lines.replace('\n', '\\n')

                        new_line = match + " \"" + inject_lines + "\\n\";"

                        print("New:")
                        print(new_line)

                        code_lines.append(new_line.encode())

                    inject_path = None
                    continue

                if "@InjectData" in line:
                    regex = r'"(.*?)"'

                    match = re.findall(regex, line)[0]

                    inject_path = match
                    code_lines.append(("\t//AUTOMATICALLY EXTRACTED FROM " + match + "\n").encode())
                    continue

                if not line in import_lines:

                    if line.startswith("import"):
                        import_lines.append(line);
                        outfile.write(line.encode())

                        continue
                    else:
                        code_lines.append(line.encode())
                
            code_lines.append("\n".encode())

    outfile.writelines(code_lines)
