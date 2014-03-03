import math
def main():
    print("TRIANGLE SOLVER")
    print("CREATED BY BRANDON INGLI")
    print("-----------------------------")
    sideorangle = input("Are you looking for a side or angle? s/a: ")
    if sideorangle == "S" or sideorangle == "s":
        side()
    if sideorangle == "A" or sideorangle == "a":
        angle()
def side():
    rttri = input("Is it a right triangle? y/n: ")
    if rttri == "Y" or rttri == "y":
        spclrt = input("Is it a special right triangle? (45-45-90 [isoc. right] or 30-60-90) y/n: ")
        if spclrt == "Y" or spclrt == "y":
            print("In 45-45-90 [isoc. right], hypotenuse is", u"\u221A"+"2 times leg \nIn 30-60-90, Hyoptenuse is twice the short leg, and the long leg is", u"\u221A"+"3 times short leg.")
        if spclrt == "N" or spclrt == "n":
            twosides = input ("Are 2 sides given? y/n: ")
            if twosides == "Y" or twosides == "y":
                print("Use Pythagorean Thm: a^2 + b^2 = c^2 or c =", u"\u221A"+"a^2 + b^2")
                solvepythag = input("Start Pythagorean Thm. Solver? y/n: ")
                if solvepythag == "Y" or solvepythag == "y":
                    pythagthm()
            if twosides == "N" or twosides == "n":
                trig = input("Do you have a side and any non-right angle? y/n: ")
                if trig == "Y" or trig == "y":
                    print("Use Right Triangle Trig: Soh Cah Toa")
                    solvetrig = input("Start Right Triangle Trig Solver? y/n: ")
                    if solvetrig == "Y" or solvetrig == "y":
                        rttritrig()
                if trig == "N" or trig == "n":
                    print("There is not enough info to solve for a side.")

    if rttri == "N" or rttri == "n":
        lawsin = input("Do you have an angle, its opposite side, and the angle opposite to the side you want to find? y/n: ")
        if lawsin == "Y" or lawsin == "y":
            print("Use the Law of Sines: (Sin A / a) = (Sin B / b) = (Sin C / c)")
            solvelawsin = input("Start Law of Sines Solver? y/n: ")
            if solvelawsin == "Y" or solvelawsin == "y":
                lawsins()
        if lawsin == "N" or lawsin == "n":
            lawcos = input("Do you have 2 sides an angle? y/n: ")
            if lawcos == "Y" or lawcos == "y":
                print("Use the Law of Cosines: a^2 = b^2 + c^2 - 2(b)(c)(Cos A)")
                solvelawcos = input("Start Law of Cosine Solver? (NOTE: You must setup your equation so that the side you want to find is 'a' in the above equation to use the solver) y/n: ")
                if solvelawcos == "Y" or solvelawcos == "y":
                    lawcoss()
            if lawcos == "N" or lawcos == "n":
                print("There is not enough info to solve for a side.")
def angle():
    tri180 = input("Do you have 2 angles? y/n: ")
    if tri180 == "Y" or tri180 == "y":
        print("Use Triangle=180: 180-(one angle you have) - (the other angle you have) = (the angle you want to find")
        tri180solve = input("Start Triangle=180 solver? y/n: ")
        if tri180solve == "Y" or tri180solve == "y":
            tri180solver()
    if tri180 == "N" or tri180 == "n":
        rttri = input("Is it a right triangle? y/n: ")
        if rttri == "Y" or rttri == "y":
            spclrt = input("Is it a special right triangle? (isoc. rt triangle or Hyoptenuse is twice the short leg, and the long leg is "+u"\u221A"+"3 times short leg) y/n: ")
            if spclrt == "Y" or spclrt == "y":
                print("In [isoc. right], 45-45-90. In Hyoptenuse is twice the short leg, and the long leg is", u"\u221A"+"3 times short leg, 30-60-90.")
            if spclrt == "N" or spclrt == "n":
                trig = input("Do you have any 2 sides? y/n: ")
                if trig == "Y" or trig == "y":
                    print("Use Right Triangle Trig: Soh Cah Toa")
                    solvetrig = input("Start Right Triangle Trig Solver? y/n: ")
                    if solvetrig == "Y" or solvetrig == "y":
                        rttritrigangle()
                if trig == "N" or trig == "n":
                    print("There is not enough info to solve for an angle.")

        if rttri == "N" or rttri == "n":
            lawsin = input("Do you have a side, its opposite angle, and the side opposite the angle you want to find? y/n: ")
            if lawsin == "Y" or lawsin == "y":
                print("Use the Law of Sines: (Sin A / a) = (Sin B / b) = Sin C / c)")
                solvelawsin = input("Start Law of Sines Solver? y/n: ")
                if solvelawsin == "Y" or solvelawsin == "y":
                    lawsinangle()
            if lawsin == "N" or lawsin == "n":
                lawcos = input("Do you have all 3 sides? y/n: ")
                if lawcos == "Y" or lawcos == "y":
                    print("Use the Law of Cosines: a^2 = b^2 + c^2 - 2(b)(c)(Cos A)")
                    solvelawcos = input("Start Law of Cosine Solver? (NOTE: You must setup your equation so that the side opposite the angle you want to find is 'a' in the above equation to use the solver) y/n: ")
                    if solvelawcos == "Y" or solvelawcos == "y":
                        lawcosangle()
                if lawcos == "N" or lawcos == "n":
                    print("There is not enough info to solve for an angle.")

