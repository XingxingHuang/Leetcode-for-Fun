# easy 
class Solution(object):
    def judgeCircle(self, moves):
        """
        :type moves: str
        :rtype: bool
        """
        if len(moves) == 0:
            return True
        i = 0
        j = 0
        for move in moves:
            if move == "R": i += 1
            if move == "L": i -= 1
            if move == "U": j += 1
            if move == "D": j -= 1
        if (i == 0 and j == 0): return True
        return False
        
# collections counter        
def judgeCircle(self, moves):
    c = collections.Counter(moves)
    return c['L'] == c['R'] and c['U'] == c['D']