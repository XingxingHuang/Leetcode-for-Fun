# 黄xing
class Solution(object):
    def simplifyPath(self, path):
        """
        :type path: str
        :rtype: str
        """
        newArray = ["/"]
        for s in path.split('/'):
            if s == '.' or s == '':
                continue
            if s == '..':
                if len(newArray) == 1:
                    continue
                else:
                    newArray = newArray[:-1]
                    continue
            newArray.append(s)        
            #print newArray
        return '/'.join(newArray).replace('//','/')

                
        