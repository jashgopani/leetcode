class Solution:
    def minEatingSpeed(self, piles: List[int], h: int) -> int:
        left, right = 1, max(piles)
        speed = right

        while(left <= right):
          k = (left+right)//2
          time = sum(ceil(p/k) for p in piles)
          if time <= h:
            speed = min(speed,k)
            right = k-1
          else:
            left = k+1
        
        return speed        
