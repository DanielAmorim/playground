### Description

Given an array of integers, return the length of the longest signal alternate elements sequence that match one of the following rules:
* nums[idx] <= 0 && nums[idx+1] >= 0 && nums[idx+2] <= 0  
* nums[idx] >= 0 && nums[idx+1] <= 0 && nums[idx+2] >= 0

#### Example 1:
```
Input: nums = [5, -1, 6]
Output: 3
```

#### Example 2:
```
Input: nums = [3, 0, 4]
Output: 3
```

#### Example 3:
```
Input: nums = [2, 1, 0, 3, 0, 0, 3]
Output: 5
```