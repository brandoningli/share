from collections import namedtuple
gpa = namedtuple('gpa', ['grade','points'])
wgpa = namedtuple('wgpa', ['grade','points'])

gradea = gpa('a', 4)
gradeb = gpa('b', 3)
gradec = gpa('c', 2)
graded = gpa('d', 1)
gradef = gpa('f', 0)
gradewa = wgpa('a', 5)
gradewb = wgpa('b', 4)
gradewc = wgpa('c', 3)
gradewd = wgpa('d', 1)
gradewf = wgpa('f', 0)

wgrades = [gradewa, gradewb, gradewc, gradewd, gradewf]
grades = [gradea, gradeb, gradec, graded, gradef]
classg = input("What is the Letter Grade for this class? ")
classw = input("Is Class Weighted? y/n ")
if classw == 'y':
    for grade in wgrades:
        if classg == grade.grade:
            grade = grade.points
            break
        else:
            grade = "nada"
if classw == 'n':
    for grade in grades:
        if classg == grade.grade:
            grade = grade.points
            break
        else:
            grade = "nada"
print("This Class Earns ", grade, "GPA Points")
