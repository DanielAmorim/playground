Source: https://leetcode.com/problems/same-tree/description

### Description

Given the roots of two binary trees `p` and `q`, write a function to check if they are the same or not.

Two binary trees are considered the same if they are structurally identical, and the nodes have the same value.

#### Example 1:
![Example1](./resources/example1.jpg)
```
Input: p = [1,2,3], q = [1,2,3]
Output: true
```

#### Example 2:
![Example1](./resources/example2.jpg)
```
Input: p = [1,2], q = [1,null,2]
Output: false
```

#### Example 3:
![Example3](./resources/example3.jpg)
```
Input: p = [1,2,1], q = [1,1,2]
Output: false
```

#### Constraints:

* The number of nodes in the tree is in the range `[0, 100]`.
* `-10⁴ <= Node.val <= 10⁴`