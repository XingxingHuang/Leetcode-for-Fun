# 12.09 contest 62
# 很好的图练习题，需要重新练习
# 注意点，有向图，可能有环，可能node需要重新访问来得到最小访问时间。
class Solution(object):
    def networkDelayTime(self, times, N, K):
        """
        :type times: List[List[int]]
        :type N: int
        :type K: int
        :rtype: int
        """
        map = {}
        for i in range(N):
            if not i + 1 in map:
                map[i + 1] = [-1]
        for time in times:
            map[time[0]].append([-1, time])  # information about the time to here, the directions.
            
        stack = [K]
        map[K][0] = 0
        count = 1;  # visited nodes
        count2 = 1
        # tmp = {}
        while (len(stack) != 0):
            key = stack.pop()
            for i, v in enumerate(map[key]):  # BFS search the nodes
                # first node is for time only
                if i == 0:
                    continue
                if map[v[1][1]][0] == -1:
                    # not visited yet   
                    count += 1
                    # set the following times
                    map[v[1][1]][0] = map[key][0] + v[1][2] 
                    stack.append(v[1][1])
                else:
                    if map[v[1][1]][0] >  map[key][0] + v[1][2]:
                        map[v[1][1]][0] = map[key][0] + v[1][2]
                        stack.append(v[1][1])
            # check all the times
            # if len(tmp) == len(times):
            #     break
        if count != N:
            return -1
        # calculate the max time
        time = 0;
        for k, v in map.items():
            time = max(v[0], time)
        return time