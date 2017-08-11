# 2017.08.10 XingxingHuang
class Solution(object):
    def solveEquation(self, equation):
        """
        :type equation: str
        :rtype: str
        """
        texts = equation.split("=")
        a1, b1 = self.parse(texts[0])
        a2, b2 = self.parse(texts[1])
        a = a1 - a2
        b = b2 - b1
        if (a == 0 and b != 0):
            return "No solution"
        elif (a == 0 and b == 0):
            return "Infinite solutions"
        else:
            return "x=" + str(b / a);
    def parse(self, text):
        a = 0; b = 0
        i = 0; j = 0
        while (j <= len(text)):
            if (j == len(text) or (i != j and text[j] in ['-', '+'])):
                tmpa, tmpb = self.getnum(text[i:j])
                a += tmpa
                b += tmpb
                # print text[i:j]," : " ,tmpa, tmpb
                i = j
            j += 1
        return a, b
    def getnum(self, text):
        a = 0; b = 0
        sign = 1
        if (text[0] == '-'):
            sign = -1
        text = text[1:] if text[0] in ['-', '+'] else text
        if (text[-1] == 'x' and len(text) == 1):
            a = 1
        elif (text[-1] == 'x'):
            a = int(text[0:-1])
        else:
            b = int(text)
        return sign * a, sign * b
        
        
        
class Solution(object):
    def solveEquation(self, equation):
        """
        :type equation: str
        :rtype: str
        """
        strings = equation.split('=')
        numx1, num1 = self.get(strings[0])
        numx2, num2 = self.get(strings[1])
        numx = numx1 - numx2
        num = num2 - num1
        # print numx1, num1
        # print numx2, num2
        # print numx, num
        if numx == 0:
            if num == 0:
                return "Infinite solutions"
            else:
                return "No solution"
        else:
            return "x=%i" %(num / numx)
    
    def get(self, string):
        numx = 0
        num = 0
        sign = 1
        i = 0
        while (i < len(string)):
            count = 0
            run = False
            while (i < len(string) and '0' <= string[i] <= '9'):
                count = 10 * count + int(string[i])
                i += 1
                run = True
            # print string, i, count, sign
            # "+x" "-x"
            if not run and string[i] == 'x':
                numx += sign
            # check the next character and determine the result    
            elif i < len(string) and string[i] == 'x':
                numx += count * sign
            else:
                num += count * sign
                if i >= len(string):
                    break
                elif string[i] == '+':
                    sign = 1
                elif string[i] == '-':
                    sign = -1
            i += 1
        return numx, num
            
                
# Solution from discussion
class Solution(object):
    def solveEquation(self, equation):
        A, B = self.parseSide(equation.split('=')[0]) # Ax+B
        C, D = self.parseSide(equation.split('=')[1]) # Cx+D
        
        #Ax + B = Cx + D 
        if A == C and B != D: 
            return "No solution"
        elif A == C and B == D: 
            return "Infinite solutions"
        else: 
            return "x=" + str((D - B) / (A - C))
        
    def parseSide(self, side):
        tokens = re.findall('[-+]?[0-9]*x?', side)
        
        A,B = 0, 0 #return in the form Ax+B
        for token in tokens: 
            if token == 'x' or token == '+x': A += 1
            elif token == '-x': A -= 1 
            elif 'x' in token: A += int(token[:-1])
            elif len(token) > 0: B += int(token) #our regex could also match empty strings 
        return A,B