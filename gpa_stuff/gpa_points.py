
from collections import namedtuple

def gpapoints(letter, weight):
    #Defining how we are naming the elements in our named tuples
    ugpa = namedtuple('ugpa', ['grade','points'])
    wgpa = namedtuple('wgpa', ['grade','points'])
    #actually creating our tuples with the naming schemes defined above
    gradea = ugpa('a', 4) #named based on 'ugpa' scheme
    gradeb = ugpa('b', 3)
    gradec = ugpa('c', 2)
    graded = ugpa('d', 1)
    gradef = ugpa('f', 0)
    gradewa = wgpa('a', 5)#named based on the 'wgpa' scheme
    gradewb = wgpa('b', 4)
    gradewc = wgpa('c', 3)
    gradewd = wgpa('d', 1)
    gradewf = wgpa('f', 0)

    #creating lists of our tuples for later for loops
    wgrades = [gradewa, gradewb, gradewc, gradewd, gradewf]
    grades = [gradea, gradeb, gradec, graded, gradef]

    if weight == 'y':
        for grade in wgrades:
            if letter == grade.grade:
                gpa = grade.points
                break
            else:
                gpa = 0
    if weight == 'n':
        for grade in grades:
            if letter == grade.grade:
                gpa = grade.points
                break
            else:
                gpa = 0
    return gpa
def userinput():
    while True:
        global classnum
        classnum = input("How many classes? ")
        try:
            classnum = int(classnum)
            break
        except:
            print("That's not an integer. Try Again!")
userinput()
for x in range(0, classnum):
    classg = input("What is the Letter Grade for class "+str(x+1)+"? ").lower()
    classw = input("Is Class Weighted? y/n ").lower()
    #the .lower() will make sure the input is lowercase so that it will match our named tuples
    classpoints = gpapoints(classg, classw)
    print("This Class Earns", classpoints, "GPA Points \n")
input("Press <Enter> to Exit")