def pythagthm():
    print("----------------------------")
    print("Input the following values, and type 'find' for the side you want to find")
    a = input("Side A: ")
    b = input("Side B: ")
    c = input("Hypotenuse: ")
    if a == "find":
        b = int(b)
        c = int(c)
        bsq = math.pow(b, 2)
        csq = math.pow(c, 2)
        ans = math.sqrt(csq - bsq)
        print("Side A is", ans)
    if b == "find":
        a = int(a)
        c = int(c)
        asq = math.pow(a, 2)
        csq = math.pow(c, 2)
        ans = math.sqrt(csq - asq)
        print("Side B is", ans)
    if c == "find":
        b = int(b)
        a = int(a)
        bsq = math.pow(b, 2)
        asq = math.pow(a, 2)
        ans = math.sqrt(asq + bsq)
        print("Hypotenuse is", ans)
def rttritrig():
    print("----------------------------")
    try:
        angle = float(input("What is the measure of the angle given? "))
    except:
        print("You Did Not Enter a number.")
    print("For each side, input its given value, 'find' if its the side you want to find,")
    print("or 'skip' if it is not given and/or not applicable.")
    print("(NOTE: Each option must be used and can only be used on one side.)")
    oppleg = input("The Opposite Leg (to the angle): ")
    adjleg = input("The Adjacent Leg (to the angle): ")
    hypt = input("The Hypotenuse (of the triangle): ")
    try:
        if oppleg == 'find' and adjleg == 'skip':
            hypt = float(hypt)
            print("The sin of the angle is approx.", math.sin(math.radians(angle)))
            ans = hypt * math.sin(math.radians(angle))
            print("The Opposite Leg is approx.", ans, "units long.")
        if hypt == 'find' and adjleg == 'skip':
            oppleg = float(oppleg)
            print("The sin of the angle is approx.", math.sin(math.radians(angle)))
            ans = oppleg / math.sin(math.radians(angle))
            print("The Hypotenuse is approx.", ans, "units long.")
        if adjleg == 'find' and oppleg == 'skip':
            hypt = float(hypt)
            print("The cos of the angle is approx.", math.cos(math.radians(angle)))
            ans = hypt * math.cos(math.radians(angle))
            print("The Adjacent Leg is approx.", ans, "units long.")
        if hypt == 'find' and oppleg == 'skip':
            adjleg = float(adjleg)
            print("The cos of the angle is approx.", math.cos(math.radians(angle)))
            ans = adjleg / math.cos(math.radians(angle))
            print("The Hypotenuse is approx.", ans, "units long.")
        if oppleg == 'find' and hypt == 'skip':
            adjleg = float(adjleg)
            print("The tan of the angle is approx.", math.tan(math.radians(angle)))
            ans = adjleg * math.tan(math.radians(angle))
            print("The Opposite Leg is approx.", ans, "units long.")
        if adjleg == 'find' and hypt == 'skip':
            oppleg = float(oppleg)
            print("The tan of the angle is approx.". math.tan(math.radians(angle)))
            ans = oppleg / math.tan(math.radians(angle))
            print("The Adjacent Leg is approx.". ans, "units long.")
    except:
        print("Something went wrong. You may have not entered 'find' and 'skip' exactly correct.")
            
    
