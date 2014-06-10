grades = []
def function():
    global grades
    expercent = input("Type an example percent float: ")
    exletter = input("Type an example letter grade: ")
    expoints = input("Type an example GPA points: ")
    classtuple = (expercent, exletter, expoints)
    print("The Tuple for this class is", classtuple)
    grades.append(classtuple)
    print("")

def userinput():
    global classnum
    while True:
        classnum = input("How many classes? ")
        try:
            classnum = int(classnum)
            break
        except:
            print("That's not an integer. Try Again!")
userinput()
for x in range(0, classnum):
    function()
print("The list is", grades,"\n")
print("Your First Class Letter Grade is", grades[0][1])
input("Press <Enter> To Exit")
