import argparse
import os

template_loc = os.path.join('templates','DayX.txt')
target_dir = os.path.join('src','main','java','com','github','nikgil','days')
days_dir = os.path.join('src','main','resources')
main_loc = os.path.join('src','main','java','com','github','nikgil', 'Main.java')
md_file = os.path.join('README.md')

parser = argparse.ArgumentParser()
parser.add_argument('day', type=int)

args = parser.parse_args()

title = f'Day{args.day}'

# open(os.path.join(days_dir, f'{title}.txt'), 'a').close()
#
# with open(template_loc) as f:
#     contents = f.read()
#     contents = contents.replace('DayX', title).replace('super(X)', f'super({args.day})')
#
#     path = os.path.join(target_dir, f'{title}.java')
#
#     with open(path, 'w') as newFile:
#         newFile.write(contents)
#
# target_index = None
#
# with open(main_loc, 'r') as main_file:
#     lines = main_file.readlines()
#
#     for (idx, line) in enumerate(lines):
#         if 'private static void addDays() {' in line:
#             target_index = idx
#             break
#
# if lines is not None and target_index is not None:
#     lines.insert(target_index+1, f'        days.put({args.day}, new {title}());\n')
#
#     with open(main_loc, 'w') as main_file:
#         main_file.write("".join(lines))

md_line = f'\n| Day {args.day} | [Input {args.day}](src/main/resources/{title}.txt) | [Sol {args.day}](src/main/java/com/github/nikgil/days/{title}.java) |  |  |'

with open(md_file, 'a') as md:
    md.write(md_line)