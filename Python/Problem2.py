class Solution:
    def minPatches(self, nums: List[int], n: int) -> int:
        miss = 1
        added = 0
        i = 0
        
        while miss <= n:
            if i < len(nums) and nums[i] <= miss:
                miss += nums[i]
                i += 1
            else:
                miss += miss
                added += 1
        
        return added
