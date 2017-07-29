# class LogSystem(object):

#     def __init__(self):
        

#     def put(self, id, timestamp):
#         """
#         :type id: int
#         :type timestamp: str
#         :rtype: void
#         """
        

#     def retrieve(self, s, e, gra):
#         """
#         :type s: str
#         :type e: str
#         :type gra: str
#         :rtype: List[int]
#         """
        
class LogSystem(object):
    def __init__(self):
        self.logs = []

    def put(self, tid, timestamp):
        self.logs.append((tid, timestamp))
        
    def retrieve(self, s, e, gra):
        index = {'Year': 5, 'Month': 8, 'Day': 11, 
                 'Hour': 14, 'Minute': 17, 'Second': 20}[gra]
        start = s[:index]
        end = e[:index]
        
        return sorted(tid for tid, timestamp in self.logs
                      if start <= timestamp[:index] <= end)
    
class LogSystem(object):

    def __init__(self):
        self.d = {}
        self.f = {"Year":4, "Month":7,"Day":10,"Hour":13,"Minute":16,"Second":19}

    def put(self, id, timestamp):
        self.d[id] = timestamp
        

    def retrieve(self, s, e, gra):
        res = []
        pre = self.f[gra]
        spre = s[:pre]
        epre = e[:pre]
        for x in self.d.keys():
            v = self.d[x]
            if v[:pre]>=spre and v[:pre]<=epre:
                res.append(x)
        return res
        

# Your LogSystem object will be instantiated and called as such:
# obj = LogSystem()
# obj.put(id,timestamp)
# param_2 = obj.retrieve(s,e,gra)