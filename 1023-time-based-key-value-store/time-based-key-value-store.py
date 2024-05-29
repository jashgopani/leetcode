import heapq
from collections import defaultdict
class TimeMap:

    def __init__(self):
      self.map = {}       

    def set(self, key: str, value: str, timestamp: int) -> None:
      # print(f"\nset: {key},{timestamp} -> {value}")
      if key not in self.map:
        self.map[key] = [(timestamp,value)]
        heapq.heapify(self.map[key])
      else:
        heapq.heappush(self.map[key],(timestamp,value))
      # print(f"after set: {self.map}\n")

    def get(self, key: str, timestamp: int) -> str:
      res = ""
      if key in self.map and len(self.map[key])>0:
        records = self.map[key]
        # print(f"\nget({key},{timestamp}) -> {records}")
        l, r = 0, len(records)-1
        while l <= r:
          m = (l+r)//2
          # print("l,r,m,record",l,r,m, records[m])
          ts, value = records[m][0], records[m][1]
          if ts <= timestamp:
            res = value

          if l==r:
            # print(f"l==r @ {records[m]}")
            break
          
          if ts==timestamp:
            return value
          elif timestamp > ts:
            res = value
            l = m+1
          else:
            r = m-1
      return res


# Your TimeMap object will be instantiated and called as such:
# obj = TimeMap()
# obj.set(key,value,timestamp)
# param_2 = obj.get(key,timestamp)