def lawsins():
    print("----------------------------")
    try:
        side = float(input("What is the length of the given side? "))
        oppangle = float(input("What is the value of the angle opposite that side? (A) "))
        findangle = float(input("What is the value of the angle opposite the side you are looking for? (B) "))
    except:
        print("Something went wrong. Perhaps you didn't enter numbers.")
    try:
        print("The sin of angle A is approx.", math.sin(math.radians(oppangle)))
        print("The sin of angle B is approx.", math.sin(math.radians(findangle)))
        ans = (oppangle * math.sin(math.radians(findangle))) / math.sin(math.radians(oppangle))
        print("The side is approx.", ans, "units long.")
    except:
        print("Something went wrong in this Computer's Trig classroom :-) .")

def lawcoss():
    print("----------------------------")
    try:
        side1 = float(input("What is the length of one of your given sides? "))
        side2 = float(input("What is the length of the other given sides? "))
        angle = float(input("What is the value of the angle opposite the side you want to find? "))
    except:
        print("Something went wrong. Perhaps you didn't enter numbers.")
    try:
        preans = math.pow(side1, 2) + math.pow(side2, 2) - (2*side1*side2*math.cos(math.radians(angle)))
        ans = math.sqrt(preans)
        print("The side is approx.", ans, "units long.")
    except:
        print("Something went wrong in this Computer's Trig classroom :-) .")
def rttritrigangle():
    print("----------------------------")
    print("For each side, input its given value,")
    print("or 'skip' if it is not given and/or not applicable.")
    oppleg = input("The Opposite Leg (to the angle): ")
    adjleg = input("The Adjacent Leg (to the angle): ")
    hypt = input("The Hypotenuse (of the triangle): ")
    try:
        if adjleg == 'skip':
            hypt = float(hypt)
            oppleg = float(oppleg)
            ratio = oppleg/hypt
            ans = math.degrees(math.asin(ratio))
            print("The angle is approx.", ans, "degrees.")
        if oppleg == 'skip':
            hypt = float(hypt)
            adjleg = float(adjleg)
            ratio = adjleg/hypt
            ans = math.degrees(math.acos(ratio))
            print("The angle is approx.", ans, "degrees.")
        if hypt == 'skip':
            oppleg = float(oppleg)
            adjleg = float(adjleg)
            ratio = oppleg/adjleg
            ans = math.degrees(math.atan(ratio))
            print("The angle is approx.", ans, "degrees.")
    except:
        print("Something went wrong. You may have not entered 'skip' exactly correct.")
def lawsinangle():
    print("----------------------------")
    try:
        angle = float(input("What is the value of the given angle? "))
        sidea = float(input("What is the length of the side opposite that angle? "))
        sideb = float(input("What is the length of the other given side? "))
    except:
        print("Something went wrong. Perhaps you didn't enter numbers.")
    try:
        print("The sin of the given angle is", math.sin(math.radians(angle)))
        ans = math.degrees(math.asin((sideb * math.sin(math.raidans(angle)))/sidea))
        print("The angle is approx.", ans, "degrees.")
    except:
        print("Something went wrong in this Computer's Trig classroom :-) .")
def lawcosangle():
    print("----------------------------")
    try:
        sidea = float(input("What is the lemgth of the side opposite the angle you want to find?"))
        sideb = float(input("What is the length of another given side? "))
        sidec = float(input("What is the length of the third given side? "))
    except:
        print("Something went wrong. Perhaps you didn't enter numbers.")
    try:
        ans = math.degrees(math.acos((math.pow(sidea, 2)-math.pow(sideb, 2) - math.pow(sidec,2))/(-2 * sideb * sidec)))
        print("The angle is approx.", ans, "degrees.")
    except:
        print("Something went wrong in this Computer's Trig classroom :-) .")

def tri180solver():
    try:
        angle1 = float(input("What is the value of the first angle? "))
        angle2 = float(input("What is the value of the second angle? "))
    except:
        print("Something went wrong. Perhaps you didn't enter numbers.")
    try:
        ans = 180 - angle1 - angle2
        print("The third angle is", ans, "degrees.")
    except:
        print("Something went wrong in this Computer's Math classroom :-) .")
main()
input("Press <ENTER> to exit")
